package ebook.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping(method = RequestMethod.POST, value = "/image")
public interface ImageService {
    public Object getFile(String filename);
    public Object singleFileUpload(String ISBN, MultipartFile file);
}
