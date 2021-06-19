package kodlama.io.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ResumeService;
import kodlama.io.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ResumeDao;
import kodlama.io.hrms.entities.concretes.Resume;
import kodlama.io.hrms.entities.dtos.ResumeAddDto;
import kodlama.io.hrms.entities.dtos.ResumeGetDto;


@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeAddDto resumeAddDto) {
		this.resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeAddDto, Resume.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	

	@Override
	public DataResult<List<ResumeGetDto>> getAll() {
		
		return new SuccessDataResult<List<ResumeGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeDao.findAll(), ResumeGetDto.class));
	}

	@Override
	public DataResult<List<ResumeGetDto>> findAllByCandidateUserId(int id) {
		
	   return new SuccessDataResult<List<ResumeGetDto>>(this.dtoConverterService.dtoConverter(this.resumeDao.findAll(),ResumeGetDto.class));

	
	}
	
	

}
