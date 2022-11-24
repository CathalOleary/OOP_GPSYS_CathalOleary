package GPSYS.Ojects;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

/**
 * An instantiable class which defines the Doctor Object and this also contents Validation.
 * @author Cathal Oleary
 */

public class Doctor {
    private String Name;
    private int ID;


    /**
     * Appointment 2-argument constructor. That calls the 2 mutators method to
     * initialise the attributes of the Doctor object which is already hard coded in.
     * @param Name the Name of the Doctor.
     * @param ID The id of the Doctor.
     */

    public Doctor(String Name , int ID)
    {
        setName(Name);
        setID(ID);
    }

    /**
     * Method to get the Name of the Doctor object
     * @return a String value specifying the Name of the Doctor.
     */

    public String getName() {
        return Name;
    }

    /**
     * Method to set the Name of the Doctor object
     * @param name the name of the Doctor.
     */

    public void setName(String name) {
        this.Name = name;
    }

    /**
     * Method to get the id of the Doctor object
     * @return an integer value specifying the id of the Doctor.
     */

    public int getID() {
        return ID;
    }

    /**
     * Method to set the id of the Doctor object
     * @param ID the name of the Doctor.
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *Method to get the state of the Doctor object.
     * @return a String value specifying the state of Doctor object.
     */

    public String toString() {
        return "Name:  "+getName()+ " - DoctorID:  "+getID();
    }


}
