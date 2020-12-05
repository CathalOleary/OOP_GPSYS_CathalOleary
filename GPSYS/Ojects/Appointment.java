package GPSYS.Ojects;

import java.util.GregorianCalendar;

public class Appointment {
    private String startT;
    private String endT;
    private Patient patient;
    private Appointment appointment[];

    public Appointment(String startT,String endT,Patient patient) {
        setEndT(endT);
        setStartT(startT);
        setPatient(patient);
    }

    public Appointment(String text, String text1, String text2, String text3, GregorianCalendar dateOfBirthGC) {
    }

    public Appointment() {

    }

    public String getStartT() {
        return startT;
    }

    public void setStartT(String startT) {
        this.startT = startT;
    }

    public String getEndT() {
        return endT;
    }

    public void setEndT(String endT) {
        this.endT = endT;
    }

    public Patient getPPSN() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "StartT: " + startT +
                "  EndT: " + endT +
                " Patient: " + patient.getPPSN();
    }
}

