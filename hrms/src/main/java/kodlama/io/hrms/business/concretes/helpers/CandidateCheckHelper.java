package kodlama.io.hrms.business.concretes.helpers;

import kodlama.io.hrms.entities.concretes.Candidates;

public class CandidateCheckHelper {
	public static boolean allFieldsAreRequried(Candidates candidate) {
		if(candidate.getEmail().strip().isEmpty()
				|| candidate.getPassword().strip().isEmpty()
				|| candidate.getFirstName().strip().isEmpty()
				|| candidate.getLastName().isEmpty()
				|| candidate.getIdentityNumber().strip().isEmpty()
				|| candidate.getBirthDate().toString().strip().isEmpty()) {
			return false;
			
		}
		return true;
	}

}
