package GPSYS.Driver;

import GPSYS.GUI.*;
import GPSYS.Ojects.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class is the driver for the application.
 * The code here creates The Doctor Array which there will only be 4 Doctors
 * it also creates the Patient and Appointment array lists.
 * @author Cathal Oleary
 */

public class TestGPSYS extends DateChooser {

    //similar globals to Math.PI
    public static Doctor[] Doctors=new Doctor[4];
    public static ArrayList<Patient>Patients=new ArrayList<>();
    public static ArrayList<Appointment>Appointments=new ArrayList<>();

    public TestGPSYS(JFrame jFrame) {
        super(jFrame);
    }

    /**
     * This Method creates the 4 Doctor objects and puts them into the array with there info.
     * It also Creates 2 example/test Patients and appointments with the need info also.
     * @param args
     */

    public static void main(String[] args) {

        /**
         * This code creates the doctors and Stores there Name
         * and id number. there is only going to be 4 Doctors
         */

        Doctor Doc1=new Doctor("Fred Smith",1);
        Doctor Doc4=new Doctor("Mark Twomey",4);
        Doctor Doc3=new Doctor("Mary Twomey",3);
        Doctor Doc2=new Doctor("James Walsh",2);

        Doctors[0]=Doc1;
        Doctors[1]=Doc2;
        Doctors[2]=Doc3;
        Doctors[3]=Doc4;

        /**
         * This code creates the Patient and Stores their Name, PPSN
         * ,Medical card number, date of birth, Doctors name and Phone number
         * These Patients are just testers.
         */

        Patient p3=new Patient("123451","123456789","kryst","lewa","0871234567",new GregorianCalendar(2000, Calendar.OCTOBER,28),"AB",Doc1);
        Patient p4=new Patient("123468","12156789","krasdfst","lasdfa","0871234567",new GregorianCalendar(2000, Calendar.OCTOBER,28),"AB",Doc1);
        Patients.add(p3);
        Patients.add(p4);
        //new RegPatientGUI();

        /**
         * This code creates the Appointments and stores the
         * start time and end time
         * These Appointment are just testers.
         */

        Appointment App1=new Appointment("17:00","17:30",p4);
        Appointment App2=new Appointment("18:00","18:30",p3);
        Appointments.add(App1);
        Appointments.add(App2);

        MainMenuGUI guiApp = new MainMenuGUI();
    }


}
