package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.LanguageDao;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;
    private DtoConverterService dtoConverterService;
	
    @Autowired
	public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService) {
		super();
		this.languageDao = languageDao;
		this.dtoConverterService = dtoConverterService;
	}

	

	@Override
	public Result add(LanguageDto languageDto) {
		languageDao.save((Language)dtoConverterService.dtoClassConverter(languageDto, Language.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<LanguageDto>> getAll() {
		
		return new SuccessDataResult<List<LanguageDto>>(this.dtoConverterService.dtoConverter(this.languageDao.findAll(), LanguageDto.class));
	}

}
