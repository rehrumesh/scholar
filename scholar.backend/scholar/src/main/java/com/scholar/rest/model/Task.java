package com.scholar.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue
	@Column(name = "taskId")
	private int taskId;

	@Column(name = "description")
	private String description;

	@Column(name = "requestId")
	private int requestId;

	@Column(name = "scholarshipId")
	private int scholarshipId;

	@Column(name = "proveLink")
	private String proveLink;

	@Temporal(TemporalType.DATE)
	@Column(name = "proofAddedDate")
	private Date proofAddedDate;

	@Column(name = "isApproved")
	private boolean isApproved;

	@Temporal(TemporalType.DATE)
	@Column(name = "approvedDate")
	private Date approvedDate;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public String getProveLink() {
		return proveLink;
	}

	public void setProveLink(String proveLink) {
		this.proveLink = proveLink;
	}

	public Date getProofAddedDate() {
		return proofAddedDate;
	}

	public void setProofAddedDate(Date proofAddedDate) {
		this.proofAddedDate = proofAddedDate;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
}
