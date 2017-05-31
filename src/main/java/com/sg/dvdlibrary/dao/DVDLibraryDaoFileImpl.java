/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author THUAN HUYNH
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String ROSTER_FILE = "roster.txt";  //roster file is equals to roster.txt
    public static final String DELIMITER = " :: ";  //delimiter is what a display for splitting the dvd information

    private Map<String, DVD> dvds = new HashMap<>();        //dvds instantiation will be a new existing HashMap each time it is called upon

    @Override
    public DVD addDvd(String dvdId, DVD dvd) //adds a new dvd to the map            addDvd(newDvd.getDvdId(), newDvd)
            throws DVDLibraryDaoException {         //throws custom error
        loadRoster();
        DVD newDvd = dvds.put(dvdId, dvd);  //put new dvdId, dvd object
        writeRoster();  //calls the writeRoster method 
        return newDvd;  //returns new dvd information
    }

    @Override
    public List<DVD> getAllDvds()   //getall the dvds to display
            throws DVDLibraryDaoException {
        loadRoster();           //calls the loadroster to load text file
        return new ArrayList<DVD>(dvds.values());       //gets all dvd objects out of dvd map as a collection by calling values() method
    }

    @Override
    public DVD getDvd(String dvdId) //
            throws DVDLibraryDaoException {       //ask the dvd map for the dvd object with the given ID and return it
        loadRoster();
        return dvds.get(dvdId);
    }

    @Override
    public DVD removeDvd(String dvdId)
            throws DVDLibraryDaoException {    //ask the dvd map to remove the dvd object mapped with the given ID
        loadRoster();
        DVD removedDvd = dvds.remove(dvdId);
        writeRoster();
        return removedDvd;
    }

    @Override
    public DVD editDvd(String dvdId) 
    throws DVDLibraryDaoException{    //ask the dvd map to get the dvd object mapped with the given ID
        loadRoster();
        DVD editDvd = dvds.remove(dvdId);   //remove dvdId 
        writeRoster();
        return editDvd;                 //return new dvdId
    }

    @Override
    public DVD searchDvd(String dvdId) {    //ask the dvd map to get the dvd object mapped with the given ID
        DVD searchDvd = dvds.get(dvdId);
        return searchDvd;
    }

    @Override
    public DVD getDvdByTitle(String title) throws DVDLibraryDaoException {
        for (String dvdID : dvds.keySet()) {                //FOR LOOP, FIRST IT GETS THE DVD ID
            String dvdTitle = dvds.get(dvdID).getTitle();   //HASHMAP GETS ID KEY AND ID GETS TITLE
            if (title.equals(dvdTitle)) //IF THE INPUT TITLE EQUALS DVDTITLE
            {
                return dvds.get(dvdID);             //RETURN DVD ID
            }

        }
        return null;
    }

    private void loadRoster() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.",e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens will be a string array that looks like this:
        //
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]         [3]
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Student object and put it into the map of students
            // NOTE FOR APPRENTICES: We are going to use the student id
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the student id into the Student constructor
            DVD currentDvd = new DVD(currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentDvd.setTitle(currentTokens[1]);
            currentDvd.setReleaseDate(currentTokens[2]);
            currentDvd.setRating(currentTokens[3]);
            currentDvd.setDirector(currentTokens[4]);
            currentDvd.setStudio(currentTokens[5]);

            // Put currentStudent into the map using studentID as the key
            dvds.put(currentDvd.getDvdId(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeRoster() throws DVDLibraryDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<DVD> dvdList = this.getAllDvds();
        for (DVD currentDvd : dvdList) {
            // write the Student object to the file
            out.println(currentDvd.getDvdId() + DELIMITER
                    + currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getRating() + DELIMITER
                    + currentDvd.getDirector() + DELIMITER
                    + currentDvd.getStudio());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
