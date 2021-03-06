package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) 
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
@Table(name="resumes")
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_id")
	private int resumeId;
	
	
	@Column(name="github_adress")
	private String githubAdress;
	
	@Column(name="linkedin_adress")
	private String linkEdin;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidates candidate;
	
	

	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	


	@OneToMany(mappedBy = "resume")
	private List<Education> educations;
	


	@OneToMany(mappedBy = "resume")
	private List<Technology> technologys;
	
	


	@OneToMany(mappedBy = "resume")
	private List<WorkExperience> works;
	
	

}
