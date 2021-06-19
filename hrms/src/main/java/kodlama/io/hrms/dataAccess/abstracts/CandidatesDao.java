package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Candidates;

public interface CandidatesDao extends JpaRepository<Candidates, Integer>{

	List<Candidates> findByIdentityNumber(String identityNumber);
	List<Candidates> findByEmail(String email);
}
