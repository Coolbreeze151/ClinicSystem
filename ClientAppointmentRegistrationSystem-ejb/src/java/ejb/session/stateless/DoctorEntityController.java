/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.DoctorEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.InvalidLoginCredentialException;
import util.exception.DoctorNotFoundException;

/**
 *
 * @author user
 */
@Stateless
@Local(DoctorEntityControllerLocal.class)
@Remote(DoctorEntityControllerRemote.class)

public class DoctorEntityController implements DoctorEntityControllerLocal, DoctorEntityControllerRemote
{

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;
    
    
    
    
    public DoctorEntityController()
    {
    }
    
    
    
    @Override
    public DoctorEntity createNewDoctor(DoctorEntity newDoctorEntity)
    {
        entityManager.persist(newDoctorEntity);
        entityManager.flush();
        
        return newDoctorEntity;
    }
    
    
    
    @Override
    public List<DoctorEntity> retrieveAllDoctors()
    {
        Query query = entityManager.createQuery("SELECT s FROM DoctorEntity s");
        
        return query.getResultList();
    }
    
    
    
    @Override
    public DoctorEntity retrieveDoctorByDoctorId(Long doctorId) throws DoctorNotFoundException
    {
        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, doctorId);
        
        if(doctorEntity != null)
        {
            return doctorEntity;
        }
        else
        {
            throw new DoctorNotFoundException("Doctor ID " + doctorId + " does not exist!");
        }
    }
    
    
    
    @Override
    public DoctorEntity retrieveDoctorByRegistration(String registration) throws DoctorNotFoundException
    {
        Query query = entityManager.createQuery("SELECT s FROM DoctorEntity s WHERE s.registration = :inRegistration");
        query.setParameter("inRegistration", registration);
        
        try
        {
            return (DoctorEntity)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new DoctorNotFoundException("Doctor registration " + registration + " does not exist!");
        }
    }
 
    @Override
    public void updateDoctor(DoctorEntity doctorEntity) throws DoctorNotFoundException
    {
        if(doctorEntity != null && doctorEntity.getDoctorId() != null){
            DoctorEntity doctorEntityUpdate = retrieveDoctorByDoctorId(doctorEntity.getDoctorId());
            
            if(doctorEntity.getRegistration().equals(doctorEntityUpdate.getRegistration())){
             doctorEntityUpdate.setFirstName(doctorEntity.getFirstName());
             doctorEntityUpdate.setLastName(doctorEntity.getLastName());
             doctorEntityUpdate.setRegistration(doctorEntity.getRegistration());
             doctorEntityUpdate.setQualifications(doctorEntity.getQualifications());
             
            }
        }
        entityManager.merge(doctorEntity);
    }
    
    
    
    @Override
    public void deleteDoctor(Long doctorId) throws DoctorNotFoundException
    {
        DoctorEntity doctorEntityToRemove = retrieveDoctorByDoctorId(doctorId);
        entityManager.remove(doctorEntityToRemove);
    }
}