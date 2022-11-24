package GPSYS.Ojects;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * An instantiable class which defines the Patient this one contains exception-handling code in some
 * of its mutators to prevent bad input.
 * @author Cathal Oleary
 */

public class Patient {
    private String PPSN;
    private String Forname;
    private String Surname;
    private String Phone;
    private String MedCardN;
    private GregorianCalendar dateOfBirth;
    private String BloodTp;

    //one Patient can only have one Doctor
    private Doctor Doctor;

    /**
     * Patient 6-argument constructor. That calls the 6 mutators method to
     * initialise the attributes of the Patient object with some user supplied values.
     * @param PPSN the ppsn of the Patient.
     * @param medCardN the medical card number of the Patient.
     * @param forname the first name of the Patient.
     * @param surname the surname of the Patient.
     * @param phone the phone number of the Patient.
     * @param dateOfBirth the date of birth of the Patient.
     * @param bloodTp the Blood type of the Patient.
     * @param doctor the doctor of the Patient.
     */

    public Patient(String PPSN, String medCardN, String forname, String surname, String phone,
                   GregorianCalendar dateOfBirth, String bloodTp, Doctor doctor) {
        setPPSN(PPSN);
        setMedCardN(medCardN);
        setForname(forname);
        setSurname(surname);
        setPhone(phone);
        setDateOfBirth(dateOfBirth);
        setBloodTp(bloodTp);
        setDoctor(doctor);
    }

    /**
     * Method to get the PPSN of the Patient object
     * @return a String value specifying the ppsn of the Patient.
     */

    public String getPPSN()
    {
        return PPSN;
    }

    /**
     * Method to set the PPSN of the Patient and to check if the PPSN
     * enter is validated
     * @param PPSN the PPSN of the Patient.
     */

    public void setPPSN(String PPSN)
    {
        if(PPSN==null || PPSN.equals(""))
            JOptionPane.showMessageDialog(null,"You must enter a valid PPSN!","Error",JOptionPane.ERROR_MESSAGE);
        else
            this.PPSN=PPSN;
    }

    /**
     * Method to get the first name of the Patient object
     * @return a String value specifying the first name of the Patient.
     */

    public String getForname()
    {
        return Forname;
    }

    /**
     * Method to set the first name of the Patient and to check if the first name
     * enter is validated
     * @param forname the first name of the Patient.
     */

    public void setForname(String forname)
    {
        if(forname==null || forname.equals(""))
            JOptionPane.showMessageDialog(null,"You must enter a valid First name!","Error",JOptionPane.ERROR_MESSAGE);
        else
           this.Forname=forname;
    }

    /**
     * Method to get the surname of the Patient object
     * @return a String value specifying the surname of the Patient.
     */

    public String getSurname()
    {
        return Surname;
    }

    /**
     * Method to set the surname of the Patient and to check if the surname
     * enter is validated
     * @param surname the surname of the Patient.
     */

    public void setSurname(String surname)
    {
        if(surname==null || surname.equals(""))
            JOptionPane.showMessageDialog(null,"You must enter a valid Last name!","Error",JOptionPane.ERROR_MESSAGE);
        else
            this.Surname=surname;
    }

    /**
     * Method to get the phone number of the Patient object
     * @return a String value specifying the phone number of the Patient.
     */

    public String getPhone()
    {
        return Phone;
    }

    /**
     * Method to set the phone number of the Patient and to check if the phone
     * number enter is validated
     * @param phone the phone number of the Patient.
     */

    public void setPhone(String phone)
    {
        if(!(phone.charAt(0)=='0') && !(phone.charAt(1)=='8'))
           JOptionPane.showMessageDialog(null,"You must enter a valid Phone Number!","Error",JOptionPane.ERROR_MESSAGE);
        else
           this.Phone=phone;
    }

    /**
     * Method to get the medical Card number of the Patient object
     * @return a String value specifying the medical Card number of the Patient.
     */

    public String getMedCardN() {
        return MedCardN;
    }

    /**
     * Method to get the medical blood type of the Patient object
     * @return a String value specifying the blood type of the Patient.
     */

    public String getBloodTp() {
        return BloodTp;
    }

    /**
     * Method to set the medical Card number of the Patient object
     * @param medCardN the medical card number of the Patient.
     */

    public void setMedCardN(String medCardN) {
        this.MedCardN = medCardN;
    }

    /**
     * Method to get the Date of birth from the date chooser Class
     * @return a String value specifying the date of birth for the Patient.
     */

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Method to set the date of birth of the Patient object
     * @param dateOfBirth the date of birth of the Patient.
     */

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Method to set the blood type of the Patient object
     * @param bloodTp the blood type of the Patient.
     */

    public void setBloodTp(String bloodTp) {
        this.BloodTp = bloodTp;
    }

    /**
     * Method to get the Doctor from the Doctor Object
     * @return a String value specifying the doctor for the Patient.
     */

    public GPSYS.Ojects.Doctor getDoctor() {
        return Doctor;
    }

    /**
     * Method to set the Doctor of the Patient object
     * @param doctor the Doctor of the Patient
     */

    public void setDoctor(GPSYS.Ojects.Doctor doctor) {
        this.Doctor = doctor;
    }

    /**
     *Method to get the state of the Patient object.
     * @return a String value specifying the state of Patient object.
     */

    @Override
    public String toString() {
        String dateOfBirth;

        if (getDateOfBirth()==null)
            dateOfBirth="No date of birth specified";
        else {

            if (this.dateOfBirth.get(Calendar.DATE) < 10)
                dateOfBirth="0"+this.dateOfBirth.get(Calendar.DATE);
            else
                dateOfBirth=""+this.dateOfBirth.get(Calendar.DATE);

            if (this.dateOfBirth.get(Calendar.MONTH) + 1 < 10)
                dateOfBirth+="-0"+(this.dateOfBirth.get(Calendar.MONTH) + 1);
            else
                dateOfBirth+="-"+(this.dateOfBirth.get(Calendar.MONTH) + 1);

            dateOfBirth+="-"+this.dateOfBirth.get(Calendar.YEAR);
        }


        return  " PPSN: "+getPPSN()+"  "+
                "Forename: "+getForname()+"  "+
                "Surname: "+getSurname()+"  "+
                "Date of Birth: "+dateOfBirth+"  "+
                "Phone:  "+getPhone()+"  "+
                "Medical Card Number: "+getMedCardN();
    }
}
