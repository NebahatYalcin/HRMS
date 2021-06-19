package kodlama.io.hrms.business.abstracts;

import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();	
	Result add( JobAdvertisement jobAdvertisement);	
    DataResult<List<JobAdvertisement>> findByActiveTrue();	
    DataResult<List<JobAdvertisement>>findByEmployer_IdAndActiveTrue(int employer_id);	
  	DataResult<List<JobAdvertisement>>findByActiveTrueOrderByCreatedTimeDesc();	
	DataResult<JobAdvertisement> findByIdAndActiveTrue(int id);
	DataResult<List<JobAdvertisement>> findByEmployeeOkTrue();
	DataResult<List<JobAdvertisement>> findByEmployeeOkFalse();
	DataResult<List<JobAdvertisement>> findByWorkType(String workType);
	DataResult<List<JobAdvertisement>> findByWorkTime(String workTime);
}
