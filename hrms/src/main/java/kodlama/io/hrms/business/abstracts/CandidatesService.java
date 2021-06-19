package kodlama.io.hrms.business.abstracts;

import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidates;

public interface CandidatesService {

	DataResult<List<Candidates>> getAll();
    Result add(Candidates candidate);   
	DataResult<List<Candidates>> findByIdentityNumber(String identityNumber);
	DataResult<List<Candidates>> findByEmail(String email);
    DataResult<Boolean> checkValidateByPersonalInfo(String identityNumber,String firstName,String lastName,String birthDate);
}