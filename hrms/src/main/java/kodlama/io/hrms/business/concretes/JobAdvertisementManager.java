package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}


	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return  new SuccessResult("Başarıyla eklendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrue());


	}


	@Override
	public DataResult<List<JobAdvertisement>> findByEmployer_IdAndActiveTrue(int employer_id){
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployerIdAndActiveTrue(employer_id));

	}


	@Override
	public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreatedTimeDesc() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByCreatedTimeDesc());
	}


	@Override
	public DataResult<JobAdvertisement> findByIdAndActiveTrue(int id) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findByIdAndActiveTrue(id)) ;
	}
	@Override
	public DataResult<List<JobAdvertisement>> findByEmployeeOkTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployeeOkTrue()) ;
	}
	@Override
	public DataResult<List<JobAdvertisement>> findByEmployeeOkFalse() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployeeOkFalse()) ;
	}
	@Override
	public DataResult<List<JobAdvertisement>> findByWorkType(String workType) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByWorkType(workType)) ;
	}
	@Override
	public DataResult<List<JobAdvertisement>> findByWorkTime(String workTime) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByWorkTime(workTime)) ;
	}
}
