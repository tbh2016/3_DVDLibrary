/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.advice;

import com.sg.dvdlibrary.dao.DVDLibraryDaoAudit;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author yingy
 */
public class LoggingAdvice {
    
    DVDLibraryDaoAudit auditDao;
 
    public LoggingAdvice(DVDLibraryDaoAudit auditDao) {
        this.auditDao = auditDao;
    }
 
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (DVDLibraryDaoException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
