package com.timesheet.timesheet.s3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
/**
 * @author opera_ao6omsd StorageConfig.
 *
 */
@Configuration
public class StorageConfig {
    /**
     * {@summary for access key. }
     */
    @Value("${aws.access_key}")
    private String accessKey;
    /**
     * {@summary for secret key. }
     */
    @Value("${aws.secret_access_key}")
    private String secretKey;
    /**
     * {@summary for region. }
     */
    @Value("${aws.s3.region}")
    private String region;
    /**
     * {@summary generated bucket. }
     * @return Aws bucket.
     */
    @Bean
    public AmazonS3 getAmazonS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region).build();
    }
}
