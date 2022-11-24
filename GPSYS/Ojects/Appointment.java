package GPSYS.Ojects;

import java.util.GregorianCalendar;

/**
 * An instantiable class which defines an Appointment this also contents Validation.
 * @author Cathal Oleary
 */

public class Appointment {
    private String startT;
    private String endT;
    private Patient patient;
    private Appointment appointment[];

    /**
     * Appointment 3-argument constructor. That calls the 3 mutators method to
     * initialise the attributes of the Appointment object with some user supplied values.
     * @param startT the starting time of the Appointment
     * @param endT the end time of the Appointment
     * @param patient .
     */

    public Appointment(String startT,String endT,Patient patient) {
        setEndT(endT);
        setStartT(startT);
        setPatient(patient);
    }

    public Appointment(String text, String text1, String text2, String text3, GregorianCalendar dateOfBirthGC) {
    }

    public Appointment() {

    }

    /**
     * Method to get the Starting Time of the Appointment object
     * @return a String value specifying the Starting Time.
     */

    public String getStartT() {
        return startT;
    }

    /**
     * Method to sets the Starting Time of the Appointment object
     * @param startT the starting time of the Appointment.
     */

    public void setStartT(String startT) {
        this.startT = startT;
    }

    /**
     * Method to get the Ending Time of the Appointment object
     * @return a String value specifying the Ending Time.
     */

    public String getEndT() {
        return endT;
    }

    /**
     * Method to sets the Ending Time of the Appointment object
     * @param endT the end time of the Appointment.
     */

    public void setEndT(String endT) {
        this.endT = endT;
    }

    /**
     * Method to get the PPSN Number of the patient object
     * @return a String value specifying the PPSN Number.
     */

    public Patient getPPSN() {
        return patient;
    }

    /**
     * Method to sets the patient of the patient object
     * @param patient .
     */

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     *Method to get the state of the appointment object.
     * @return a String value specifying the state of Appointment object.
     */

    @Override
    public String toString() {
        return "StartT: " + startT +
                "  EndT: " + endT +
                " Patient: " + patient.getPPSN();
    }
}

