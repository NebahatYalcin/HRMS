package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.dtos.EducationDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	@GetMapping("/getAll")
	public DataResult<List<EducationDto>> getAll(){
		return this.educationService.getAll();
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EducationDto educationDto) {
		return this.educationService.add(educationDto);
	}
	
@GetMapping("/Desc")
public DataResult<List<EducationDto>> findAllByResume_ResumeIdOrderByendYearOfSchoolDesc(@RequestParam int id){
		return this.educationService.findAllByResume_ResumeIdOrderByEndYearOfSchoolDesc(id);
	}

}
	


