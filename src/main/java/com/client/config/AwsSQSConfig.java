package com.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
public class AwsSQSConfig {

	@Value("${cloud.aws.region.static}")
	private String region;
	
	@Value("${cloud.aws.credentials.access-key}")
	private String  awsAccessKey;
	
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretAccessKey;
	
	@Bean
	public QueueMessagingTemplate messagingTemplate(){
		return new QueueMessagingTemplate(amazonSqs());
	}

	@Bean
	public AmazonSQSAsync amazonSqs() {

		return AmazonSQSAsyncClientBuilder.standard().withRegion(region)
				.withCredentials(
						new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretAccessKey)))
				.build();
	}
}
