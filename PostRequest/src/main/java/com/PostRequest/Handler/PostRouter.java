package com.PostRequest.Handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.PostRequest.Model.PostModel;
import com.PostRequest.PostService.PostService;

@Configuration
@EnableWebFlux
public class PostRouter {

	private static String BASE_URL = "/api/v1/transfer-request/order";
	private final PostService postService;
	public PostRouter(PostService postService) {
		this.postService=postService;
	}
	@Bean
	public RouterFunction<ServerResponse> createPost(){
		return RouterFunctions.route()
				.POST(BASE_URL, request -> request.bodyToMono(PostModel.class)
						.flatMap(postService::createModels)
						.flatMap(postModel -> ServerResponse.status(HttpStatus.CREATED) 
								.body(postModel, PostModel.class))).build();
	}
}
