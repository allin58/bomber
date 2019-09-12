package com.codenjoy.dojo.bomberman.client;

import java.util.ArrayList;

public class DrunkenSailorPlan {

    static DrunkenSailorPlan drunkenSailorPlan;


    public boolean isManeuver = false;

    private DrunkenSailorPlan() {
    }

    static public DrunkenSailorPlan getInstance(){

        if (drunkenSailorPlan == null) {
            drunkenSailorPlan = new DrunkenSailorPlan();
        }
        return drunkenSailorPlan;

    }

    public boolean isManeuver() {
        return isManeuver;
    }

    public void setManeuver(boolean maneuver) {
        isManeuver = maneuver;
    }

    ArrayList<String> arrayList = new ArrayList<>();

    int stage = 0;


    public String execute(Board board,String directional){
if(stage == 0  ){
    arrayList.clear();
    fillArrayList(directional);
}
if (stage == 3){
    stage = -1;
    isManeuver = false;
}

       if (stage == -1) {
           stage = 0;
           arrayList.get(3);
       }

        return arrayList.get(stage++);
    }

    void fillArrayList(String directional) {
        if (directional.equals("UP")) {
            arrayList.add("ACT,DOWN");
            arrayList.add("DOWN");
            arrayList.add("DOWN");
            arrayList.add("DOWN");
        }
        if (directional.equals("DOWN")) {
            arrayList.add("ACT,UP");
            arrayList.add("UP");
            arrayList.add("UP");
            arrayList.add("UP");
        }
        if (directional.equals("RIGHT")) {
            arrayList.add("ACT,LEFT");
            arrayList.add("LEFT");
            arrayList.add("LEFT");
            arrayList.add("LEFT");
        }

        if (directional.equals("LEFT")) {
            arrayList.add("ACT,RIGHT");
            arrayList.add("RIGHT");
            arrayList.add("RIGHT");
            arrayList.add("RIGHT");
        }


    }




}
