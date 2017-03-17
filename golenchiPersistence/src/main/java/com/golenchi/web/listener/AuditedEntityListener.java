package com.golenchi.web.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.golenchi.web.common.BaseDomain;
import com.golenchi.web.user.User;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving auditedEntity events.
 * The class that is interested in processing a auditedEntity
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAuditedEntityListener<code> method. When
 * the auditedEntity event occurs, that object's appropriate
 * method is invoked.
 *
 * @see AuditedEntityEvent
 */
public class AuditedEntityListener {

	/**
	 * Sets the new audit info.
	 *
	 * @param baseDomain the new new audit info
	 */
	@PrePersist
	public void setNewAuditInfo(BaseDomain baseDomain) {
		baseDomain.setDateAdded(new Date());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Integer createdBy=null;
		
		
		/*Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String createdBy=null;
		if (principal instanceof UserDetails) {
			createdBy = ((UserDetails) principal).getUsername()();
		}*/
		
		baseDomain.setCreatedBy(createdBy);
		baseDomain.setDeleteFlag(false);
	}

	/**
	 * Sets the update audit info.
	 *
	 * @param baseDomain the new update audit info
	 */
	@PreUpdate
	public void setUpdateAuditInfo(BaseDomain baseDomain) {
		baseDomain.setDateModified(new Date());
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer modifiedBy=null;
		if (principal instanceof User) {
			modifiedBy = ((User) principal).getUserId();
		}
		baseDomain.setModifiedBy(modifiedBy);
	}
}
