package com.example.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.example.config.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileUploadDownloadServiceImpl implements FileUploadDownloadService {

    private final AmazonS3 amazonS3;
    private final ApplicationProperties applicationProperties;

    @Override
    public void uploadFiles(List<MultipartFile> files) {
        if (files != null) {
            files.forEach(multipartFile -> {
                File file = convertMultiPartFileToFile(multipartFile);
                String uniqueFileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
                uploadFileToS3bucket(uniqueFileName, file, applicationProperties.getAwsServices().getBucketName());
                file.delete();
            });
        }
    }

    @Override
    public byte[] downloadFile(String fileName)  {
        S3Object s3Object= downloadFileFromS3bucket(fileName, applicationProperties.getAwsServices().getBucketName());
        try {
            return IOUtils.toByteArray(s3Object.getObjectContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void uploadFileToS3bucket(String fileName, File file, String bucketName) {
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file));
    }

    private S3Object downloadFileFromS3bucket(String fileName, String bucketName) {
        S3Object object = amazonS3.getObject(bucketName, fileName);
        return object;
    }

    private void deleteFileFromS3bucket(String fileName, String bucketName) {
        amazonS3.deleteObject(bucketName, fileName);
    }


    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}
