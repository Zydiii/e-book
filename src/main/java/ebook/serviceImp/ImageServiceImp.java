package ebook.serviceImp;

import ebook.controller.ImageController;
import ebook.dao.BooksMapper;
import ebook.entity.Books;
import ebook.entity.BooksExample;
import ebook.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


@Service
public class ImageServiceImp implements ImageService {


//    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    private static final String ROOT = "files/";

    private final ResourceLoader resourceLoader;

    @Autowired
    BooksMapper booksMapper;

    @Autowired
    public ImageServiceImp(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    public String provideUploadInfo(Model model) throws IOException {
//
//        model.addAttribute("files", Files.walk(Paths.get(ROOT))
//                .filter(path -> !path.equals(Paths.get(ROOT)))
//                .map(path -> Paths.get(ROOT).relativize(path))
//                .map(path -> linkTo(methodOn(ImageController.class).getFile(path.toString())).withRel(path.toString()))
//                .collect(Collectors.toList()));
//
//        return "uploadForm";
//    }

    public Object getFile(@PathVariable String filename) {
        try {
//            return ImageIO.read(new FileInputStream(new File("./files/"+filename)));
            return resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString());
        } catch (Exception e) {
//            return null;
            return resourceLoader.getResource("file:" + Paths.get(ROOT, "notfound.png").toString());
        }
    }

    public Object singleFileUpload(@RequestParam String ISBN, MultipartFile file) {
//        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));

        if (Objects.isNull(file) || file.isEmpty()) {
//            logger.error("文件为空");
            return "文件为空，请重新上传";
        }

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get("frontend\\static\\img\\goodsList\\" + "goodsList-item" + ISBN + file.getOriginalFilename());

            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(ROOT));
            }

            BooksExample booksExample = new BooksExample();
            BooksExample.Criteria criteria = booksExample.createCriteria();
            criteria.andIsbnEqualTo(ISBN);
            List<Books> o = booksMapper.selectByExample(booksExample);
            Path path1 = Paths.get("static\\img\\goodsList\\" + "goodsList-item" + ISBN + file.getOriginalFilename());
            o.get(0).setCover(path1.toString());
            booksMapper.updateByExampleSelective(o.get(0), booksExample);

            //文件写入指定路径
            Files.write(path, bytes);

//            logger.debug("文件写入成功...");

            return "文件上传成功";

        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
}
