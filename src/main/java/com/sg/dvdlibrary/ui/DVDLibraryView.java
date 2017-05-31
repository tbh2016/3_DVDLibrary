/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author THUAN HUYNH
 */
public class DVDLibraryView {

    //UserIO io = new UserIOConsoleImpl();
    private UserIO io;
    
    public DVDLibraryView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Dvd");
        io.print("2. Remove Dvd");
        io.print("3. Edit Dvd");
        io.print("4. List All Dvd");
        io.print("5. Get Dvd Info");
        io.print("6. Search for Title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    //******************************************************************************       

    public DVD getNewDvdInfo() {
        //ask for info and return it to the caller
        String dvdId = io.readString("Please enter dvd id: ");
        String title = io.readString("Please enter dvd title: ");
        String releaseDate = io.readString("Please enter release date: ");
        String rating = io.readString("Please enter rating: ");
        String director = io.readString("Please enter director: ");
        String studio = io.readString("Please enter studio: ");
        DVD currentDvd = new DVD(dvdId);
        currentDvd.setTitle(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setDirector(director);
        currentDvd.setStudio(studio);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create Dvd ===");
    }

    public void displayCreateSuccessBanner() {
        io.enterToContinue(
                "Dvd successfully created.  Please hit enter to continue");
    }
//******************************************************************************    

    public void displayDvdList(List<DVD> dvdList) { //this is a method to list dvd objects as a parameter and display the information for each dvd to the screen
        for (DVD currentDvd : dvdList) {
            io.print(currentDvd.getDvdId() + ": "
                    + currentDvd.getTitle() + " "
                    + currentDvd.getReleaseDate()
                    + currentDvd.getRating());
        }
        io.enterToContinue("Please hit enter to continue."); //will pause and wait for user to hit enter key
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDS ===");
    }
//******************************************************************************    

    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    public String getDvdIdChoice() {                        //ask for input and saves the DVD ID
        return io.readString("Please enter the DVD ID.");
    }

    public void displayDvd(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getDvdId());
            io.print(dvd.getReleaseDate() + " " + dvd.getRating());
            io.print(dvd.getDirector() + " " + dvd.getStudio());
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.enterToContinue("Please hit enter to continue.");
        
    }
//******************************************************************************

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveSuccessBanner() {
        io.enterToContinue("Dvd successfully removed. Please hit enter to continue.");
    }
//******************************************************************************    

    public int displayEditDvdChoiceList() {             //list choice for 5 options to edit and saves the integer

        io.print("1. DVD title");
        io.print("2. Release date");
        io.print("3. Rating");
        io.print("4. Director");
        io.print("5. Studio");

        return io.readInt("=== What would you like to edit? ===", 1, 5);
    }

    public void displayEditDvdChoice(int choice, DVD editChoice) {       //depending on the case, a certain prompt will show up, edit choice will call the specific object   
        boolean keepRunning = true;                                 //and you will replace the new string will its prior string
        while (keepRunning) {   //extra error protection
            switch (choice) {
                case 1:
                    String title = io.readString("Please enter 'new title' you want to edit");
                    editChoice.setTitle(title);
                    keepRunning = false;
                    break;
                case 2:
                    String releaseDate = io.readString("Please enter 'new release date' you want to edit");
                    editChoice.setReleaseDate(releaseDate);
                    keepRunning = false;
                    break;
                case 3:
                    String rating = io.readString("Please enter new 'rating' you want to edit");
                    editChoice.setRating(rating);
                    keepRunning = false;
                    break;
                case 4:
                    String director = io.readString("Please enter new 'director' you want to edit");
                    editChoice.setDirector(director);
                    keepRunning = false;
                    break;
                case 5:
                    String studio = io.readString("Please enter new 'studio' you want to edit");
                    editChoice.setStudio(studio);
                    keepRunning = false;
                    break;
            }
        }

    }

    public void displayEditDvdBanner() {
        io.print("=== Edit Dvd ===");
    }

    public void displayEditSuccessBanner() {
        io.enterToContinue("=== Dvd successfully edited. Please hit enter to continue.");

    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("unknown");
    }

    public void displayExitBanner() {
        io.print("goodbye");
    }

    public String getTitleDvd() {           //ask for string value of title of dvd and saves input using io 
        return io.readString("Please enter title for search");
    }

    public void displayDvdNotFound() {
        io.print("Sorry dvd was not found");
    }

  

    

}

//******************************************************************************

   



