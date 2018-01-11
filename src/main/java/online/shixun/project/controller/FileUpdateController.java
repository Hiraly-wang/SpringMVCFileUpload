package online.shixun.project.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("upload")
public class FileUpdateController {

    @GetMapping("to_upload")
    public String to_upload() {
        return "upload";
    }
    @PostMapping("do_upload")
    public String do_upload(MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws Exception {
        //文件夹路径
        String url = httpServletRequest.getSession().getServletContext().getRealPath("/upload");
        if (new File(url).exists()) {
            new File(url).mkdir();
        }
        System.out.println(url);
        //文件名
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."), multipartFile.getOriginalFilename().length());
        System.out.println(fileName);
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(url + File.separator + fileName));
        return "welcome";

    }


}
