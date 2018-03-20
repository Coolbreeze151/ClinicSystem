/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.PatientEntity;
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
import util.exception.PatientNotFoundException;

/**
 *
 * @author Ismahfaris
 */
@Stateless
@Local(PatientEntityControllerLocal.class)
@Remote(PatientEntityControllerRemote.class)

public class PatientEntityController implements PatientEntityControllerLocal, PatientEntityControllerRemote
{

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;
    
    
    
    
    public PatientEntityController()
    {
    }
    
    
    
    @Override
    public PatientEntity createNewPatient(PatientEntity newPatientEntity)
    {
        entityManager.persist(newPatientEntity);
        entityManager.flush();
        
        return newPatientEntity;
    }
    
    
    
    @Override
    public List<PatientEntity> retrieveAllPatients()
    {
        Query query = entityManager.createQuery("SELECT s FROM PatientEntity s");
        
        return query.getResultList();
    }
    
    
    
    @Override
    public PatientEntity retrievePatientByPatientId(Long patientId) throws PatientNotFoundException
    {
        PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientId);
        
        if(patientEntity != null)
        {
            return patientEntity;
        }
        else
        {
            throw new PatientNotFoundException("Patient ID " + patientId + " does not exist!");
        }
    }
    
    
    
    @Override
    public PatientEntity retrievePatientByIdentityNumber(String identityNumber) throws PatientNotFoundException
    {
        Query query = entityManager.createQuery("SELECT s FROM PatientEntity s WHERE s.identityNum = :inIdentityNumber");
        query.setParameter("inIdentityNumber", identityNumber);
        
        try
        {
            return (PatientEntity)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new PatientNotFoundException("Patient IdentityNumber " + identityNumber + " does not exist!");
        }
    }
    
    
    
    @Override
    public PatientEntity patientLogin(String identityNumber, String securityCode) throws InvalidLoginCredentialException
    {
        try
        {
            PatientEntity patientEntity = retrievePatientByIdentityNumber(identityNumber);
            
            if(patientEntity.getSecurityCode().equals(securityCode))
            {
                return patientEntity;
            }
            else
            {
                throw new InvalidLoginCredentialException("IdentityNumber does not exist or invalid securityCode!");
            }
        }
        catch(PatientNotFoundException ex)
        {
            throw new InvalidLoginCredentialException("IdentityNumber does not exist or invalid securityCode!");
        }
    }
    
    
    
    @Override
    public void updatePatient(PatientEntity patientEntity) throws PatientNotFoundException
    {
        if(patientEntity != null && patientEntity.getPatientId() != null){
            PatientEntity patientEntityUpdate = retrievePatientByPatientId(patientEntity.getPatientId());
            
            if(patientEntity.getIdentityNum().equals(patientEntityUpdate.getIdentityNum())){
             patientEntityUpdate.setFirstName(patientEntity.getFirstName());
             patientEntityUpdate.setLastName(patientEntity.getLastName());
             patientEntityUpdate.setGender(patientEntity.getGender());
             
             
            }
        }
        entityManager.merge(patientEntity);
    }
    
    
    
    @Override
    public void deletePatient(Long patientId) throws PatientNotFoundException
    {
        PatientEntity patientEntityToRemove = retrievePatientByPatientId(patientId);
        entityManager.remove(patientEntityToRemove);
    }
}