package com.PostRequest.PostRepository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.PostRequest.Model.PostModel;

import reactor.core.publisher.Mono;

public interface PostRepository extends ReactiveMongoRepository<PostModel, UUID> {




}
