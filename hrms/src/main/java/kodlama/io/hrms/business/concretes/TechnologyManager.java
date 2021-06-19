package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.TechnologyService;
import kodlama.io.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.TechnologyDao;
import kodlama.io.hrms.entities.concretes.Technology;
import kodlama.io.hrms.entities.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyDao technologyDao; 
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
		super();
		this.technologyDao = technologyDao;
		this.dtoConverterService = dtoConverterService;
	}

	

	

	@Override
	public Result add(TechnologyDto technologyDto) {
		technologyDao.save((Technology) dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public DataResult<List<TechnologyDto>> getAll() {
		
		return new SuccessDataResult<List<TechnologyDto>>(this.dtoConverterService.dtoConverter(this.technologyDao.findAll(), TechnologyDto.class));
	}

}
