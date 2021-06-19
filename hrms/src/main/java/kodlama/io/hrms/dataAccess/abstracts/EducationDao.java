package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	

	List<Education> findAllByResume_ResumeIdOrderByEndYearOfSchoolDesc(int id);

}
