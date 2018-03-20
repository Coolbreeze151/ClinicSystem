/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AppointmentEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.AppointmentNotFoundException;

/**
 *
 * @author user
 */
@Stateless
@Local(AppointmentEntityControllerLocal.class)
@Remote(AppointmentEntityControllerRemote.class)

public class AppointmentEntityController implements AppointmentEntityControllerLocal, AppointmentEntityControllerRemote
{

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;
    
    
    
    
    public AppointmentEntityController()
    {
    }
    
    
    
    @Override
    public AppointmentEntity createNewAppointment(AppointmentEntity newAppointmentEntity)
    {
        entityManager.persist(newAppointmentEntity);
        entityManager.flush();
        
        return newAppointmentEntity;
    }
    
    
    
    @Override
    public List<AppointmentEntity> retrieveAllAppointments()
    {
        Query query = entityManager.createQuery("SELECT s FROM AppointmentEntity s");
        
        return query.getResultList();
    }
    
    
    
    @Override
    public AppointmentEntity retrieveAppointmentByAppointmentId(Long appointmentId) throws AppointmentNotFoundException
    {
        AppointmentEntity appointmentEntity = entityManager.find(AppointmentEntity.class, appointmentId);
        
        if(appointmentEntity != null)
        {
            return appointmentEntity;
        }
        else
        {
            throw new AppointmentNotFoundException("Appointment ID " + appointmentId + " does not exist!");
        }
    }
    
    
    
    @Override
    public List<AppointmentEntity> retrieveAppointmentByPatientId(Long patientId) throws AppointmentNotFoundException
    {
        Query query = entityManager.createQuery("SELECT s FROM AppointmentEntity s WHERE s.patientId = :inPatiendId");
        query.setParameter("inPatientId", patientId);
        
        try
        {
            return query.getResultList();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new AppointmentNotFoundException("Patient " + patientId + " does not exist!");
        }
    }
 
    @Override
    public void updateAppointment(AppointmentEntity appointmentEntity) throws AppointmentNotFoundException
    {
        if(appointmentEntity != null && appointmentEntity.getAppointmentId() != null){
            AppointmentEntity appointmentEntityUpdate = retrieveAppointmentByAppointmentId(appointmentEntity.getAppointmentId());
            
            if(appointmentEntity.getAppointmentDateTime().equals(appointmentEntityUpdate.getAppointmentDateTime())){
             appointmentEntityUpdate.setDoctorId(appointmentEntity.getDoctorId());           
            }
        }
        entityManager.merge(appointmentEntity);
    }
    
    
    
    @Override
    public void deleteAppointment(Long appointmentId) throws AppointmentNotFoundException
    {
        AppointmentEntity appointmentEntityToRemove = retrieveAppointmentByAppointmentId(appointmentId);
        entityManager.remove(appointmentEntityToRemove);
    }
}