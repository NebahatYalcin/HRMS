package kodlama.io.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {

	private EducationDao educaitonDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public EducationManager(EducationDao educaitonDao, DtoConverterService dtoConverterService) {
		super();
		this.educaitonDao = educaitonDao;
		this.dtoConverterService = dtoConverterService;
	}

	
	@Override
	public Result add(EducationDto educationDto) {
	 educaitonDao.save((Education)dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Okul Kayıdı Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<EducationDto>> getAll() {
		
		return new SuccessDataResult<List<EducationDto>>(this.dtoConverterService.dtoConverter(this.educaitonDao.findAll(),EducationDto.class));
	}





	@Override
	public DataResult<List<EducationDto>> findAllByResume_ResumeIdOrderByEndYearOfSchoolDesc(int id) {
	
		return new SuccessDataResult<List<EducationDto>>(this.dtoConverterService.dtoConverter(this.educaitonDao.findAllByResume_ResumeIdOrderByEndYearOfSchoolDesc(id), EducationDto.class));
	}
}


