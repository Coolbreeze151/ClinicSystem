package ams;


import ejb.session.stateless.AppointmentEntityControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import entity.PatientEntity;
import java.util.Scanner;
import util.exception.InvalidLoginCredentialException;





public class MainApp
{

    
    private AmsModule amsModule;
    private RegisterModule registerModule;

    
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private AppointmentEntityControllerRemote appointmentEntityControllerRemote;
    
    private PatientEntity currentPatientEntity;
    
    public MainApp() 
    {        
    }

    
    
    public MainApp( PatientEntityControllerRemote patientEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, AppointmentEntityControllerRemote appointmentEntityControllerRemote) 
    {
        this();
        
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.appointmentEntityControllerRemote = appointmentEntityControllerRemote;

    }
    
    
    
    public void runApp()
    {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true)
        {
            System.out.println("*** Welcome to Self-Service Kiosk ***\n");
            System.out.println("1: Register");
            System.out.println("2: Login");
            System.out.println("3: Exit\n");
            response = 0;
            
            while(response < 1 || response > 3)
            {
                System.out.print("> ");

                response = scanner.nextInt();
                if(response == 1){
                    registerModule = new RegisterModule(patientEntityControllerRemote);
                    doRegister();                
                }
                
                else if(response == 2)
                {
                    
                    try
                    {
                        doLogin();
                        amsModule = new AmsModule(patientEntityControllerRemote, doctorEntityControllerRemote, appointmentEntityControllerRemote);
                        menuMain();
                    }
                    catch(InvalidLoginCredentialException ex) 
                    {
                    }
                }
                else if (response == 3)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 3)
            {
                break;
            }
        }
    }
    
    private void doRegister()
    {
        registerModule.doRegisterOperation();
        System.out.println("You have been registered successfully!\n");
    
    }
    
    private void doLogin() throws InvalidLoginCredentialException
    {
        Scanner scanner = new Scanner(System.in);
        String identityNumber = "";
        String securityCode = "";
        
        System.out.println("*** AMS Client :: Login ***\n");
        System.out.print("Enter Identity Number> ");
        identityNumber = scanner.nextLine().trim();
        System.out.print("Enter Security Code> ");
        securityCode = scanner.nextLine().trim();
        
        if(identityNumber.length() > 0 && securityCode.length() > 0)
        {

            try
            {
                
                currentPatientEntity = patientEntityControllerRemote.patientLogin(identityNumber, securityCode);
                System.out.println("Login successful!\n");
            }        
            catch (InvalidLoginCredentialException ex)
            {
                System.out.println("Invalid login credential: " + ex.getMessage() + "\n");
                
                throw new InvalidLoginCredentialException();
            }           
        }
        else
        {
            System.out.println("Invalid login credential!");
        }
    }
    
    
    
    private void menuMain()
    {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true)
        {
            System.out.println("*** Point-of-Sale (POS) System (v3) ***\n");
            System.out.println("You are login as " + currentPatientEntity.getFirstName() + " " + currentPatientEntity.getLastName());
            System.out.println();
            System.out.println("1: View Appointments");
            System.out.println("2: Add Appointment");
            System.out.println("3: Cancel Appointment");
            System.out.println("4: Logout\n");
            response = 0;
            
            while(response < 1 || response > 3)
            {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1)
                {
                    System.out.println("To be implemented");
                    //amsModule.doViewAppointment();
                }
                else if(response == 2)
                {
                    System.out.println("To be implemented");
                   //amsModule.doAddAppointment();
                }
                else if (response == 3)
                {
                    
                  System.out.println("To be implemented");
                   //amsModule.doCancelAppointment();
                }
                else if(response == 4){
                    break;
                }
                else
                {
                    System.out.println("Invalid option, please try again!\n");                
                }
                

            }
            if(response == 4)
                    break;
            
        }
    }
}