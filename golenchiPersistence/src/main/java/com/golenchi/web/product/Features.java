package com.golenchi.web.product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.golenchi.web.common.BaseDomain;
import com.golenchi.web.feature.enums.FeatureHeader;
import com.golenchi.web.feature.enums.FeatureType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="FEATURES", 
       uniqueConstraints=@UniqueConstraint(columnNames={"feature_name", "module_id"})
    )
@EqualsAndHashCode(callSuper = false)
public @Data class Features extends BaseDomain{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feature_id")
	private Long featureId;
	
	@Column(name = "feature_name", length = 50 ,  nullable=false)
	private String featureName;
	
	@Column(name = "description", length = 200)
	private String description;
	
	/*@Column(name = "feature", length = 50)
	@Enumerated(EnumType.STRING)
	private Feature feature;*/
		
	@Column(name = "is_default")
	private Boolean isDefault;
	
	@Column(name = "feature_header", length = 50 ,nullable=false)
	@Enumerated(EnumType.STRING)
	private FeatureHeader featureHeader;
	
	@Column(name = "type", length = 50 ,nullable=false)
	@Enumerated(EnumType.STRING)
	private FeatureType featureType;
	
	@JoinColumn(name = "module_id", referencedColumnName = "module_id" ,  nullable=false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Modules modules;
	
}
