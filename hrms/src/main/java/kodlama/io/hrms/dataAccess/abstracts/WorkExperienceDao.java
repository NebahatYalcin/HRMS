package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
	List<WorkExperience> findAllByResume_ResumeIdOrderByEndYearOfWorkDesc(int resumeId);
	

}
