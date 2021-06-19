package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.WorkExperienceService;
import kodlama.io.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlama.io.hrms.entities.concretes.WorkExperience;
import kodlama.io.hrms.entities.dtos.WorkExperienceDto;

@Service
public class WorkExperienceManager implements WorkExperienceService{
	
	private WorkExperienceDao workExperienceDao;
    private DtoConverterService dtoConverterService;
    
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.workExperienceDao = workExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<WorkExperienceDto>> getAll() {
		
		return new SuccessDataResult<List<WorkExperienceDto>>
		(this.dtoConverterService.dtoConverter(this.workExperienceDao.findAll(),WorkExperienceDto.class));
	}

	@Override
	public Result add(WorkExperienceDto workExperienceDto) {
		workExperienceDao.save((WorkExperience)dtoConverterService.dtoClassConverter(workExperienceDto, WorkExperience.class));
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public DataResult<List<WorkExperienceDto>> getAllByResume_ResumeIdOrderByendYearOfWorkDesc(int id) {
		
		return new SuccessDataResult<List<WorkExperienceDto>>
		(this.dtoConverterService.dtoConverter(this.workExperienceDao.findAllByResume_ResumeIdOrderByEndYearOfWorkDesc(id), WorkExperienceDto.class));
	}

	

}
