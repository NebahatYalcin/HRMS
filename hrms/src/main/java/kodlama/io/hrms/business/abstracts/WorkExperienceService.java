package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.WorkExperienceDto;

public interface WorkExperienceService {
	Result add(WorkExperienceDto workexperienceDto);
	
	DataResult<List<WorkExperienceDto>> getAll();
	
	DataResult<List<WorkExperienceDto>> getAllByResume_ResumeIdOrderByendYearOfWorkDesc(int id);
	
	

}
