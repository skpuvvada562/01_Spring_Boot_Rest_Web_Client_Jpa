package com.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
@RequestMapping("/aws/sns")
public class AwsSNSController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(AwsSNSController.class);

	@Value("${topic.arn}")
	private String  topicArn;
	
	@Autowired
	private AmazonSNSClient client;
	
	@GetMapping("/addEmailSubscription/{email}")
	public ResponseEntity<String> addEmailSubscription(@PathVariable String email) {
		SubscribeRequest request = new SubscribeRequest(topicArn, "email", email);
		client.subscribe(request);
		return new ResponseEntity<String>(
				"Subscription Request is pending. To confirm the subscription check your email" + email, HttpStatus.OK);
	}
	
	
	@GetMapping("/sendEmailNotification")
	public ResponseEntity<String> publishEmailMessageToTopic(){
		PublishRequest publishRequest=new PublishRequest(topicArn, buildEmailBody(), "Notification:Network is down");
		PublishResult result=client.publish(publishRequest);
		LOGGER.info("==message id=={}",result.getMessageId());
		LOGGER.info("==result=={}",result);
		return new ResponseEntity<String>("Notification Sent Successfully...", HttpStatus.OK);
	}
	
	
	private String buildEmailBody(){
		return "Dear User \n"
				+ "Network is down, IT team is investigating, will update you in next 1 hour \n"
				+ "Thanks for your understanding....";
	}
}
