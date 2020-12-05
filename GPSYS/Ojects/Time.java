package GPSYS.Ojects;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

public class Time {
    private int Hour , Min , Sec;

    public Time(int hour, int min, int sec) {
        setHour(hour);
        setMin(min);
        setSec(sec);
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        if(hour>=1 && hour<24)
            this.Hour=hour;
        else
            this.Hour=1;
    }

    public int getMin() {
        return Min;
    }

    public void setMin(int min) {
        if(min>=1 && min<60)
            this.Min=min;
        else
            this.Min=0;
    }

    public int getSec() {
        return Sec;
    }

    public void setSec(int sec) {
        if(sec>=1 && sec<60)
            this.Sec=sec;
        else
            this.Sec=0;
    }

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
