package com.arsalan.transporttracker;

public class busListModel {

    String PointName;
    String DriverName;
    String Location;
    String Date;
    private boolean expanded;

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }
}
