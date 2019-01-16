package org.tact.base.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tact.base.jpa.domain.FounderMeter;

public interface FounderMeterRepository extends JpaRepository<FounderMeter, Integer> {

	FounderMeter findByLinkedinLink(String liLink);
	
	// https://stackoverflow.com/questions/35711184/how-to-use-orderby-with-greaterthan-spring-jpa
	List<FounderMeter> findByAuthMeterGreaterThan(Integer authMeter);
	
	
	// https://stackoverflow.com/questions/35711184/how-to-use-orderby-with-greaterthan-spring-jpa
	List<FounderMeter> findByAuthMeterGreaterThanOrderByAuthMeterDesc(Integer authMeter);
	
	List<FounderMeter> findAllByOrderByAuthMeterDesc();
}
