package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="employee_id",referencedColumnName = "id")
@Entity
@Table(name="Employees")
public class Employees extends Users{


	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;



	
	
	
}
