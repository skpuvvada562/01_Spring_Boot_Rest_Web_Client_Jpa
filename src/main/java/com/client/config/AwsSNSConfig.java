package com.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AwsSNSConfig {
	
	@Value("${cloud.aws.credentials.access-key}")
	private String  awsAccessKey;
	
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretAccessKey;

	@Primary
	@Bean
	public AmazonSNSClient snsClient(){
		return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
		.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretAccessKey)))
		.build();
	}
	
}
