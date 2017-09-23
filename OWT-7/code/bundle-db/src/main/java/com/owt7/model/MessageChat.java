package com.owt7.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MessageChat {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ids_gen")
    @SequenceGenerator(
    		name="ids_gen",
    		sequenceName="ids_sequence",
    		allocationSize=20
    	)
    private Integer id;


    private String name;
	

	private String message;
	

	private Date date;
	
	private boolean responded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isResponded() {
		return responded;
	}

	public void setResponded(boolean responded) {
		this.responded = responded;
	}
}
