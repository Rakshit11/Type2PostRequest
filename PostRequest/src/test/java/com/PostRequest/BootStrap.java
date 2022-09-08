package com.PostRequest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.PostRequest.Model.PostModel;
import com.PostRequest.PostRepository.PostRepository;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class BootStrap implements CommandLineRunner{
	
	private final PostRepository postRepository;
	public BootStrap(PostRepository postRepository) {
		this.postRepository=postRepository;
	}
	@Override
	public void run(String... args) throws Exception {
	PostModel Model1 = new PostModel("OH", "AJU455", null);
	postRepository.saveAll(Arrays.asList(Model1)).subscribe(mod -> log.info("Save with name: ", mod.getStateCode()));

	}
	
}

	

