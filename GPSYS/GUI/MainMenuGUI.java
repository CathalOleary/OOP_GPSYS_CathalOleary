package GPSYS.GUI;

import GPSYS.Driver.*;
import GPSYS.Ojects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This the class that creates the GUI for the main menu window
 * @author Cathal Oleary
 */

public class MainMenuGUI extends JFrame implements ActionListener {
    JMenu PatientMenu;
    JMenu AppointMenu;
    JMenu AdminMenu;

    /**
     * this section of code Creates the main window of the application
     * and creates/places the menu buttons
     * The PatientMenu creates the button on the menu bar for the Patients options
     * The AppointMenu creates the button on the menu bar for the Appointment options
     * The AdminMenu creates the button on the menu bar for the Admin options.
     */

    public MainMenuGUI() {
        super("Main Menu");
        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);
        setBounds(600, 200, 400, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createPatientMenu();
        createAppointMenu();
        createAdminMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.lightGray);
        menuBar.add(PatientMenu);
        menuBar.add(AppointMenu);
        menuBar.add(AdminMenu);

        ImageIcon ImageIcon = new ImageIcon("/Images/HomePage.png");
        JLabel background = new JLabel("", ImageIcon, JLabel.CENTER);
        background.setBounds(0, 0, 800, 200);
        add(background);

        JPanel JP = new JPanel();
        JP.setLayout(borderLayout);
        JP.setBounds(0, 0, 800, 600);
        JP.add(background);
        add(JP);
        setVisible(true);
    }

    /**
     * This method Creates the sub buttons for the Patient options on the JMenu.
     * Such as Register Patient, Remove Patient and View Patient Data.
     */

    public static void main(String[] args) {
        MainMenuGUI frame = new MainMenuGUI();
    }

    private void createPatientMenu() {
        JMenuItem item;

        PatientMenu = new JMenu("Patient");

        item = new JMenuItem("Register Patient");
        item.addActionListener(this);

        PatientMenu.add(item);

        PatientMenu.addSeparator();

        item = new JMenuItem("Remove Patient");
        item.addActionListener(this);

        PatientMenu.add(item);

        PatientMenu.addSeparator();

        item = new JMenuItem("View Patient Data");
        item.addActionListener(this);

        PatientMenu.add(item);

    }

    /**
     * This method Creates the sub buttons for the Appointment options on the JMenu.
     * Such as Make Appointment,Cancel Appointment and List Appointments.
     */

    private void createAppointMenu() {
        JMenuItem item;

        AppointMenu = new JMenu("Appointment");

        item = new JMenuItem("Make Appointment");
        item.addActionListener(this);

        AppointMenu.add(item);

        AppointMenu.addSeparator();

        item = new JMenuItem("Cancel Appointment");
        item.addActionListener(this);

        AppointMenu.add(item);

        AppointMenu.addSeparator();

        item = new JMenuItem("List Appointments");
        item.addActionListener(this);

        AppointMenu.add(item);
    }

    /**
     * This method Creates the sub buttons for the Admin options on the JMenu.
     * Such as Monthly Patients and Yearly Revenue but this part of the code isn't fully empaneled.
     */

    private void createAdminMenu() {
        JMenuItem item;

        AdminMenu = new JMenu("Admin");

        item = new JMenuItem("Monthly Patients");
        item.addActionListener(this);

        AdminMenu.add(item);

        AdminMenu.addSeparator();

        item = new JMenuItem("Yearly Revenue");
        item.addActionListener(this);

        AdminMenu.add(item);
    }

    /**
     * This method creates the functionality be hided the sub buttons for the Patient and Appointment options and
     * @return a false if the user selects one of the 6 options.
     */

    public void actionPerformed(ActionEvent event) {
        String PatientMenu;

        PatientMenu = event.getActionCommand();

        if (PatientMenu.equals("Register Patient")) {
            new RegPatientGUI();
            setVisible(false);
        } else if (PatientMenu.equals("Remove Patient")) {
            removePatient();
            setVisible(false);
        } else if (PatientMenu.equals("View Patient Data")) {
            showPatientData();
            setVisible(false);
        }

        String AppointMenu;

        AppointMenu = event.getActionCommand();

        if (AppointMenu.equals("Make Appointment")) {
            new MakeAppointementGUI();
            setVisible(false);
        } else if (AppointMenu.equals("Cancel Appointment")) {
            CancelAppointment();
            setVisible(false);
        } else if (AppointMenu.equals("List Appointments")) {
            ListAppointment();
            setVisible(false);
        }

        /**I ran out of time to make this GUIs and i wasn't shore how to display/how They would look.
        /*String AdminMenu;

        AdminMenu=event.getActionCommand();

        if (AdminMenu.equals("Monthly Patients"))
            new MonthlyPatientsGUI();
        else if(AdminMenu.equals("Yearly Revenue"))
            new YearlyRevenueGUI();
        */
    }

    private void showPatientData() {
        String text="Outputting all of the patients information:\n\n";

        for (Patient patient:TestGPSYS.Patients) {
            text+="\n\nPatient: "+patient;
        }

        JOptionPane.showMessageDialog(null,text,"Patients",JOptionPane.INFORMATION_MESSAGE);
    }

    private void removePatient() {
        String Text="";
        int ID =0;
        for (Patient patient:TestGPSYS.Patients) {
            Text+="\n ID: "+ID+patient;
            ID++;
        }

        int ChosenIndex=Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID you what to remove\n" + Text));

        TestGPSYS.Patients.remove(ChosenIndex);
    }

    private void ListAppointment() {
        String text="Outputting all of the Appointments information:\n\n";

        for (Appointment appointment:TestGPSYS.Appointments) {
            text+="\n\nAppointment: "+appointment;
        }

        JOptionPane.showMessageDialog(null,text,"Appointment",JOptionPane.INFORMATION_MESSAGE);
    }


    private void CancelAppointment() {
        String Text="";
        int ID =0;
        for (Appointment appointment:TestGPSYS.Appointments) {
            Text+="\n ID: "+ID+appointment;
            ID++;
        }

        int ChosenIndex=Integer.parseInt(JOptionPane.showInputDialog("Enter Appointment ID you what to remove\n"+Text));

        TestGPSYS.Appointments.remove(ChosenIndex);
    }
}
