package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ResumeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.dtos.ResumeAddDto;
import kodlama.io.hrms.entities.dtos.ResumeGetDto;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin

public class ResumesController {
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	@PostMapping("/add")
	public Result add(ResumeAddDto resume) {
		return this.resumeService.add(resume);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeGetDto>> getAll(){
		return this.resumeService.getAll();
	}
	
	@GetMapping("/findAllByCandidateUserId")
	public DataResult<List<ResumeGetDto>> findAllByCandidateUserId(int id){
		return this.resumeService.findAllByCandidateUserId(id);
				
		
	}

}
