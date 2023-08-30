package com.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "notes")
public class Note {
	
	
	@Id
	private int id;
	private String title;
	@Column(length = 1500000)
	private String content;
	private Date  addeDate;
	
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddeDate() {
		return addeDate;
	}
	public void setAddeDate(Date addeDate) {
		this.addeDate = addeDate;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Note( String title, String content, Date addeDate) {
		super();
		this.id = new Random().nextInt(1000);
		this.title = title;
		this.content = content;
		this.addeDate = addeDate;
	}
	
	
}
