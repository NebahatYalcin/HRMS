package kodlama.io.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.concretes.Technology;
import kodlama.io.hrms.entities.concretes.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeGetDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int resumeId;
	private int candidate_id;
	private int imageId;
	private String githubAdress;
	private String linkEdin;
	private String coverLetter;
	
	private List<Education> educations;
	private List<Technology> technologys;
	private List<Language> languages;
	private List<WorkExperience> works;
 	

}
