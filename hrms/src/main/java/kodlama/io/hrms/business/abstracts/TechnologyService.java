package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {
	Result add(TechnologyDto technologyDto);
	
	DataResult<List<TechnologyDto>> getAll();

}
