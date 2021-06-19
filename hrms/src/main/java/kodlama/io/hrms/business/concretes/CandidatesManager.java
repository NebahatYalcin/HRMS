package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidatesService;
import kodlama.io.hrms.core.utilities.adapters.ValidationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidatesDao;
import kodlama.io.hrms.entities.concretes.Candidates;

@Service
public class CandidatesManager implements CandidatesService{
	private CandidatesDao candidatedao;
    private ValidationService validationservice;
	
    @Autowired
    public CandidatesManager(CandidatesDao candidatedao, ValidationService validationservice) {
		super();
		this.candidatedao = candidatedao;
		this.validationservice = validationservice;
	}



	@Override
	public DataResult<List<Candidates>> getAll() {
		
		return new SuccessDataResult<List<Candidates>>(this.candidatedao.findAll());
	}

	@Override
	public Result add(Candidates candidate) {
		var checkEmail=this.findByEmail(candidate.getEmail()).getData().size() !=0;
		var checkidentityNumber=this.findByIdentityNumber(candidate.getIdentityNumber()).getData().size() !=0;
		var checkValidateByPersonal=!this.checkValidateByPersonalInfo(candidate.getIdentityNumber(), candidate.getFirstName(),candidate.getLastName(), candidate.getBirthDate()).getData();
		
		 
		 if(checkEmail||checkidentityNumber||checkValidateByPersonal) {
			 
			 String errorMessage="";
		 
		 if(checkEmail||checkidentityNumber) {
			 errorMessage+="Email ve Tc No zaten mevcut";
		 }
	     if(checkValidateByPersonal) {
	    	 errorMessage+="Gerçek bir insan değil.";
	     }
		return new ErrorResult(errorMessage);
		 }
		 System.out.println("Çalışmayan yer 1"+candidate.getEmail());
		this.candidatedao.save(candidate);
		return new SuccessResult("Kayıt başarıyla gerçekleşti");
	}

	
	@Override
	public DataResult<List<Candidates>> findByIdentityNumber(String identityNumber) {
		//
		return new SuccessDataResult<List<Candidates>>(this.candidatedao.findByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<List<Candidates>> findByEmail(String email) {
		
		return new  SuccessDataResult<List<Candidates>>(this.candidatedao.findByEmail(email));
	}

	
	



	@Override
	public DataResult<Boolean> checkValidateByPersonalInfo(String identityNumber, String firstName, String lastName,String birthDate) {
		return new DataResult<>(this.validationservice.validationByMernis(identityNumber, firstName, lastName, birthDate),true);
	}

	

}
