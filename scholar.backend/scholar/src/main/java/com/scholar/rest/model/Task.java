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
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue
	@Column(name="taskId")
	private int taskId;
	
	@Column(name="description")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	@Column(name="assignedBy")
	private int assignedBy;
	
	@Column(name="assignedTo")
	private int assignedTo;
	
	@Column(name="completedOrNot")
	private String completedOrNo;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(int assignedBy) {
		this.assignedBy = assignedBy;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getCompletedOrNo() {
		return completedOrNo;
	}
	public void setCompletedOrNo(String completedOrNo) {
		this.completedOrNo = completedOrNo;
	}
}
