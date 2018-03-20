    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package ams;

    import ejb.session.stateless.PatientEntityControllerRemote;
    import entity.PatientEntity;
    import java.util.Scanner;


    /**
     *
     * @author Ismahfaris
     */
    public class RegisterModule {
        private PatientEntityControllerRemote patientEntityControllerRemote;

        private PatientEntity currentPatientEntity;



        public RegisterModule()
        {
        }



        public RegisterModule(PatientEntityControllerRemote patientEntityControllerRemote) 
        {
            this();
            this.patientEntityControllerRemote = patientEntityControllerRemote;
        }


    public void doRegisterOperation()
        {
            Scanner scanner = new Scanner(System.in);
            PatientEntity newPatientEntity = new PatientEntity();

            System.out.println("*** AMS Client :: Register ***\n");
            System.out.print("Enter Identity Number> ");
            newPatientEntity.setIdentityNum(scanner.nextLine().trim());
            System.out.print("Security Code> ");
            newPatientEntity.setSecurityCode(scanner.nextLine().trim());
            System.out.print("First Name> ");
            newPatientEntity.setFirstName(scanner.nextLine().trim());
            System.out.print("Last Name> ");
            newPatientEntity.setLastName(scanner.nextLine().trim());
            System.out.print("Gender> ");
            newPatientEntity.setGender(scanner.nextLine().trim());
            System.out.print("Age> ");
            newPatientEntity.setAge(scanner.nextLine().trim());
            System.out.print("Phone> ");
            newPatientEntity.setPhone(scanner.nextLine().trim());
            System.out.print("Address> ");
            newPatientEntity.setAddress(scanner.nextLine().trim());
     
            
            newPatientEntity = patientEntityControllerRemote.createNewPatient(newPatientEntity);

        }

    }
