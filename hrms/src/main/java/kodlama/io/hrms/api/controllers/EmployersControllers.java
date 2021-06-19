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

import kodlama.io.hrms.business.abstracts.EmployersService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employers;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersControllers {
	
	private EmployersService employerService;
	@Autowired
	public EmployersControllers(EmployersService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employers>> getAll(){
		return this.employerService.getAll();
		
	}
	@GetMapping("/getByEmail")
	public DataResult<List<Employers>> findByEmail(String email){
		return this.employerService.findByEmail(email);
	}
	@PostMapping("/add")
	public Result add( @Valid @RequestBody Employers employer) {
		return this.employerService.add(employer);
	}
	


}
