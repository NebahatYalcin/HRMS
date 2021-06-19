package kodlama.io.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.utilities.CloudinaryService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {
	
	private ImageDao imageDao;
	private CloudinaryService cloudinaryservice;

	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public Result add(Image image, MultipartFile multipartFile) throws IOException {
		Map photoMap = cloudinaryservice.photoUpload(multipartFile);
		image.setImageUrl(photoMap.get("url").toString());
		 this.imageDao.save(image);
		 return new SuccessResult("Foto eklendi");
	}

	



	

	
	

	
}
