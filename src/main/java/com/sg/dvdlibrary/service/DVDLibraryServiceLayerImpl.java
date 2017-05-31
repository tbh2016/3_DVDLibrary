/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoAudit;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author yingy
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer{

    DVDLibraryDao dao;
    private DVDLibraryDaoAudit audit;
    
    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryDaoAudit audit) {
        this.dao = dao;
        this.audit = audit;
    }
    
    @Override
    public DVD addDvd(String dvdId, DVD poop) throws DVDLibraryDaoException {
//        audit.writeAuditEntry(
//                "DVD " + poop.getTitle() + " CREATED.");
        return dao.addDvd(dvdId, poop);  
    }

    @Override
    public List<DVD> getAllDvds() throws DVDLibraryDaoException {
        return dao.getAllDvds();
    }

    @Override
    public DVD getDvd(String dvdId) throws DVDLibraryDaoException {
        return dao.getDvd(dvdId);
    }

    @Override
    public DVD removeDvd(String dvdId) throws DVDLibraryDaoException {
//        audit.writeAuditEntry(
//                "DVD " + dvdId + " REMOVED.");
        return dao.removeDvd(dvdId);   
    }

    @Override
    public DVD editDvd(String dvdId) throws DVDLibraryDaoException {
//        audit.writeAuditEntry(
//                "DVD " + dvdId + " EDITED.");  
        
        return dao.editDvd(dvdId);
    }

    @Override
    public DVD searchDvd(String dvdId) throws DVDLibraryDaoException {
        return dao.searchDvd(dvdId);
    }

    @Override
    public DVD getDvdByTitle(String title) throws DVDLibraryDaoException {
        return dao.getDvdByTitle(title);
    }
    
}
