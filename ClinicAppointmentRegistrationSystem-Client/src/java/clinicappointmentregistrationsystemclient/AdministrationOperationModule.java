    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package clinicappointmentregistrationsystemclient;

    import ejb.session.stateless.DoctorEntityControllerRemote;
    import ejb.session.stateless.PatientEntityControllerRemote;
    import ejb.session.stateless.StaffEntityControllerRemote;
    import entity.StaffEntity;
    import entity.DoctorEntity;
    import entity.PatientEntity;
    import java.util.List;
    import java.util.Scanner;
    import util.exception.DoctorNotFoundException;
    import util.exception.PatientNotFoundException;
    import util.exception.StaffNotFoundException;


    /**
     *
     * @author Ismahfaris
     */
    public class AdministrationOperationModule {
        private StaffEntityControllerRemote staffEntityControllerRemote;
        private DoctorEntityControllerRemote doctorEntityControllerRemote;
        private PatientEntityControllerRemote patientEntityControllerRemote;

        private StaffEntity currentStaffEntity;



        public AdministrationOperationModule()
        {
        }



        public AdministrationOperationModule(StaffEntityControllerRemote staffEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, StaffEntity currentStaffEntity) 
        {
            this();
            this.staffEntityControllerRemote = staffEntityControllerRemote;
            this.patientEntityControllerRemote = patientEntityControllerRemote;
            this.doctorEntityControllerRemote = doctorEntityControllerRemote;
            this.currentStaffEntity = currentStaffEntity;
        }



        public void menuAdministrationOperation() 
        {


            Scanner scanner = new Scanner(System.in);
            Integer response = 0;

            while(true)
            {
                System.out.println("*** CARS :: Administration Operation ***\n");
                System.out.println("1: Patient Management");
                System.out.println("2: Doctor Management");
                System.out.println("3: Staff Management");
                System.out.println("4: Back\n");
                response = 0;

                while(response < 1 || response > 4)
                {
                    System.out.print("> ");

                    response = scanner.nextInt();

                    if(response == 1)
                    {
                        doPatientManagement();
                    }
                    else if(response == 2)
                    {
                        doDoctorManagement();
                    }
                    else if(response == 3)
                    {
                        doStaffManagement();
                    }
                    else if(response == 4)
                    {
                        break;
                    }

                    else
                    {
                        System.out.println("Invalid option, please try again!\n");                
                    }
                }

                if(response == 4)
                {
                    break;
                }
            }
        }


        public void doPatientManagement(){

            Scanner scanner = new Scanner(System.in);
            Integer response = 0;

            while(true)
            {
                System.out.println("*** CARS :: Administration Operation :: Patient Management ***\n");
                System.out.println("1: Add Patient");
                System.out.println("2: View Patient Details");
                System.out.println("3: Update Patient");
                System.out.println("4: Delete Patient");
                System.out.println("5: View All Patients");
                System.out.println("6: Back\n");
                response = 0;

                while(response < 1 || response > 6)
                {
                    System.out.print("> ");

                    response = scanner.nextInt();

                    if(response == 1)
                    {
                        doAddPatient();
                    }
                    else if(response == 2)
                    {
                        doViewPatientDetails();
                    }
                    else if(response == 3)
                    {
                        doUpdatePatient();
                    }
                    else if(response == 4)
                    {
                        doDeletePatient();
                    }
                    else if(response == 5)
                    {
                        doViewAllPatients();
                    }
                    else if(response == 6)
                    {
                        break;
                    }

                    else
                    {
                        System.out.println("Invalid option, please try again!\n");                
                    }
                }

                if(response == 6)
                {
                    break;
                }
            }
        }

            public void doDoctorManagement(){

            Scanner scanner = new Scanner(System.in);
            Integer response = 0;

            while(true)
            {
                System.out.println("*** CARS :: Administration Operation :: Doctor Management ***\n");
                System.out.println("1: Add Doctor");
                System.out.println("2: View Doctor Details");
                System.out.println("3: Update Doctor");
                System.out.println("4: Delete Doctor");
                System.out.println("5: View All Doctors");
                System.out.println("6: Back\n");
                response = 0;

                while(response < 1 || response > 6)
                {
                    System.out.print("> ");

                    response = scanner.nextInt();

                    if(response == 1)
                    {
                        doAddDoctor();
                    }
                    else if(response == 2)
                    {
                        doViewDoctorDetails();
                    }
                    else if(response == 3)
                    {
                        doUpdateDoctor();
                    }
                    else if(response == 4)
                    {
                        doDeleteDoctor();
                    }
                    else if(response == 5)
                    {
                        doViewAllDoctors();
                    }
                    else if(response == 6)
                    {
                        break;
                    }

                    else
                    {
                        System.out.println("Invalid option, please try again!\n");                
                    }
                }

                if(response == 6)
                {
                    break;
                }
            }
        }

            public void doStaffManagement(){

            Scanner scanner = new Scanner(System.in);
            Integer response = 0;

            while(true)
            {
                System.out.println("*** CARS :: Administration Operation :: Staff Management ***\n");
                System.out.println("1: Add Staff");
                System.out.println("2: View Staff Details");
                System.out.println("3: Update Staff");
                System.out.println("4: Delete Staff");
                System.out.println("5: View All Staffs");
                System.out.println("6: Back\n");
                response = 0;

                while(response < 1 || response > 6)
                {
                    System.out.print("> ");

                    response = scanner.nextInt();

                    if(response == 1)
                    {
                        doAddStaff();
                    }
                    else if(response == 2)
                    {
                        doViewStaffDetails();
                    }
                    else if(response == 3)
                    {
                        doUpdateStaff();
                    }
                    else if(response == 4)
                    {
                        doDeleteStaff();
                    }
                    else if(response == 5)
                    {
                        doViewAllStaff();
                    }
                    else if(response == 6)
                    {
                        break;
                    }

                    else
                    {
                        System.out.println("Invalid option, please try again!\n");                
                    }
                }

                if(response == 6)
                {
                    break;
                }
            }
        }

        
        private void doAddStaff()
        {
            Scanner scanner = new Scanner(System.in);
            StaffEntity newStaffEntity = new StaffEntity();

            System.out.println("*** CARS :: Administration Operation :: Staff Management :: Add Staff ***\n");
            System.out.print("Enter First Name> ");
            newStaffEntity.setFirstName(scanner.nextLine().trim());
            System.out.print("Enter Last Name> ");
            newStaffEntity.setLastName(scanner.nextLine().trim());
            System.out.print("Enter Username> ");
            newStaffEntity.setUsername(scanner.nextLine().trim());
            System.out.print("Enter Password> ");
            newStaffEntity.setPassword(scanner.nextLine().trim());

            newStaffEntity = staffEntityControllerRemote.createNewStaff(newStaffEntity);
            System.out.println("New staff created successfully!: " + newStaffEntity.getStaffId() + "\n");
        }


        private void doAddDoctor()
        {
            Scanner scanner = new Scanner(System.in);
            DoctorEntity newDoctorEntity = new DoctorEntity();

            System.out.println("*** CARS :: Administration Operation :: Doctor Management :: Add Doctor ***\n");
            System.out.print("Enter First Name> ");
            newDoctorEntity.setFirstName(scanner.nextLine().trim());
            System.out.print("Enter Last Name> ");
            newDoctorEntity.setLastName(scanner.nextLine().trim());
            System.out.print("Enter Registration> ");
            newDoctorEntity.setRegistration(scanner.nextLine().trim());
            System.out.print("Enter Qualifications> ");
            newDoctorEntity.setQualifications(scanner.nextLine().trim());

            newDoctorEntity = doctorEntityControllerRemote.createNewDoctor(newDoctorEntity);
            System.out.println("New staff created successfully!: " + newDoctorEntity.getDoctorId() + "\n");
        }


                 private void doAddPatient()
        {
            Scanner scanner = new Scanner(System.in);
            PatientEntity newPatientEntity = new PatientEntity();

            System.out.println("*** CARS :: Administration Operation :: Patient Management :: Add Patient ***\n");
            System.out.print("Enter Identity Number> ");
            newPatientEntity.setIdentityNum(scanner.nextLine().trim());
            System.out.print("Enter First Name> ");
            newPatientEntity.setFirstName(scanner.nextLine().trim());
            System.out.print("Enter Last Name> ");
            newPatientEntity.setLastName(scanner.nextLine().trim());
            System.out.print("Enter Gender> ");
            newPatientEntity.setGender(scanner.nextLine().trim());
            System.out.print("Enter Age> ");
            newPatientEntity.setAge(scanner.nextLine().trim());
            System.out.print("Enter Phone> ");
            newPatientEntity.setPhone(scanner.nextLine().trim());
            System.out.print("Enter Address> ");
            newPatientEntity.setAddress(scanner.nextLine().trim());

            newPatientEntity = patientEntityControllerRemote.createNewPatient(newPatientEntity);
            System.out.println("New patient created successfully!: " + newPatientEntity.getPatientId() + "\n");
        }





        private void doViewStaffDetails()
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** CARS :: Administration Operation :: Staff Management :: View Staff Details ***\n");
            System.out.print("Enter Staff ID> ");
            Long staffId = scanner.nextLong();

            try
            {
                StaffEntity staffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);
                System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");
                System.out.printf("%8s%20s%20s%20s%20s\n\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());         

            }
            catch(StaffNotFoundException ex)
            {
                System.out.println("An error has occurred while retrieving staff: " + ex.getMessage() + "\n");
            }
        }

        private void doViewDoctorDetails()
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** CARS :: Administration Operation :: Doctor Management :: View Doctor Details ***\n");
            System.out.print("Enter Doctor ID> ");
            Long doctorId = scanner.nextLong();

            try
            {
                DoctorEntity doctorEntity = doctorEntityControllerRemote.retrieveDoctorByDoctorId(doctorId);
                System.out.printf("%8s%20s%20s%20s%20s\n", "Doctor ID", "First Name", "Last Name", "Registration", "Qualifications");
                System.out.printf("%8s%20s%20s%20s%20s\n\n", doctorEntity.getDoctorId().toString(), doctorEntity.getFirstName(), doctorEntity.getLastName(), doctorEntity.getRegistration(), doctorEntity.getQualifications());         

            }
            catch(DoctorNotFoundException ex)
            {
                System.out.println("An error has occurred while retrieving doctor: " + ex.getMessage() + "\n");
            }
        }

        private void doViewPatientDetails()
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** CARS :: Administration Operation :: Patient Management :: View Patient Details ***\n");
            System.out.print("Enter Patient ID> ");
            Long patientId = scanner.nextLong();

            try
            {
                PatientEntity patientEntity = patientEntityControllerRemote.retrievePatientByPatientId(patientId);
                System.out.printf("%8s%20s%20s%8s%20s%20s%20s\n", "Patient ID", "Identity Number", "First Name", "Last Name", "Gender", "Age", "Phone", "Address");
                System.out.printf("%8s%20s%20s%8s%20s%20s%20s\n\n", patientEntity.getPatientId().toString(), patientEntity.getIdentityNum(), patientEntity.getFirstName(), patientEntity.getLastName(), patientEntity.getGender(), patientEntity.getAge(), patientEntity.getPhone(), patientEntity.getAddress());         

            }
            catch(PatientNotFoundException ex)
            {
                System.out.println("An error has occurred while retrieving patient: " + ex.getMessage() + "\n");
            }
        }








        private void doUpdateDoctor() 
        {
            Scanner scanner = new Scanner(System.in);
            String input;
            System.out.println("*** CARS :: Administration Operation :: Doctor Management :: Update Doctor ***\n");
            System.out.print("Enter Doctor ID> ");
            Long doctorId = scanner.nextLong();
            DoctorEntity searchDoctorEntity;

            try
            {
                searchDoctorEntity = doctorEntityControllerRemote.retrieveDoctorByDoctorId(doctorId);
            }
            catch(DoctorNotFoundException ex)
            {
                System.out.println("An error has occurred while retrieving doctor: " + ex.getMessage() + "\n");
                return;
            }
            scanner.nextLine();// to get rid of initial key
            System.out.print("Enter First Name (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchDoctorEntity.setFirstName(input);
            }

            System.out.print("Enter Last Name (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchDoctorEntity.setLastName(input);
            }

            System.out.print("Enter Registration (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchDoctorEntity.setRegistration(input);
            }

            System.out.print("Enter Qualifications (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchDoctorEntity.setQualifications(input);
            }
            try{
            doctorEntityControllerRemote.updateDoctor(searchDoctorEntity);
            }
            catch (DoctorNotFoundException e){
                System.out.println("An error has occurred while retrieving doctor: " + e.getMessage() + "\n");
                return;
            }

            System.out.println("Doctor updated successfully!\n");
        }
                
        private void doUpdateStaff() 
        {
            Scanner scanner = new Scanner(System.in);
            String input;
            System.out.println("*** CARS :: Administration Operation :: Staff Management :: Update Staff ***\n");
            System.out.print("Enter Doctor ID> ");
            Long staffId = scanner.nextLong();
            StaffEntity searchStaffEntity;

            try
            {
                searchStaffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);
            }
            catch(StaffNotFoundException ex)
            {
                System.out.println("An error has occurred while retrieving Staff: " + ex.getMessage() + "\n");
                return;
            }
            scanner.nextLine();// to get rid of initial key
            System.out.print("Enter First Name (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchStaffEntity.setFirstName(input);
            }

            System.out.print("Enter Last Name (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchStaffEntity.setLastName(input);
            }

            System.out.print("Enter Username (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchStaffEntity.setUsername(input);
            }

            System.out.print("Enter Password (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchStaffEntity.setPassword(input);
            }
            try{
            staffEntityControllerRemote.updateStaff(searchStaffEntity);
            }
            catch (StaffNotFoundException e){
                System.out.println("An error has occurred while retrieving staff: " + e.getMessage() + "\n");
                return;
            }

            System.out.println("Staff updated successfully!\n");
        }
                   
        private void doUpdatePatient() 
        {
            Scanner scanner = new Scanner(System.in);
            String input;
            System.out.println("*** CARS :: Administration Operation :: Patient Management :: Update Patient ***\n");
            System.out.print("Enter Patient ID> ");
            Long patientId = scanner.nextLong();
            PatientEntity searchPatientEntity;

            try
            {
                searchPatientEntity = patientEntityControllerRemote.retrievePatientByPatientId(patientId);
            }
            catch(PatientNotFoundException ex)
            {
                System.out.println("An error has occurred while retrieving patient: " + ex.getMessage() + "\n");
                return;
            }
            scanner.nextLine();// to get rid of initial key
            System.out.print("Enter Identity Number (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchPatientEntity.setIdentityNum(input);
            }
            
            System.out.print("Enter First Name (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchPatientEntity.setFirstName(input);
            }

            System.out.print("Enter Last Name (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchPatientEntity.setLastName(input);
            }

            
            System.out.print("Enter Gender (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchPatientEntity.setGender(input);
            }

            System.out.print("Enter Age (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchPatientEntity.setAge(input);
            }
            
            System.out.print("Enter Phone Number (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchPatientEntity.setPhone(input);
            }
            
            System.out.print("Enter Address (blank if no change)> ");
            input = scanner.nextLine().trim();
            if(input.length() > 0)
            {
                 searchPatientEntity.setAddress(input);
            }
            try{
            patientEntityControllerRemote.updatePatient(searchPatientEntity);
            }
            catch (PatientNotFoundException e){
                System.out.println("An error has occurred while retrieving patient: " + e.getMessage() + "\n");
                return;
            }

            System.out.println("Patient updated successfully!\n");
        }











        private void doDeleteStaff()
        {
            Scanner scanner = new Scanner(System.in);        
            String input;
            System.out.print("Enter Staff ID> ");
            Long staffId = scanner.nextLong();
            StaffEntity searchStaffEntity;

            try
            {
                searchStaffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);


                   staffEntityControllerRemote.deleteStaff(searchStaffEntity.getStaffId());
                   System.out.println("Staff deleted successfully!\n");
                }
                catch (StaffNotFoundException ex) 
                {
                    System.out.println("An error has occurred while deleting staff: " + ex.getMessage() + "\n");
                }            

        }


        private void doDeleteDoctor()
        {
            Scanner scanner = new Scanner(System.in);        
            String input;
            System.out.print("Enter doctor ID> ");
            Long doctorId = scanner.nextLong();
            DoctorEntity searchDoctorEntity;

            try
            {
                searchDoctorEntity = doctorEntityControllerRemote.retrieveDoctorByDoctorId(doctorId);


                   doctorEntityControllerRemote.deleteDoctor(searchDoctorEntity.getDoctorId());
                   System.out.println("Staff deleted successfully!\n");
                }
                catch (DoctorNotFoundException ex) 
                {
                    System.out.println("An error has occurred while deleting doctor: " + ex.getMessage() + "\n");
                }            

        }
                  
                   
    private void doDeletePatient()
    {
        Scanner scanner = new Scanner(System.in);        
        String input;
        System.out.print("Enter patient ID> ");
        Long patientId = scanner.nextLong();
        PatientEntity searchPatientEntity;
        
        try
        {
            searchPatientEntity = patientEntityControllerRemote.retrievePatientByPatientId(patientId);
       
            
              patientEntityControllerRemote.deletePatient(searchPatientEntity.getPatientId());
               System.out.println("Patient deleted successfully!\n");
            }
            catch (PatientNotFoundException ex) 
            {
                System.out.println("An error has occurred while deleting patient: " + ex.getMessage() + "\n");
            }            
 
    }



                  
                  
                  
                  
                  
                  
                  

        private void doViewAllStaff()
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** CARS :: Administration Operation :: Staff Management :: View All Staffs ***\n");

            List<StaffEntity> staffEntities = staffEntityControllerRemote.retrieveAllStaffs();
            System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");

            for(StaffEntity staffEntity:staffEntities)
            {
                System.out.printf("%8s%20s%20s%20s%20s\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());
            }

            System.out.print("Press any key to continue...> ");
            scanner.nextLine();
        }
                    
        
        private void doViewAllDoctors()
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** CARS :: Administration Operation :: Doctor Management :: View All Doctors ***\n");

            List<DoctorEntity> doctorEntities = doctorEntityControllerRemote.retrieveAllDoctors();
            System.out.printf("%8s%20s%20s%20s%20s\n", "Doctor ID", "First Name", "Last Name", "Registration", "Qualifications");

            for(DoctorEntity doctorEntity:doctorEntities)
            {
                System.out.printf("%8s%20s%20s%20s%20s\n", doctorEntity.getDoctorId().toString(), doctorEntity.getFirstName(), doctorEntity.getLastName(), doctorEntity.getRegistration(), doctorEntity.getQualifications());
            }

            System.out.print("Press any key to continue...> ");
            scanner.nextLine();
        }
                    
        private void doViewAllPatients()
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** CARS :: Administration Operation :: Patient Management :: View All Patients ***\n");

            List<PatientEntity> patientEntities = patientEntityControllerRemote.retrieveAllPatients();
            System.out.printf("%8s%20s%20s%20s%8s%8s%20s%20s\n", "Patient ID", "Identity Number", "First Name", "Last Name", "Gender", "Age", "Phone", "Address");

            for(PatientEntity patientEntity:patientEntities)
            {
                System.out.printf("%8s%20s%20s%20s%8s%8s%20s%20s\n", patientEntity.getPatientId().toString(), patientEntity.getIdentityNum(), patientEntity.getFirstName(), patientEntity.getLastName(), patientEntity.getGender(), patientEntity.getAge(), patientEntity.getPhone(), patientEntity.getAddress());
            }

            System.out.print("Press any key to continue...> ");
            scanner.nextLine();
        }






    }
