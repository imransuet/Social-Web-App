package com.caveofprogramming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "status_update")
public class StatusUpdate {

	@Id //this annotation for primary key
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO) //how to generate primary keys
	private Long id;

	@Column(name = "text") // annotation of naming attribute is optional
	private String text;

	@Column(name = "added")
	@Temporal(TemporalType.TIMESTAMP) // to save the moment when data is created
	private Date added;

	@PrePersist
	protected void onCreate() {
		if (added == null) {
			added = new Date();
		}
	}
	
	public StatusUpdate() {
		
	}

	public StatusUpdate(String text) {
		this.text = text;
	}

	public StatusUpdate(String text, Date added) {
		this.text = text;
		this.added = added;
	}

	//We need getter and Setter, because hibernate gonna need this
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((added == null) ? 0 : added.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusUpdate other = (StatusUpdate) obj;
		if (added == null) {
			if (other.added != null)
				return false;
		} else if (!added.equals(other.added))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StatusUpdate [id=" + id + ", text=" + text + ", added=" + added + "]";
	}

	
	
	
	

}