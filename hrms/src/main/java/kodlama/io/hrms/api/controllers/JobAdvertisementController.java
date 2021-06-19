package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;


@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementController {
	

private JobAdvertisementService jobAdvertisementService;

@Autowired
public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
	super();
	this.jobAdvertisementService = jobAdvertisementService;
}

@GetMapping("/getall")
public DataResult<List<JobAdvertisement>> getAll(){
	return this.jobAdvertisementService.getAll();
}
@PostMapping("/add")
public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
	
	return this.jobAdvertisementService.add(jobAdvertisement);
	
}
@GetMapping("/findByActiveTrue")
public DataResult<List<JobAdvertisement>> findByActiveTrue(){
	return this.jobAdvertisementService.findByActiveTrue();
	
}
@GetMapping("/findByEmployer_IdAndActiveTrue")
public DataResult<List<JobAdvertisement>>findByEmployer_IdAndActiveTrue(@RequestParam int employerId){
	return this.findByEmployer_IdAndActiveTrue( employerId);
}
@GetMapping("/findByActiveTrueOrderByCreatedTimeDesc")
public DataResult<List<JobAdvertisement>>findByTrueActiveOrderByCreatedTimeDesc(){
	return this.jobAdvertisementService.findByActiveTrueOrderByCreatedTimeDesc();
}
@GetMapping("/findByIdAndActiveTrue")
public DataResult<JobAdvertisement> findByIdAndActiveTrue(int id){
	return this.findByIdAndActiveTrue(id);	
}
@GetMapping("/findByEmployeeOkTrue")
public DataResult<List<JobAdvertisement>> findByEmployeeOkTrue(){
	return this.jobAdvertisementService.findByEmployeeOkTrue();	
}
@GetMapping("/findByEmployeeOkFalse")
public DataResult<List<JobAdvertisement>> findByEmployeeOkFalse(){
	return this.jobAdvertisementService.findByEmployeeOkFalse();	
}
@GetMapping("/findByWorkType")
public DataResult<List<JobAdvertisement>> findByWorkType(String workType){
	return this.jobAdvertisementService.findByWorkType(workType);	
}
@GetMapping("/findByWorkTime")
public DataResult<List<JobAdvertisement>> findByWorkTime(String workTime){
	return this.jobAdvertisementService.findByWorkTime(workTime);	
}

}
