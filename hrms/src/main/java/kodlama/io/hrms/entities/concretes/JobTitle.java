package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobadvertisements"})
public class JobTitle {
	@Id
	@GeneratedValue
	@Column(name="job_title_id")
	private int id;
	
	@Column(name="position")
	private String position;
	
	@OneToMany(mappedBy = "jobtitle")
	private List<JobAdvertisement> jobadvertisements;

	

}
