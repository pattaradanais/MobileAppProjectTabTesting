package kku.sukruam.pattaradanai.tabtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patipan on 9/21/2016 AD.
 */

public class bake {
    private int resId;
    private String bakegrill;
    private String description;

    List<bake> bakes = new ArrayList<>();

    bake() {

    }

    bake(int resId, String bakegrill, String description) {
        this.resId = resId;
        this.bakegrill = bakegrill;
        this.description = description;
    }
    bake(int resId, String bakegrill) {
        this.resId = resId;
        this.bakegrill = bakegrill;

    }


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getBakegrill() {
        return bakegrill;
    }

    public void setBakegrill(String bakegrill) {this.bakegrill= bakegrill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<bake> getBakes() {
        return bakes;
    }

    public void setBakes(List<bake> bakes) {
        this.bakes = bakes;
    }
}

