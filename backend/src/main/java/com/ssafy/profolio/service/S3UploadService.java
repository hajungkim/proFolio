package com.ssafy.profolio.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ssafy.profolio.domain.File.S3Component;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3UploadService implements UploadService{
    private final AmazonS3 amazonS3;
    private final S3Component s3Component;

    @Override
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String filename) {
        amazonS3.putObject(new PutObjectRequest(s3Component.getBucket(), filename, inputStream, objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
    }

    @Override
    public String getFileUrl(String fileName) {
        return amazonS3.getUrl(s3Component.getBucket(), fileName).toString();
    }

    public String uploadS3(MultipartFile file){
        String fileName = createFileName(file.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());
        try(InputStream inputStream = file.getInputStream()){
            uploadFile(inputStream, objectMetadata, fileName);
        }catch (IOException e){
            throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생했습니다 (%s)", file.getOriginalFilename()));
        }
        return getFileUrl(fileName);
    }

    private String createFileName(String originalFileName){
        return UUID.randomUUID().toString().concat(originalFileName);
    }
}
