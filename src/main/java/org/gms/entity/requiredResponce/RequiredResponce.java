package org.gms.entity.requiredResponce;

import java.util.List;

import javax.persistence.Entity;

import org.gms.entity.Citizen;
import org.gms.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class RequiredResponce {
	
	private VaccinationCenter center;
	private List<Citizen> citizen;
	public RequiredResponce() {
		super();
	}
	public RequiredResponce(VaccinationCenter center, List<Citizen> citizen) {
		super();
		this.center = center;
		this.citizen = citizen;
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizen() {
		return citizen;
	}
	public void setCitizen(List<Citizen> citizen) {
		this.citizen = citizen;
	}
	@Override
	public String toString() {
		return "RequiredResponce [center=" + center + ", citizen=" + citizen + "]";
	}
	
	
	
}
