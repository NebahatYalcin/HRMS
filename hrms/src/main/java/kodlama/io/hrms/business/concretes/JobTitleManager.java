package kodlama.io.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.hrms.business.abstracts.JobTitleService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobtitledao;
	@Autowired
	public JobTitleManager(JobTitleDao jobtitledao) {
		super();
		this.jobtitledao = jobtitledao;
	}
	@Override
	public Result add(JobTitle jobtitle) {
		if(findByPosition(jobtitle.getPosition()).getData()!=null) {
			return new ErrorResult( jobtitle.getPosition()+"Jobtitle eklenemedi");
		}
		this.jobtitledao.save(jobtitle);
		return new SuccessResult("JobTitle Eklendi");
	}
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>( this.jobtitledao.findAll());
		
	}
	@Override
	public DataResult<List<JobTitle>> findByPosition(String position) {
		return new SuccessDataResult<List<JobTitle>>(this.jobtitledao.findByPosition(position));


	}



}
