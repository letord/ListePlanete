package com.appli.listeplante;

import java.util.ArrayList;

public class Data {
    String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
    private ArrayList<String> planetes;

    public Data(){
        installePlanetes();
    }

    public ArrayList<String> getPlanetes() {
        return planetes;
    }
    public String[] getTaillePlanetes() {
        return taillePlanetes;
    }
    public String getTaillePlanetes(int i) {
        return taillePlanetes[i];
    }

    private void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
        planetes.add("Pluton");
    }
}
