package com.ishang.vm.controller;
import com.ishang.vm.pojo.Resident;
import com.ishang.vm.service.ResidentService;

import com.ishang.vm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ResidentController {
    @Autowired
    ResidentService residentService;
    @CrossOrigin
    @GetMapping("/api/residents")
    public List<Resident> list() throws Exception {
        return residentService.list();
    }
    @CrossOrigin
    @PostMapping("/api/residents")
    public Resident addOrUpdate(@RequestBody Resident resident) throws Exception {
        residentService.addOrUpdate(resident);
        return resident;
    }
    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Resident resident) throws Exception {
        residentService.deleteById(resident.getId());
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Resident> searchResult(@RequestParam("keywords") String keywords){
        // 关键字为空时，查出所有书籍
        if("".equals(keywords)){
            return residentService.list();
        } else {
            return residentService.Search(keywords);
        }
    }

    @CrossOrigin
    @PostMapping("api/photos")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "E:\\Java\\SpringBoot\\HW\\tempimg";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://0.0.0.0:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
