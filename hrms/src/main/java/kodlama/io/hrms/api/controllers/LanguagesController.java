package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.dtos.LanguageDto;
@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
	private LanguageService languageService;
@Autowired
public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

@PostMapping("/add")
public Result add(@Valid @RequestBody LanguageDto languageDto) {
	return this.languageService.add(languageDto);
}

	@GetMapping("getAll")
	public DataResult<List<LanguageDto>> getAll(){
		return this.languageService.getAll();
	}


}
