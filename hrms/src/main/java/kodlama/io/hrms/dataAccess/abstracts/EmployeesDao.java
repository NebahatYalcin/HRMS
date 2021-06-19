package kodlama.io.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employees;

public interface EmployeesDao extends JpaRepository<Employees, Integer>{
	
	List<Employees> findByEmail(String email);
	
}
