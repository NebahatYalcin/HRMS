package kodlama.io.hrms.business.concretes.helpers;

import kodlama.io.hrms.entities.concretes.Employers;

public class EmployerCheckHelper {
	
	public static boolean allFieldsAreRequried(Employers employer) {
		if(employer.getEmail().strip().isEmpty()
				|| employer.getPassword().strip().isEmpty()
				|| employer.getCompanyName().strip().isEmpty()
				|| employer.getWebAdress().strip().isEmpty()) {
			return false;
		}
		return true;
	}

}
