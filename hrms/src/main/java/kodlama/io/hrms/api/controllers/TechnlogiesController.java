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
import kodlama.io.hrms.business.abstracts.TechnologyService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.TechnologyDto;

@RestController
@RequestMapping("/api/technlogies")
@CrossOrigin
public class TechnlogiesController {
private TechnologyService technologyService;

@Autowired
public TechnlogiesController(TechnologyService technologyService) {
	super();
	this.technologyService = technologyService;
}
@PostMapping("/add")
public Result add(@Valid @RequestBody TechnologyDto technology) {
	return this.technologyService.add(technology);
	
}
@GetMapping("/getAll")
public DataResult<List<TechnologyDto>> getAll(){
	return this.technologyService.getAll();
	
}

}
