package kodlama.io.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) 
@PrimaryKeyJoinColumn(name = "candidate_id",referencedColumnName = "id")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resumes"})
@Table(name="candidates")

public class Candidates extends Users {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;*/
	
	@NotBlank(message="Lütfen isim giriniz.")	
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Lütfen soyisim giriniz.")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="Lütfen TC Kimlik Numarası giriniz.") 
	@Size(min = 11, max=11, message = "TCKimlik No 11 hane olmalıdır")
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotBlank
	@Column(name="birth_date")
	private String birthDate;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	@OneToMany(mappedBy = "candidate")
	private List<Resume> resumes;
	




}
