package com.ssafy.profolio.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface UploadService {
    void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String filename);
    String getFileUrl(String fileName);
    String uploadS3(MultipartFile file);
}
