package com.actionict.inventory.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final String dirPath = "inventory/src/main/resources/pics";
    private final String absDirPath = new FileSystemResource(dirPath).getFile().getAbsolutePath();
    private final File dir = new File(dirPath);

    public List<String> listFiles() {
        List<String> fileNames = new ArrayList<>();
        fileNames.add(absDirPath);
        Collection<File> files = FileUtils.listFiles(dir, new String[]{"jpg"}, false);
        for (File file : files) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }

    public Map<String, String> uploadFile(MultipartFile mpFile) {
        //https://howtodoinjava.com/spring-boot/spring-boot-file-upload-rest-api/
        Map<String, String> map = new HashMap<>();
        map.put("fileName", mpFile.getOriginalFilename());
        map.put("fileSize", String.valueOf(mpFile.getSize()));
        map.put("fileContentType", mpFile.getContentType());
        File file = new File(dirPath+"/file.jpg");
        try {
            file.createNewFile();
            file.setWritable(true);
            System.out.println("File in "+file.getAbsolutePath());
            mpFile.transferTo(file);
        } catch (IOException e) { throw new RuntimeException(e); }
        //FileUtils.moveFileToDirectory(mpFile, new File(dirPath), false);
        map.put("message", "File successfully uploaded");
        return map;
    }
}