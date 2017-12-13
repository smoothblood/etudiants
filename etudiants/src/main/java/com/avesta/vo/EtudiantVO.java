package com.avesta.vo;

import org.joda.time.LocalDateTime;

import com.avesta.utils.Constantes;

public class EtudiantVO {
	
	private int id;
	private String numEtd;
	private String nom;
	private String prenom;
	private LocalDateTime createdDate;
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
	public String getCreatedDateString() {
		return getFormatDate(createdDate);
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public String getUpdatedDateString() {
		return getFormatDate(updatedDate);
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	// Récuperer la date en format de chaine de caractére
	private String getFormatDate(final LocalDateTime localDate) {
		StringBuilder sb = new StringBuilder();
		sb.append(localDate.getDayOfMonth()).append(Constantes.SLASH);
		sb.append(localDate.getMonthOfYear()).append(Constantes.SLASH);
		sb.append(localDate.getYear()).append(Constantes.EMPTY_SPACE);
		sb.append(localDate.getHourOfDay()).append(Constantes.TWO_POINT);
		sb.append(localDate.getMinuteOfHour());
		return sb.toString();
	}
	
}
