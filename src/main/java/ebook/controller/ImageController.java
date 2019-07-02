package ebook.controller;

import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


@RestController
@CrossOrigin
@RequestMapping(method = RequestMethod.POST, value = "/image")
public interface ImageController {
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Object getFile(String filename);
    @PostMapping("/upload")
    public Object singleFileUpload(String ISBN, MultipartFile file);
}
