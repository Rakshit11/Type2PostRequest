package com.PostRequest.Handler;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.PostRequest.Model.PostModel;
import com.PostRequest.PostService.PostService;

import reactor.core.publisher.Mono;

@Component
public class PostHandler {

	@Autowired
	private static PostService postService;
	public static Mono<ServerResponse> createPost(ServerRequest request){
		return request.bodyToMono(PostModel.class).flatMap(createpost -> Mono
				.just(postService.createModels(createpost)))
				.flatMap(createpost -> ServerResponse.created(URI.create("/api/v1/transfer-request/order" ))
						.contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(createpost)));
			


	}
	
}
