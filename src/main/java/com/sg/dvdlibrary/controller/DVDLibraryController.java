/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author THUAN HUYNH
 */
public class DVDLibraryController {

    //DVDLibraryView view = new DVDLibraryView();
    //DVDLibraryDao dao = new DVDLibraryDaoFileImpl();        //dvd interface instantiated to dvdlibrarydaofileimple
    //private UserIO io = new UserIOConsoleImpl();        //user input interface instantiated to userioconsolerimple
    DVDLibraryView view;            //one object doesn't instantiate another object so we have this here
    DVDLibraryServiceLayer service;      //object the dao interface and the view(handles user i/o logic)

    public DVDLibraryController(DVDLibraryServiceLayer service, DVDLibraryView view) {
        this.service = service;         //constructor instantiates dao and view
        this.view = view;
    }

    public void run() {             //run method that uses another method on the bottom, which orchestrates whatever is in the view
        boolean keepGoing = true;
        int menuSelection = 0;
        try {        //The try statement lets you test a block of code for errors.
            //The catch statement lets you handle the error.

            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        searchDvd();
                        break;
                    case 7:
                        exitMessage();
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }

        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection(); //made a call on the view member 
    }

    //The throw statement lets you create custom errors, REFERS TO THE EXCEPTION CLASS
    private void createDvd() throws DVDLibraryDaoException {          //method to create new dvd
        view.displayCreateDvdBanner();      //display create banner in view
        DVD newDvd = view.getNewDvdInfo();  //shows prompt from view for user input a bunch of dvd info and it is saved
        service.addDvd(newDvd.getDvdId(), newDvd);  //dao add dvds id, newDvd is all the new information for the dvd id, "HASHMAP"
        view.displayCreateSuccessBanner();  //display success banner
    }

    private void listDvds() throws DVDLibraryDaoException {       //method that will get list of dvds in the system
        view.displayDisplayAllBanner();     //banner
        List<DVD> dvdList = service.getAllDvds();   //refers to the getAllDvds method in the dao interface that connects to the implementation class that connects to the DVD dto to get all the dvds stored in text
        view.displayDvdList(dvdList);       //refers to the view file to view all dvds in the list according to the method in the view file
    }

    private void viewDvd() throws DVDLibraryDaoException {
        view.displayDisplayDvdBanner();         //ask the view to display View Dvd banner
        String dvdId = view.getDvdIdChoice();   //prompt for dvd id
        DVD dvd = service.getDvd(dvdId);        //get the dvd id in the DAO
        view.displayDvd(dvd);           //display dvd definition, it not in text file its displays null
    }

    private void removeDvd() throws DVDLibraryDaoException {
        view.displayRemoveDvdBanner();          //banner
        String dvdId = view.getDvdIdChoice();   //prompt for dvd id
        service.removeDvd(dvdId);           //remove the dvdId
        view.displayRemoveSuccessBanner();  //banner
    }

    private void editDvd() throws DVDLibraryDaoException {
        view.displayEditDvdBanner();       //banner
        String dvdId = view.getDvdIdChoice();  //prompt for dvd id
        DVD dvd = service.editDvd(dvdId);      //reference editDvd in the dao interface which will remove old dvdId and replace it with a new one
        int choice = view.displayEditDvdChoiceList();   //display view and to user for a number between 1 and 5
        view.displayEditDvdChoice(choice, dvd); //banner that displays choice key and the object of editDvd
        service.addDvd(dvdId, dvd); //dao adds dvdId and the dvd object that was changed
        view.displayEditSuccessBanner(); //banner

    }

    private void searchDvd() throws DVDLibraryDaoException {
        view.displayDisplayDvdBanner();     //ask the view to display View Dvd banner 
        String title = view.getTitleDvd();  //get dvd ID from user from view, then it asks the DAO for the dvd associated with the ID
        DVD dvd = service.getDvdByTitle(title); //finally it asks the view to display Dvd information
        if (dvd == null) {          //IF DVD IS NOTHING DISPLAY BANNER 'NOT FOUND' ELSE DISPLAY THE DVD TITLE
            view.displayDvdNotFound();
        } else {
            view.displayDvd(dvd);
        }
    }

    private void unknownCommand() {         //BANNER FOR UNKNOWN 
        view.displayUnknownCommandBanner(); //calls method that print 
    }

    private void exitMessage() {        //BANNER FOR EXIT
        view.displayExitBanner();   //calls method that prints
    }

}
