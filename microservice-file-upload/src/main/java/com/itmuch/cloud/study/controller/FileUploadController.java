package com.itmuch.cloud.study.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping
	@ResponseBody
	public String hanleFileUpload(@RequestParam(value="file",
	required=true) MultipartFile file) throws IOException{
		byte[] bytes = file.getBytes();
		File fileToSaveFile = new File(file.getOriginalFilename());
		FileCopyUtils.copy(bytes,fileToSaveFile);
		return fileToSaveFile.getAbsolutePath();
	}
	
}
