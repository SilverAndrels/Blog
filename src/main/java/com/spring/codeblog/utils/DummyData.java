package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;

@Component
public class DummyData {

	@Autowired
	CodeblogRepository codeblogRepository;

	//@PostConstruct
	public void savePosts() {

		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("André Silveira");
		post1.setData(LocalDate.now());
		post1.setTitulo("Primeiro Post");
		post1.setTexto("Este é apenas o primeiro post, utilizado para teste!");

		postList.add(post1);

		for (Post post : postList) {
			Post postSaved = codeblogRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}
}
