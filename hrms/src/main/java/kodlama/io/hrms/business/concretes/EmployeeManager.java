package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeesDao;
import kodlama.io.hrms.entities.concretes.Employees;
import kodlama.io.hrms.entities.concretes.Employers;




@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeesDao employeesDao;
	@Autowired
	public EmployeeManager(EmployeesDao employeesDao) {
		super();
		this.employeesDao = employeesDao;
	}



	@Override
	public DataResult<List<Employees>> getAll() {
		return null;
	}

	@Override
	public DataResult<Boolean> confirmEmployers(Employers employer, Employees employee) {


		return null;
	}

}
