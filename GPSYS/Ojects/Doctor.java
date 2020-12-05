package GPSYS.Ojects;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

public class Doctor {
    private String Name;
    private int ID;

    public Doctor(String Name , int ID)
    {
        setName(Name);
        setID(ID);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String toString() {
        return "Name:  "+getName()+ " - DoctorID:  "+getID();
    }


}
