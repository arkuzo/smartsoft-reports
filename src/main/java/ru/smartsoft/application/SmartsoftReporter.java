/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author arseniy
 */
@ComponentScan
@EnableAutoConfiguration
public class SmartsoftReporter {
    
    public static void main(String[] args) {
        SpringApplication.run(SmartsoftReporter.class, args);
    }
    
}
