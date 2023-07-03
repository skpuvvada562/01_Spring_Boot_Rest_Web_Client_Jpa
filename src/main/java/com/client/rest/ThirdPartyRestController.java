package com.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.client.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/json/v1/api")
public class ThirdPartyRestController {
	
	@Autowired
	private WebClient client;
	//http://localhost:9293/json/v1/api/
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flux<Post>> getPosts(){
		
		Flux<Post> data= client.get()
				 			   .uri("/posts/")
				 			   .retrieve()
				 			   .bodyToFlux(Post.class);
		/*Disposable data1=data.collect(Collectors.toList())
				  .subscribe();
				 					  
		 System.out.println(data1);*/
		
		 
		 return new ResponseEntity<>(data,HttpStatus.OK);
	}
	//http://localhost:9293/json/v1/api/posts/1
	@GetMapping(value="/posts/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Post>> getPost(@PathVariable int id) {

		Mono<Post> postMono = client.get()
				 					.uri("/posts/" + id)
				 					.retrieve()
				 					.bodyToMono(Post.class);
		/*Disposable disp=postMono.subscribe();*/

		return new ResponseEntity<>(postMono, HttpStatus.OK);
	}
	
	//http://localhost:9293/json/v1/api/create
	@PostMapping(value="/create", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Post>> creatPost(@RequestBody Post post){
		Mono<Post> monoPost=client.post()
								  .uri("/posts")
								  .body(BodyInserters.fromValue(post))
								  .retrieve()
							      .bodyToMono(Post.class);
		
		return new ResponseEntity<>(monoPost,HttpStatus.CREATED);
	}
	
	//http://localhost:9293/json/v1/api/put?id=1
	@PutMapping(value="/put", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Post>> putPost(@RequestParam("id") int id,@RequestBody Post post){
		Mono<Post> monoPost=client.put()
			.uri("/posts/"+id)
			.body(BodyInserters.fromValue(post))
			.retrieve()
			.bodyToMono(Post.class);
		
		return new ResponseEntity<>(monoPost,HttpStatus.CREATED);
	}
	//http://localhost:9293/json/v1/api/delete/3
	@DeleteMapping(value="/delete/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Post>> deletePost(@PathVariable int id){
		
		Mono<Post> monoPost=client.delete()
			  .uri("/posts/"+id)
			  .retrieve()
			  .bodyToMono(Post.class);
		
		return new ResponseEntity<>(monoPost,HttpStatus.CREATED);
	}
}
