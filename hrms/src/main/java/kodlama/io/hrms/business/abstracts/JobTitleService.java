package kodlama.io.hrms.business.abstracts;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	  	Result add(JobTitle jobtitle );
	    DataResult<List<JobTitle>> getAll();
	    DataResult<List<JobTitle>> findByPosition(String position);
}
