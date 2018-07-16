/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application.entities;

/**
 *
 * @author arseniy
 */
public class FormCounter {
    private final int count;
    private final String formid;

    public FormCounter(int count, String formid) {
        this.count = count;
        this.formid = formid;
    }

    public int getCount() {
        return count;
    }

    public String getFormid() {
        return formid;
    }
    
}
