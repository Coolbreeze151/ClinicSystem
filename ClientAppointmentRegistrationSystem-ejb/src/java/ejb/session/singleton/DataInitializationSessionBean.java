/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.singleton;

import ejb.session.stateless.DoctorEntityControllerLocal;
import ejb.session.stateless.PatientEntityControllerLocal;
import ejb.session.stateless.StaffEntityControllerLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import util.exception.StaffNotFoundException;
import entity.StaffEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
@Singleton
@LocalBean
@Startup

public class DataInitializationSessionBean
{
    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;
    
    @EJB
    private StaffEntityControllerLocal staffEntityControllerLocal;
    @EJB
    private DoctorEntityControllerLocal doctorEntityControllerLocal;
    @EJB
    private PatientEntityControllerLocal patientEntityControllerLocal;
    
    
    
    public DataInitializationSessionBean()
    {
    }
    
    
    
    @PostConstruct
    public void postConstruct()
    {
        try
        {
            staffEntityControllerLocal.retrieveStaffByUsername("manager");
        }
        catch(StaffNotFoundException ex)
        {
            initializeData();
        }
    }
    

    private void initializeData(){
         staffEntityControllerLocal.createNewStaff(new StaffEntity("Linda", "Chua", "manager", "password"));
         staffEntityControllerLocal.createNewStaff(new StaffEntity("Barbara", "Durham", "nurse", "password"));
        
         doctorEntityControllerLocal.createNewDoctor(new DoctorEntity("Peter", "Lee", "S18018", "MBBS"));
         doctorEntityControllerLocal.createNewDoctor(new DoctorEntity("Cindy", "Leong", "S64921", "MBBS"));
         doctorEntityControllerLocal.createNewDoctor(new DoctorEntity("Matthew", "Liu", "S38101", "MBBS"));
         
         patientEntityControllerLocal.createNewPatient(new PatientEntity("S7483027A", "123456", "Tony", "Teo", "Male", "44", "87297373", "11 Tampines Ave 3"));
         patientEntityControllerLocal.createNewPatient(new PatientEntity("S8381028X", "246800", "Wendy", "Tan", "Female", "35", "97502837", "15 Computing Dr"));
        
    }

}