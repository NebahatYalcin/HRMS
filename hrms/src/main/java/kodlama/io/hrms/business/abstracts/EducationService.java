package kodlama.io.hrms.business.abstracts;

import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.EducationDto;

public interface EducationService {
	
	Result add(EducationDto educationDto);
	DataResult<List<EducationDto>> getAll();
   DataResult<List<EducationDto>> findAllByResume_ResumeIdOrderByEndYearOfSchoolDesc(int resumeId);

	
	

}
