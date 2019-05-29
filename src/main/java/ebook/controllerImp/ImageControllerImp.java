package ebook.controllerImp;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import ebook.controller.ImageController;
import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import ebook.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

public class ImageControllerImp implements ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Object getFile(@PathVariable String filename) {
        return imageService.getFile(filename);
    }

    @PostMapping("/upload")
    public Object singleFileUpload(@RequestParam String ISBN, MultipartFile file) {
        return imageService.singleFileUpload(ISBN, file);
    }
}
