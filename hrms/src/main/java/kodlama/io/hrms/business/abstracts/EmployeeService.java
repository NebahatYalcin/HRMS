package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Employees;
import kodlama.io.hrms.entities.concretes.Employers;

public interface EmployeeService {
	
	DataResult<List<Employees>> getAll();
	DataResult<Boolean> confirmEmployers (Employers employer,Employees employee);
}
