    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package ams;

import ejb.session.stateless.AppointmentEntityControllerRemote;
    import ejb.session.stateless.DoctorEntityControllerRemote;
    import ejb.session.stateless.PatientEntityControllerRemote;
    import ejb.session.stateless.StaffEntityControllerRemote;


    /**
     *
     * @author Ismahfaris
     */
    public class AmsModule {
        private StaffEntityControllerRemote staffEntityControllerRemote;
        private DoctorEntityControllerRemote doctorEntityControllerRemote;
        private PatientEntityControllerRemote patientEntityControllerRemote;

        private AppointmentEntityControllerRemote appointmentEntityControllerRemote;



        public AmsModule()
        {
        }



        public AmsModule(PatientEntityControllerRemote patientEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, AppointmentEntityControllerRemote appointmentEntityControllerRemote) 
        {
            this();
            this.patientEntityControllerRemote = patientEntityControllerRemote;
            this.doctorEntityControllerRemote = doctorEntityControllerRemote;
            this.appointmentEntityControllerRemote = appointmentEntityControllerRemote;
        }



        public void doViewAppointment() 
        {

        }
        
        public void doAddAppointment() 
        {

        }

        public void doCancelAppointment() 
        {

        }

    }
