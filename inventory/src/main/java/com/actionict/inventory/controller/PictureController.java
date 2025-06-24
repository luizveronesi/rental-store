package com.actionict.inventory.controller;

import com.actionict.inventory.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @GetMapping("/files")
    public List<String> listFiles() { return pictureService.listFiles(); }
}