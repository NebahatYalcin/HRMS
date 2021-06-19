package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployersService;
import kodlama.io.hrms.business.concretes.helpers.EmployeeCheckHelper;
import kodlama.io.hrms.business.concretes.helpers.EmployerCheckHelper;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.dataAccess.abstracts.EmployersDao;
import kodlama.io.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService {
	
	private EmployersDao employersDao;
	@Autowired
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}
	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll());
	}
	@Override
	public Result add(Employers employer) {
		var checkEmail=this.findByEmail(employer.getEmail()).getData().size()!=0;	
		var checkFields=!EmployerCheckHelper.allFieldsAreRequried(employer);
		var checkConfirm=!EmployeeCheckHelper.confirmEmployer(employer);
		
		if(checkEmail|| checkFields|| checkConfirm) {
			String errorMessage="";
			if(checkEmail) {
				errorMessage+="Email Zaten Mevcut.";
			}
			if(checkFields) {
				errorMessage+="Bütün Alanlar Zorunludur.";
				
			}
			if(checkConfirm) {
				errorMessage+="Kayıt onay işleminiz Çalışanımız tarafından reddedildi.";
			}
			return new ErrorResult(errorMessage);
		}
		
		this.employersDao.save(employer);
		return new SuccessResult(true,"Kayıdınız Başarıyla gerçekleşti.");
	}
	@Override
	public DataResult<List<Employers>> findByEmail(String email) {
		return new SuccessDataResult<List<Employers>>(this.employersDao.findByEmail(email));
	}
	
	




}
