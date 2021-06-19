package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ActivaitonCodeService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlama.io.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivaitonCodeService {
	
	private ActivationCodeDao activationdao;

	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationdao) {
		super();
		this.activationdao = activationdao;
	}

	@Override
	public Result add(ActivationCode code) {
		this.activationdao.save(code);
		
		return new SuccessResult("Activation code save");
	}

}
