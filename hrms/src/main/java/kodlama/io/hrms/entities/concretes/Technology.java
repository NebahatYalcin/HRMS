package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
@Table(name="technologys")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="technologys_id")
	private int id;
	
	@NotBlank(message ="Bu Alan Boş Geçilemez")
	@Column(name="technology_name")
	private String technologyName;
	
	
	@ManyToOne()
	@JoinColumn(name="resume_id")
	private Resume resume;

}
