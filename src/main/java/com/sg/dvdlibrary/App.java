package com.sg.dvdlibrary;

//import com.sg.dvdlibrary.controller.DVDLibraryController;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.sg.dvdlibrary.dao.DVDLibraryDao;
//import com.sg.dvdlibrary.dao.DVDLibraryDaoAudit;
//import com.sg.dvdlibrary.dao.DVDLibraryDaoAuditImpl;
//import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
//import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
//import com.sg.dvdlibrary.service.DVDLibraryServiceLayerImpl;
//import com.sg.dvdlibrary.ui.DVDLibraryView;
//import com.sg.dvdlibrary.ui.UserIO;
//import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

/*
 * To change this license header, choose License Headers1 in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**  
 *
 * @author THUAN HUYNH
 */
public class App {

    public static void main(String[] args) {
//        UserIO myIo = new UserIOConsoleImpl();//userio instantiates into a new userioconsoleimpl
//        DVDLibraryView myView = new DVDLibraryView(myIo);//dvdlibraryview instantiates into new dvdlibraryview
//        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();//dvdlibrarydao instantiates into a new dvdlibrarydaofileimpl
//        DVDLibraryDaoAudit audit = new DVDLibraryDaoAuditImpl();
//        DVDLibraryServiceLayer service = new DVDLibraryServiceLayerImpl(myDao, audit);
//        DVDLibraryController controller = new DVDLibraryController(service, myView);//dvdlibrarycontroller instantiates iibnto new dvdlibrarycontroller
//        controller.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDLibraryController controller = ctx.getBean("controller", DVDLibraryController.class);
        controller.run();
    }
}
