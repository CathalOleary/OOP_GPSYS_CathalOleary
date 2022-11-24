package GPSYS.GUI;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This the class that creates the GUI for the Appointments window
 * @author Cathal Oleary
 */

public class MakeAppointementGUI extends JFrame implements ActionListener {

    private Insets normalInsets = new Insets(15, 10, 0, 10);
    private Insets topInsets = new Insets(15, 10, 0, 10);
    private JTextField PPSNField;
    private JTextField ForeNameField;
    private JTextField SurNameField;
    private JTextField AppointmentDate;
    private JTextField PhoneField;
    private GregorianCalendar dateChosen;
    private JComboBox cmbDoctor;

    public MakeAppointementGUI() {
        super("Make Appointments");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(createDetailsPanel());
        panel.add(Box.createVerticalStrut(40));
        panel.add(createSubmitPanel());
        panel.add(Box.createVerticalStrut(20));

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String args[]) {
        new MakeAppointementGUI();
    }


    private JPanel createDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;
        JLabel PPSNJL = new JLabel("PPSN");
        addComponent(panel, PPSNJL, 0, gridy, 1, 1, topInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        PPSNField = new JTextField(20);
        addComponent(panel, PPSNField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel ForeNameJL = new JLabel("ForeName");
        addComponent(panel, ForeNameJL, 0, gridy, 1, 1, topInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        ForeNameField = new JTextField(25);
        addComponent(panel, ForeNameField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel SurNameJL = new JLabel("SurName");
        addComponent(panel, SurNameJL, 0, gridy, 1, 1, topInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        SurNameField = new JTextField(25);
        addComponent(panel, SurNameField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel PhoneJL = new JLabel("Phone Number");
        addComponent(panel, PhoneJL, 0, gridy, 1, 1, topInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        PhoneField = new JTextField(25);
        addComponent(panel, PhoneField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel doctorN=new JLabel("Choose Doctors Name");
        addComponent(panel,doctorN,0, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        String[] Doctor = new String[]
                {"Fred smith - 1", "Mark Twomey - 4", "Mary Twomey - 3", "James Walsh - 2"};

        cmbDoctor = new JComboBox(Doctor);
        cmbDoctor.addActionListener((ActionListener) this);
        cmbDoctor.setVisible(true);
        add(cmbDoctor);
        panel.add(cmbDoctor);

        JLabel appointmentDatel = new JLabel("AppointmentDate");
        addComponent(panel, appointmentDatel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        AppointmentDate = new JTextField(25);
        AppointmentDate.setText("enter in form dd-mm-yyyy or use date-chooser");
        addComponent(panel, AppointmentDate, 1, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton dateOfBirthButton = new JButton("...");
        dateOfBirthButton.setPreferredSize(new Dimension(20, 15));
        addComponent(panel, dateOfBirthButton, 2, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        dateOfBirthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateChooser dateChooser = new DateChooser(MakeAppointementGUI.this);
                dateChosen = dateChooser.getDateChosen();

                if (dateChosen != null) {
                    System.out.println(dateChosen.get(Calendar.DATE) + "-" +
                            dateChosen.get(Calendar.MONTH) + "-" +
                            dateChosen.get(Calendar.YEAR));

                    String dayString = "", monthString = "";

                    if (dateChosen.get(Calendar.DATE) < 10)
                        dayString = "0" + dateChosen.get(Calendar.DATE);
                    else
                        dayString = "" + dateChosen.get(Calendar.DATE);

                    if (dateChosen.get(Calendar.MONTH) < 10)
                        monthString = "0" + dateChosen.get(Calendar.MONTH);
                    else
                        monthString = "" + dateChosen.get(Calendar.MONTH);

                    AppointmentDate.setText(dayString + "-" + monthString + "-" + dateChosen.get(Calendar.YEAR));
                }
            }
        });
        return panel;
    }

    private void addComponent(Container container, Component componemt, int gridX, int grid,
                              int gridWidth, int gridHeight, Insets insets, int Anchor, int Fill) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints(gridX, grid, gridWidth, gridHeight,
                0.0, 0.0, Anchor, Fill, insets, 5, 5);

        container.add(componemt, gridBagConstraints);
    }

    private JPanel createSubmitPanel() {
        JPanel panel = new JPanel();

        JButton Cancelbutton=new JButton("Cancel");
        Cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuGUI();
                setVisible(false);
            }
        });

        JButton addbutton=new JButton("Add Appointment");
        addbutton.addActionListener(new ActionListener() {

           Appointment appointment=new Appointment();

            @Override
            public void actionPerformed(ActionEvent e) {
                String appointmentDate = AppointmentDate.getText();

                Appointment appointment;

                if (appointmentDate.length() >= 7) {
                    try {
                        int day = Integer.parseInt(appointmentDate.substring(0, 2));
                        int month = Integer.parseInt(appointmentDate.substring(3, 5));
                        int year = Integer.parseInt(appointmentDate.substring(6));

                        GregorianCalendar dateOfBirthGC = new GregorianCalendar(year, month - 1, day);
                        dateOfBirthGC.setLenient(false);
                        dateOfBirthGC.getTime();

                        System.out.println(dateOfBirthGC.get(Calendar.DATE)+"-"+
                                (dateOfBirthGC.get(Calendar.MONTH)+1)+"-"+
                                dateOfBirthGC.get(Calendar.YEAR));

                        JOptionPane.showMessageDialog(null, "Appointment details added", "Appointment Has been added", JOptionPane.INFORMATION_MESSAGE);

                        appointment=new Appointment(PPSNField.getText(),ForeNameField.getText(),SurNameField.getText(),
                                PhoneField.getText(),dateOfBirthGC);

                        ArrayList<Appointment> appointments=new ArrayList<>();

                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Date of Appointment must be in the form dd-mm-yyyy", "Invalid Date of Appointment", JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalArgumentException e2) {
                        if (e2.getMessage().contains("PPSN"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(), "Invalid PPSN", JOptionPane.ERROR_MESSAGE);
                        else if (e2.getMessage().contains("ForeName"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(), "Invalid ForeName", JOptionPane.ERROR_MESSAGE);
                        else if (e2.getMessage().contains("SurName"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(), "Invalid SurName", JOptionPane.ERROR_MESSAGE);
                        else if (e2.getMessage().contains("Phone Number"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(), "Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "Date of Appointment day and month values must be valid", "Invalid Date of Birth", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        });
        panel.add(addbutton);
        panel.add(Cancelbutton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private Doctor getDoctor() {
        String[] Doctor = new String[]
                {"Fred Smith", "Mark Twomey", "Mary Twomey", "James Walsh"};
        String DoctorName = Doctor[cmbDoctor.getSelectedIndex()];

        for (Doctor doctor : TestGPSYS.Doctors) {
            if (doctor.getName().equals(DoctorName)) {
                return doctor;
            }
        }
        return null;
    }

}
