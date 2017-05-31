/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author THUAN HUYNH
 */
public class DVD {                         //DVD INFORMATION

    private String dvdId;
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
   
   
    public DVD(String dvdId) {               //reads in a string 
        this.dvdId = dvdId;                 //shadows the parameter of String dvdId
    }

    public String getDvdId() {             //is a read-
        return dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setID(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return "ID: " + dvdId + " |Title " + title + " |Release Date: "
                + releaseDate + " |Rating: " + rating  + " |Director: " + 
                director + " |Studio: " + studio;
    }

}
