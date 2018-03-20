/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class VistorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitorId;
    private String identityNum;
    private String firstName;
    private String lastName;
    private String purposeOfVisit;


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getVisitorId() != null ? getVisitorId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VistorEntity)) {
            return false;
        }
        VistorEntity other = (VistorEntity) object;
        if ((this.getVisitorId() == null && other.getVisitorId() != null) || (this.getVisitorId() != null && !this.visitorId.equals(other.visitorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VistorEntity[ id=" + getVisitorId() + " ]";
    }
        /**
     * @return the visitorId
     */
    public Long getVisitorId() {
        return visitorId;
    }

    /**
     * @param visitorId the visitorId to set
     */
    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the purposeOfVisit
     */
    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    /**
     * @param purposeOfVisit the purposeOfVisit to set
     */
    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }
}
