package com.visog.pasupukumkuma.model.transactional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.visog.pasupukumkuma.model.AbstractModel;
import com.visog.pasupukumkuma.model.master.Gender;
import com.visog.pasupukumkuma.model.master.Nakshatram;
import com.visog.pasupukumkuma.model.master.Raasi;
import com.visog.pasupukumkuma.model.master.Roles;
import com.visog.pasupukumkuma.model.master.Status;

@Table(name ="PUJA_ORDER")
public class PujaOrder extends AbstractModel {
	
	@Id
	@Column(name ="ID")
	private String id;
	
	@Column(name ="USER_ID")
	private String userId;
	
	@Column(name ="PUJA_ID")
	private String pujaId;
	
	@Column(name =" amount")
	private String alternativeEmail;
	
    @Column(name ="PASSWORD")
	private String password;
	
    @Column(name ="PHONE_NO")
	private String phoneNo;
	
    @Column(name ="DOB")
	private Date dob;
	
    @Column(name ="BIRTH_PLACE")
	private String birthPlace;
	
    @Column(name ="BIRTH_TIME")
	private String birthTime;
	
	@ManyToOne
	@JoinColumn(name ="RAASI_ID")
	private Raasi rassi;
	
	@ManyToOne
	@JoinColumn(name ="NAKSHATRAM_ID")
	private Nakshatram nakshatram;
	
	@ManyToOne
	@JoinColumn(name ="ROLE_ID")
	private Roles role;
	
	@ManyToOne
	@JoinColumn(name ="GENDER_ID")
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name ="STATUS_ID")
	private Status status;
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	

}
