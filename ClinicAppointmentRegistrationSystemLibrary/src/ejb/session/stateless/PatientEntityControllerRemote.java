/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.PatientEntity;
import java.util.List;
import util.exception.InvalidLoginCredentialException;
import util.exception.PatientNotFoundException;

/**
 *
 * @author Ismahfaris
 */
public interface PatientEntityControllerRemote {
       PatientEntity createNewPatient(PatientEntity newPatientEntity);
    
    List<PatientEntity> retrieveAllPatients();
    
    PatientEntity retrievePatientByPatientId(Long patientId) throws PatientNotFoundException;
    
    PatientEntity retrievePatientByIdentityNumber(String username) throws PatientNotFoundException;

    PatientEntity patientLogin(String username, String password) throws InvalidLoginCredentialException;

    void updatePatient(PatientEntity patientEntity) throws PatientNotFoundException;
    
    void deletePatient(Long patientId) throws PatientNotFoundException;
}
