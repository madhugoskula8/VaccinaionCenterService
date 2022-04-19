package org.gms.repository;

import org.gms.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepo extends JpaRepository<VaccinationCenter, Integer> {
	

}
