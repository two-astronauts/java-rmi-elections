/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Departament implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int registered;
    private int white;
    private int group1;
    private int group2;
    private int group3;
    private float abstentionPercent;
    private float whitePercent;
    private float group1Percent;
    private float group2Percent;
    private float group3Percent;

    public Departament(String name, int registered, int white, int group1, int group2, int group3) {
        this.name = name;
        this.registered = registered;
        this.white = white;
        this.group1 = group1;
        this.group2 = group2;
        this.group3 = group3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    public int getWhite() {
        return white;
    }

    public void setWhite(int white) {
        this.white = white;
    }

    public int getGroup1() {
        return group1;
    }

    public void setGroup1(int group1) {
        this.group1 = group1;
    }

    public int getGroup2() {
        return group2;
    }

    public void setGroup2(int group2) {
        this.group2 = group2;
    }

    public int getGroup3() {
        return group3;
    }

    public void setGroup3(int group3) {
        this.group3 = group3;
    }

    public float getAbstentionPercent() {
        return abstentionPercent;
    }

    public void setAbstentionPercent(float abstentionPercent) {
        this.abstentionPercent = abstentionPercent;
    }

    public float getWhitePercent() {
        return whitePercent;
    }

    public void setWhitePercent(float whitePercent) {
        this.whitePercent = whitePercent;
    }

    public float getGroup1Percent() {
        return group1Percent;
    }

    public void setGroup1Percent(float group1Percent) {
        this.group1Percent = group1Percent;
    }

    public float getGroup2Percent() {
        return group2Percent;
    }

    public void setGroup2Percent(float group2Percent) {
        this.group2Percent = group2Percent;
    }

    public float getGroup3Percent() {
        return group3Percent;
    }

    public void setGroup3Percent(float group3Percent) {
        this.group3Percent = group3Percent;
    }

}
