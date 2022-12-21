package com.example.controller;

import com.example.service.FileUploadDownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class FileUploadController {

    private final FileUploadDownloadService fileUploadDownloadService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFiles(@ModelAttribute List<MultipartFile> files) {
        System.out.println(files);
        fileUploadDownloadService.uploadFiles(files);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName) {
        byte[] fileData = fileUploadDownloadService.downloadFile(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/png"));
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileData);
    }

}
