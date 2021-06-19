package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobTitle;


public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{


    List<JobTitle> findByPosition(String position);
}
