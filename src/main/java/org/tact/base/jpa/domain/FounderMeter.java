package org.tact.base.jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.ibatis.annotations.Property;

@Entity
public class FounderMeter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",updatable= false)
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="linkedin_link")	
	private String linkedinLink;
	
	@Column(name="auth_meter")
	private Integer authMeter;

	@Column(name="admin_comment")
	private String adminComment;
	
	private Date added_date;
	
	private Date updated_date;
	
	public FounderMeter(){
		
	}
	
	public FounderMeter(String name, String linkedinLink, Integer authMeter, String adminComment){
		this.name = name;
		this.linkedinLink = linkedinLink;
		this.authMeter = authMeter;
		this.adminComment = adminComment;
	}

	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getLinkedinLink() {
		return linkedinLink;
	}
	

	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}
	

	public Integer getAuthMeter() {
		return authMeter;
	}
	

	public void setAuthMeter(Integer authMeter) {
		this.authMeter = authMeter;
	}
	

	public String getAdminComment() {
		return adminComment;
	}
	

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}
	

	public Date getAdded_date() {
		return added_date;
	}
	

	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}
	

	public Date getUpdated_date() {
		return updated_date;
	}
	

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}


	@Override
	public String toString() {
		return "FounderMeter [id=" + id + ", name=" + name + ", linkedinLink=" + linkedinLink + ", authMeter="
				+ authMeter + ", adminComment=" + adminComment + ", added_date=" + added_date + ", updated_date="
				+ updated_date + "]";
	}
}