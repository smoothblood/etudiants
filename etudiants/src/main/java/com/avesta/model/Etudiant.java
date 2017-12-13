package com.avesta.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ETUDIANT")
public class Etudiant {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Column(name="NUM_ETD", nullable = false)
	private String numEtd;
	
	@NotEmpty
	@Column(name="NOM", nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name="PRENOM", nullable = false)
	private String prenom;

	@Column(name="CREATED_DATE")
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime createdDate;

	@Column(name="UPDATED_DATE")
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime updatedDate;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumEtd() {
		return numEtd;
	}
	public void setNumEtd(String numEtd) {
		this.numEtd = numEtd;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	public List<String> getAllClassAttributes() {
		List<String> listColumn = new ArrayList<>();
		(new ReflectionToStringBuilder(this) {
			protected boolean accept(Field f) {
				listColumn.add( f.getName() );
				return super.accept(f) ; //&& !f.getName().equals("id")
			}
		}).toString();
		return listColumn;
	}
	
}
