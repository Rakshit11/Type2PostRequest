package com.PostRequest.PostService;

import org.springframework.stereotype.Service;

import com.PostRequest.Model.PostModel;
import com.PostRequest.PostRepository.PostRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository ;
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository=postRepository;
	}
	private PostModel formatModel(PostModel postModel) {
		postModel.setStateCode(postModel.getStateCode());
		postModel.setVin(postModel.getVin());
		postModel.setEnum(postModel.getEnum());
		return postModel;
	}
	@Override
	public Mono<PostModel> createModels(PostModel Model1) {
		if(Model1.getId()!=null) {
			return Mono.error((new IllegalArgumentException("Id of new must be null")));
		}
		return postRepository.save(Model1);
	}

	@Override
	public Mono<PostModel> getById(String id) {
		return postRepository.findById(id).map(this::formatModel);
	}

	@Override
	public Flux<PostModel> getAllModel() {
		return postRepository.findAll().map(this::formatModel);
	}

}
