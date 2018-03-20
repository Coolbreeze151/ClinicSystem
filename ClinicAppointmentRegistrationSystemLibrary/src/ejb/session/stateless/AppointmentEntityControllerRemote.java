/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AppointmentEntity;
import java.util.List;
import util.exception.AppointmentNotFoundException;

/**
 *
 * @author user
 */
public interface AppointmentEntityControllerRemote {
    AppointmentEntity createNewAppointment(AppointmentEntity newAppointmentEntity);
    
    List<AppointmentEntity> retrieveAllAppointments();
    
    AppointmentEntity retrieveAppointmentByAppointmentId(Long appointmentId) throws AppointmentNotFoundException;
    
    List<AppointmentEntity> retrieveAppointmentByPatientId(Long patientId) throws AppointmentNotFoundException;

    void updateAppointment(AppointmentEntity appointmentEntity) throws AppointmentNotFoundException;
    
    void deleteAppointment(Long appointmentId) throws AppointmentNotFoundException;
}
