package com.golenchi.web.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.golenchi.web.listener.AuditedEntityListener;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditedEntityListener.class)
public @Data class BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "date_added")
	private Date dateAdded;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "date_modified")
	private Date dateModified;
	@Column(name = "modified_by")
	private Integer modifiedBy;
	@Column(name = "delete_flag")
	private Boolean deleteFlag;

}
