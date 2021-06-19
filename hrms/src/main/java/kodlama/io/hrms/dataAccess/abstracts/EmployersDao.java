package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer> {
	
	List<Employers> findByEmail(String email);
}
