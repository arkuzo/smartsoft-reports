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
public class FormRequest {
    
    private final String ssoid;
    private final String formid;
    private final String ymdh;
    private final String subtype;

    public FormRequest(String ssoid, String formid, String ymdh, String subtype) {
        this.ssoid = ssoid;
        this.formid = formid;
        this.ymdh = ymdh;
        this.subtype = subtype;
    }

    public String getSsoid() {
        return ssoid;
    }

    public String getFormid() {
        return formid;
    }

    public String getYmdh() {
        return ymdh;
    }

    public String getSubtype() {
        return subtype;
    }
    
}
