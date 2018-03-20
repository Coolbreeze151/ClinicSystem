/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class AppointmentEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private String identityNum;
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDateTime;  
    private String queueNumber;
      
    
    public AppointmentEntity()
    {
    }

    
    
    public AppointmentEntity(Long patientId, Long doctorId, Date appointmentDateTime, String identityNum) 
    {
        this();
        
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
        this.identityNum = identityNum;
    }
    
    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.getAppointmentId() != null ? this.getAppointmentId().hashCode() : 0);
        
        return hash;
    }

    
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof AppointmentEntity)) 
        {
            return false;
        }
        
        AppointmentEntity other = (AppointmentEntity) object;
        
        if ((this.getAppointmentId() == null && other.getAppointmentId() != null) || (this.getAppointmentId() != null && !this.appointmentId.equals(other.appointmentId))) 
        {
            return false;
        }
        
        return true;
    }

    
    
    @Override
    public String toString() 
    {
        return "entity.AppointmentEntity[ appointmentId=" + this.getAppointmentId() + " ]";
    }
    
      /**
     * @return the appointmentId
     */
    public Long getAppointmentId() {
        return appointmentId;
    }

    /**
     * @param appointmentId the appointmentId to set
     */
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * @return the patientId
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the doctorId
     */
    public Long getDoctorId() {
        return doctorId;
    }

    /**
     * @param doctorId the doctorId to set
     */
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * @return the appointmentDateTime
     */
    public Date getAppointmentDateTime() {
        return appointmentDateTime;
    }

    /**
     * @param appointmentDateTime the appointmentDateTime to set
     */
    public void setAppointmentDateTime(Date appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
        /**
     * @return the identityNum
     */
    public String getIdentityNum() {
        return identityNum;
    }

    /**
     * @param identityNum the identityNum to set
     */
    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }
       /**
     * @return the queueNumber
     */
    public String getQueueNumber() {
        return queueNumber;
    }

    /**
     * @param queueNumber the queueNumber to set
     */
    public void setQueueNumber(String queueNumber) {
        this.queueNumber = queueNumber;
    }
}