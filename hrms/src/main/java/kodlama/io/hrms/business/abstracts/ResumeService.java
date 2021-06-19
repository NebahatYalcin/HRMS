package kodlama.io.hrms.business.abstracts;

import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.ResumeAddDto;
import kodlama.io.hrms.entities.dtos.ResumeGetDto;


public interface ResumeService {
	Result add(ResumeAddDto resumeAddDto);
	
	DataResult<List<ResumeGetDto>> getAll();
	
	
	DataResult<List<ResumeGetDto>> findAllByCandidateUserId(int id);

}
