package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao  extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> findByActiveTrue();
	List<JobAdvertisement> findByEmployerIdAndActiveTrue(int employer_id);	
	List<JobAdvertisement> findByActiveTrueOrderByCreatedTimeDesc();	
	JobAdvertisement findByIdAndActiveTrue(int id);
	List<JobAdvertisement> findByEmployeeOkTrue();
	List<JobAdvertisement> findByEmployeeOkFalse();
	List<JobAdvertisement> findByWorkType(String workType);
	List<JobAdvertisement> findByWorkTime(String workTime);
}
