package com.actionict.inventory.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureService {

    public List<String> listFiles() {
        String dirPath = "inventory/src/main/resources/pics";
        List<String> fileNames = new ArrayList<>();
        fileNames.add(new FileSystemResource(dirPath).getFile().getAbsolutePath());
        Collection<File> files = FileUtils.listFiles(new File(dirPath), new String[]{"jpg"}, false);
        for (File file : files) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }
}