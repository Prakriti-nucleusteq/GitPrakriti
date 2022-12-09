package com.timesheet.timesheet.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;


/**
 * @author opera_ao6omsd StorageService.
 *
 */
@Service
public class StorageService {

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * @param file file.
     * @return file.
     */
    public String uploadFile(File file) {
        String fileName = System.currentTimeMillis() + "_" + file.getName();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
        file.delete();
        return "File uploaded : " + fileName;
    }


    /**
     * @param fileName fileName.
     * @return inputStream.
     * @throws FileNotFoundException FileNotFoundException.
     */
    public InputStream downloadFile(String fileName) throws FileNotFoundException {
        S3Object s3Object = null;
        try {
            s3Object = s3Client.getObject(bucketName, fileName);
        }
        catch (Exception e) {
            // TODO: handle exception
            throw new FileNotFoundException("File does not exists...");
        }
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
           return inputStream;
        }


    /**
     * @param fileName filename.
     * @return filename.
     */
    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }


}