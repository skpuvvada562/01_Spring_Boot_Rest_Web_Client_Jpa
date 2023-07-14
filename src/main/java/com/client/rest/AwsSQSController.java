package com.client.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.model.EmployeeTblModel;
import com.client.service.EmployeeService;

@RestController
@RequestMapping("/aws/sqs")
public class AwsSQSController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AwsSQSController.class);


	@Autowired
	private QueueMessagingTemplate template;
	
	@Autowired
	private EmployeeService empService;
	
	@Value("${aws.sqs.endpoint.url}")
	private String endPointUrl;
	
	@GetMapping(value="/send/{message}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendMessage(@PathVariable String message){
		
		template.send(endPointUrl,MessageBuilder.withPayload(message).build());
		
		return new ResponseEntity<>("Successfully Delivered",HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/sendEmp", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendEmployeeInfo(){
		List<EmployeeTblModel> empList=empService.fetchAllEmployees();
		template.send(endPointUrl,MessageBuilder.withPayload(empList).build());
		
		return new ResponseEntity<>("Successfully Delivered",HttpStatus.CREATED);
		
	}
	
	@SqsListener("SpringBootSQS")
	public void consumeMessage(String message){
		LOGGER.info("consumed the message from aws::{} ", message);
	}
}
