package GPSYS.Ojects;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

/**
 * An instantiable class which defines the Time object.
 * @author Cathal Oleary
 */

public class Time extends Appointment {
    private int Hour, Min, Sec;

    /**
     * Time 3-argument constructor. That calls the 3 mutators method to
     * initialise the attributes of the Time object.
     * @param hour the hours of the Time object
     * @param min the minutes of the Time object
     * @param sec the seconds of the Time object.
     */

    public Time(int hour, int min, int sec) {
        setHour(hour);
        setMin(min);
        setSec(sec);
    }

    /**
     * Method to get the hours of the Time object
     * @return the integer value specifying the hours of the Time.
     */

    public int getHour() {
        return Hour;
    }

    /**
     * Method to set the hours of the Time object
     * @param hour the hours of the Time Object.
     */

    public void setHour(int hour) {
        if(hour>=1 && hour<24)
            this.Hour=hour;
        else
            this.Hour=1;
    }

    /**
     * Method to get the minutes of the Time object
     * @return the integer value specifying the minutes of the Time.
     */

    public int getMin() {
        return Min;
    }

    /**
     * Method to set the minutes of the Time object
     * @param min the minutes of the Time Object.
     */

    public void setMin(int min) {
        if(min>=1 && min<60)
            this.Min=min;
        else
            this.Min=0;
    }

    /**
     * Method to get the seconds of the Time object
     * @return the integer value specifying the seconds of the Time.
     */

    public int getSec() {
        return Sec;
    }

    /**
     * Method to set the seconds of the Time object
     * @param sec the seconds of the Time Object.
     */

    public void setSec(int sec) {
        if(sec>=1 && sec<60)
            this.Sec=sec;
        else
            this.Sec=0;
    }

    /**
     * Method to get the state of the Time object.
     * @return a String value specifying the state of Time object.
     */

    @Override
    public String toString() {
        String text="";
        if(getHour()>=10){
            text+=getHour()+":";
        }
        else {
            text+=0+getHour()+":";
        }

        if(getMin()>=10){
            text+=getMin()+":";
        }
        else {
            text+=0+getMin()+":";
        }

        if(getSec()>=10){
            text+=getSec();
        }
        else {
            text+=0+getSec();
        }
        return text;
    }
}
