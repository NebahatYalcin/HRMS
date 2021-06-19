package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UsersService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.UsersDao;
import kodlama.io.hrms.entities.concretes.Users;


@Service

public class UsersManager implements UsersService{
	
	private UsersDao usersdao;

	@Autowired
	public UsersManager(UsersDao usersdao) {
		super();
		this.usersdao = usersdao;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>(this.usersdao.findAll());
	}
	


}
