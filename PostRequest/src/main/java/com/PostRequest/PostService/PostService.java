package com.PostRequest.PostService;

import com.PostRequest.Model.PostModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	Mono<PostModel> createModels(PostModel Model1);
	Mono<PostModel> getById(String id);
	Flux<PostModel> getAllModel();
}
