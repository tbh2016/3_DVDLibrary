/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author THUAN HUYNH
 */
public interface DVDLibraryDao {

    DVD addDvd(String dvdId, DVD dvd) //add dvd to id, to be added to collection, return dvd id if it exist, null otherwise
            throws DVDLibraryDaoException;

    List<DVD> getAllDvds() //returns string array of all the dvd ids of all dvd in collection
            throws DVDLibraryDaoException;

    DVD getDvd(String dvdId) //getting information of dvd id, return dvd object 
            throws DVDLibraryDaoException;

    DVD removeDvd(String dvdId) //dvdId to be removed, return dvd object that was removed otherwise return null
            throws DVDLibraryDaoException;

    DVD editDvd(String dvdId)  //dvdId to be edited
            throws DVDLibraryDaoException;

    DVD searchDvd(String dvdId) //NOT USED AT ALL 
            throws DVDLibraryDaoException;

    DVD getDvdByTitle(String title) //used for seaching the title of DVD
            throws DVDLibraryDaoException;
}
