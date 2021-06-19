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

import kodlama.io.hrms.business.abstracts.CandidatesService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidates;


@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesControllers {

	private CandidatesService candidateService;

	
	@Autowired
	public CandidatesControllers(CandidatesService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<Candidates>> getAll(){
    	return this.candidateService.getAll();
    	
    }
    @GetMapping("/getByEmail")
    public DataResult<List<Candidates>> findByEmail(String email){
    	
    return this.candidateService.findByEmail(email);	
    }
    
    @GetMapping("/getByIdentity")
    public DataResult<List<Candidates>> findByIdentityNumber(@RequestParam String identityNumber){
    
    	 
        return this.candidateService.findByIdentityNumber(identityNumber.trim());	
        }
    @PostMapping(value="/add")
    public Result add(@Valid @RequestBody Candidates candidate) {
    	return this.candidateService.add(candidate);
    	
    	
    }
	
	
	
}
