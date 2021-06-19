package kodlama.io.hrms.mernisService;



public class FakeService {
	public boolean ValidateByPersonalInfo(String identityNumber, String firstName, String lastName, String birth_Date)
	{
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}

}
