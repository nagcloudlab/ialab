package com.example.service;

import com.amazonaws.services.s3.model.S3Object;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileUploadDownloadService {
    void uploadFiles(List<MultipartFile> multipartFiles);
    byte[] downloadFile(String fileName);
}
