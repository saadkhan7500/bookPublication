package com.book.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	static final String UPLOAD_DIR="C:\\Users\\RH0593\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\BookCRUD\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile file)
	{
		boolean f=false;
		
		try
		{
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
	        f=true;	
		}
		catch (Exception e) {

          e.printStackTrace();
          
         }
		return f;
	}

}
