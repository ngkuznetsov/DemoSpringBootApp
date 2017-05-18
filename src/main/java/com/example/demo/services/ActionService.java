package com.example.demo.services;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ActionService {

    static Logger log = Logger.getLogger(ActionService.class);

    public static void createThread(int count) {
        for(int i = 0; i < count; i++) {
            (new Thread(new DemoThread())).start();
        }
    }

    public static void gc() {
        log.info("Running GC");
        System.gc();
    }
}

class DemoThread implements Runnable {

    static Logger log = Logger.getLogger(DemoThread.class);

    public void run() {
        BasicConfigurator.configure();
        log.debug("Thread created, sleeping for 5 seconds");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.warn(e.getMessage());
            log.debug(e.getStackTrace());
        }
    }
}