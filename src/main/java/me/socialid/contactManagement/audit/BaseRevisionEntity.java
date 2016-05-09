package me.socialid.contactManagement.audit;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.envers.DefaultTrackingModifiedEntitiesRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity(name = "revisions")
@RevisionEntity(BaseRevisionListener.class)
public class BaseRevisionEntity extends DefaultTrackingModifiedEntitiesRevisionEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3096638681249725577L;

	private String user;

    private Date modificationDate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
