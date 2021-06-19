package kodlama.io.hrms.core.utilities.activation;

public interface ActivationService {
	void sendLink(String email);
	String sendCode();

}
