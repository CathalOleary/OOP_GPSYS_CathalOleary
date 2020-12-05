package GPSYS.Ojects;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Patient {
    private String PPSN;
    private String Forname;
    private String Surname;
    private String Phone;
    private String MedCardN;
    private GregorianCalendar dateOfBirth;
    private String BloodTp;
    //one Patients can only have one Doctor
    private Doctor Doctor;

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
    public String getPPSN()
    {
        return PPSN;
    }

    public void setPPSN(String PPSN)
    {
        if(PPSN==null || PPSN.equals(""))
            JOptionPane.showMessageDialog(null,"You must enter a valid PPSN!","Error",JOptionPane.ERROR_MESSAGE);
        else
            this.PPSN=PPSN;
    }

    public String getForname()
    {
        return Forname;
    }

    public void setForname(String forname)
    {
        if(forname==null || forname.equals(""))
            JOptionPane.showMessageDialog(null,"You must enter a valid First name!","Error",JOptionPane.ERROR_MESSAGE);
        else
           this.Forname=forname;
    }

    public String getSurname()
    {
        return Surname;
    }

    public void setSurname(String surname)
    {
        if(surname==null || surname.equals(""))
            JOptionPane.showMessageDialog(null,"You must enter a valid Last name!","Error",JOptionPane.ERROR_MESSAGE);
        else
            this.Surname=surname;
    }

    public String getPhone()
    {
        return Phone;
    }

    public void setPhone(String phone)
    {
        if(!(phone.charAt(0)=='0') && !(phone.charAt(1)=='8'))
             JOptionPane.showMessageDialog(null,"You must enter a valid Phone Number!","Error",JOptionPane.ERROR_MESSAGE);
        else
           this.Phone=phone;
    }

    public String getMedCardN() {
        return MedCardN;
    }

    public void setMedCardN(String medCardN) {
        this.MedCardN = medCardN;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodTp() {
        return BloodTp;
    }

    public void setBloodTp(String bloodTp) {
        this.BloodTp = bloodTp;
    }

    public GPSYS.Ojects.Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(GPSYS.Ojects.Doctor doctor) {
        this.Doctor = doctor;
    }

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
