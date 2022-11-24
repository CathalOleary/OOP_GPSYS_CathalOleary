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
 * This the class that creates the GUI for the Patients window
 * @author Cathal Oleary
 */

public class RegPatientGUI extends JFrame{

    private Insets normalInsets=new Insets(15,10,0,10);
    private Insets topInsets=new Insets(15,10,0,10);
    private JTextField PPSNField;
    private JTextField ForeNameField;
    private JTextField SurNameField;
    private JTextField dateOfBirthField;
    private JTextField MedCardField;
    private JTextField PhoneField;
    private GregorianCalendar dateChosen;
    private JComboBox cmbBlood;
    private JComboBox cmbDoctor;

    public RegPatientGUI()
    {
        super("Register Patient");
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(createDetailsPanel());
        panel.add(Box.createVerticalStrut(40));
        panel.add(createSubmitPanel());
        panel.add(Box.createVerticalStrut(20));

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setVisible(true);
        setResizable(false);

        add(panel);
        setVisible(true);
    }

    public static void main(String args[]){
        new RegPatientGUI();
    }

    private JPanel createDetailsPanel()
    {
        JPanel panel=new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy =0;
        JLabel PPSNJL=new JLabel("PPSN");
        addComponent(panel,PPSNJL,0, gridy,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        PPSNField=new JTextField(25);
        addComponent(panel,PPSNField,1, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel ForeNameJL=new JLabel("ForeName");
        addComponent(panel,ForeNameJL,0, gridy,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        ForeNameField=new JTextField(25);
        addComponent(panel,ForeNameField,1, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel SurNameJL=new JLabel("SurName");
        addComponent(panel,SurNameJL,0, gridy,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        SurNameField=new JTextField(25);
        addComponent(panel,SurNameField,1, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel PhoneJL=new JLabel("Phone Number");
        addComponent(panel,PhoneJL,0, gridy,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        PhoneField=new JTextField(25);
        addComponent(panel,PhoneField,1, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel MedCardJL=new JLabel("Medical Card Number");
        addComponent(panel,MedCardJL,0, gridy,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        MedCardField=new JTextField(25);
        addComponent(panel,MedCardField,1, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel Bloodty=new JLabel("Choose a Blood type ");
        addComponent(panel,Bloodty,0, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        String[] Blood=new String[]
                {"A","B","AB","O"};

        cmbBlood=new JComboBox(Blood);
        cmbBlood.setVisible(true);
        add(cmbBlood);
        addComponent(panel,cmbBlood,0, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel doctorN=new JLabel("Choose Doctors Name");
        addComponent(panel,doctorN,0, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        panel.add(cmbBlood);

        String[] Doctor=new String[]
        {"Fred Smith","Mark Twomey","Mary Twomey","James Walsh"};

        cmbDoctor=new JComboBox(Doctor);
        cmbDoctor.setVisible(true);
        add(cmbDoctor);
        addComponent(panel,doctorN,0, gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        panel.add(cmbDoctor);

        JLabel dateOfBirthLabel=new JLabel("Date of Birth");
        addComponent(panel,dateOfBirthLabel,0, gridy, 1, 1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        dateOfBirthField=new JTextField(25);
        dateOfBirthField.setText("enter in form dd-mm-yyyy or use date-chooser");
        addComponent(panel,dateOfBirthField,1, gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JButton dateOfBirthButton=new JButton("...");
        dateOfBirthButton.setPreferredSize(new Dimension(20,15));
        addComponent(panel,dateOfBirthButton,3, gridy++,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        dateOfBirthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DateChooser dateChooser = new DateChooser(RegPatientGUI.this);
                dateChosen = dateChooser.getDateChosen();

                if (dateChosen != null)
                {
                    System.out.println(dateChosen.get(Calendar.DATE)+"-"+
                            dateChosen.get(Calendar.MONTH)+"-"+
                            dateChosen.get(Calendar.YEAR));

                    String dayString="", monthString="";

                    if (dateChosen.get(Calendar.DATE) < 10)
                        dayString = "0" + dateChosen.get(Calendar.DATE);
                    else
                        dayString = "" + dateChosen.get(Calendar.DATE);

                    if (dateChosen.get(Calendar.MONTH) < 10)
                        monthString = "0" + dateChosen.get(Calendar.MONTH);
                    else
                        monthString = "" + dateChosen.get(Calendar.MONTH);

                    dateOfBirthField.setText(dayString + "-" + monthString + "-" + dateChosen.get(Calendar.YEAR));
                }
            }
        });
          return panel;
    }
    private void addComponent(Container container, Component componemt,int gridX,int grid,
                              int gridWidth,int gridHeight,Insets insets,int Anchor,int Fill)
    {
        GridBagConstraints gridBagConstraints=new GridBagConstraints(gridX,grid,gridWidth,gridHeight,
                0.0,0.0,Anchor,Fill,insets,5,5);

        container.add(componemt,gridBagConstraints);
    }

    private JPanel createSubmitPanel()
    {
        JPanel panel=new JPanel();

        JButton Cancelbutton=new JButton("Cancel");
        Cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuGUI();
                setVisible(false);
            }
        });

        JButton addbutton=new JButton("Add Patient");
        addbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String dateOfBirth=dateOfBirthField.getText();

                Patient patient;

                if (dateOfBirth.length()>=7)
                {
                    try
                    {
                        int day=Integer.parseInt(dateOfBirth.substring(0,2));
                        int month=Integer.parseInt(dateOfBirth.substring(3,5));
                        int year=Integer.parseInt(dateOfBirth.substring(6,dateOfBirth.length()));

                        GregorianCalendar dateOfBirthGC=new GregorianCalendar(year,month - 1,day);
                        dateOfBirthGC.setLenient(false);
                        dateOfBirthGC.getTime();

                        System.out.println(dateOfBirthGC.get(Calendar.DATE)+"-"+
                                (dateOfBirthGC.get(Calendar.MONTH)+1)+"-"+
                                dateOfBirthGC.get(Calendar.YEAR));

                        JOptionPane.showMessageDialog(null,"Appointment details added","Appointment Has been added",JOptionPane.INFORMATION_MESSAGE);



                        patient=new Patient(PPSNField.getText(),MedCardField.getText(),SurNameField.getText(),
                                ForeNameField.getText(),PhoneField.getText(),
                                dateOfBirthGC,getBloodTp(),getDoctor());

                        ArrayList<Patient> patients=new ArrayList<>();

                    }catch (NumberFormatException e1)
                        {
                            JOptionPane.showMessageDialog(null,"Date of birth must be in the form dd-mm-yyyy","Invalid Date of Birth",JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException e2)
                    {
                        if (e2.getMessage().contains("PPSN"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(),"Invalid PPSN",JOptionPane.ERROR_MESSAGE);
                        else if (e2.getMessage().contains("ForeName"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(),"Invalid ForeName",JOptionPane.ERROR_MESSAGE);
                        else if (e2.getMessage().contains("SurName"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(),"Invalid SurName",JOptionPane.ERROR_MESSAGE);
                        else if (e2.getMessage().contains("Phone Number"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(),"Invalid Phone Number",JOptionPane.ERROR_MESSAGE);
                        else if (e2.getMessage().contains("Medical Card Number"))
                            JOptionPane.showMessageDialog(null, e2.getMessage(),"Invalid Medical Card Number",JOptionPane.ERROR_MESSAGE);
                       else
                            JOptionPane.showMessageDialog(null,"Date of birth day and month values must be valid","Invalid Date of Birth", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(addbutton);
        panel.add(Cancelbutton);
        return panel;
    }

    private String getBloodTp()
    {
        String[] Blood=new String[]
                {"A","B","AB","O"};
        return Blood[cmbBlood.getSelectedIndex()];
    }

    private Doctor getDoctor(){
        String[] Doctor=new String[]
                {"Fred Smith","Mark Twomey","Mary Twomey","James Walsh"};
        String DoctorName = Doctor[cmbDoctor.getSelectedIndex()];

        for(Doctor doctor : TestGPSYS.Doctors){
            if(doctor.getName().equals(DoctorName)){
                return doctor;
            }
        }
        return null;
    }
}
