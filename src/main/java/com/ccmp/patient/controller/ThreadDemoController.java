package com.ccmp.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class ThreadDemoController {
    
    private static final Logger log = LoggerFactory.getLogger(ThreadDemoController.class);
    
    @GetMapping("/threads")
    public String checkThread(){
        Thread currentThread = Thread.currentThread();
        log.info("API Request handled by Thread: {}" , currentThread);

        return String.format("Thread Name: %s | Is Virtual: %b", currentThread.getName(), currentThread.isVirtual());
    }



}
