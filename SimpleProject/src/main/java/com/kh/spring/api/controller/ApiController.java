package com.kh.spring.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring.api.model.dto.Comment;
import com.kh.spring.api.model.service.ApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="api" , produces="application/json; charset=UTF-8")
@CrossOrigin("*")
public class ApiController {

	private final ApiService apiService;
	
	@GetMapping("beef")
	public String getBeef() {
		
		/*
		String response = apiService.requestBeef();
		
		AjaxResponse ar = AjaxResponse.builder()
									  .code("200")
									  .message("호호호")
									  .data(response)
									  .build();
		return ar;
		*/
		
		return apiService.requestBeef();
		
	}
	
	@GetMapping("blog")
	public String getBlog(@RequestParam(name="query") String query) {
		return apiService.requestBlog(query);
	}
	
	@GetMapping("busan")
	public String getBusan(@RequestParam(name="pageNo") int pageNo) {
		return apiService.requestBusan(pageNo);
	}
	
	@GetMapping("busan/detail/{num}")
	public String getBusanDetail(@PathVariable(name="num") int num) {
		return apiService.requestBusanDetail(num);
	}
	
	@PostMapping("comments")
	public ResponseEntity<Integer> saveComment(@RequestBody Comment comment) {
		log.info("코멘트 넘어옴 : {}", comment );
		int result = apiService.saveComment(comment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("comments/{id}")
	public ResponseEntity<List<Comment>> selectAll(@PathVariable(value="id") Long seq) {
		List<Comment> comments = apiService.selectAll(seq);
		return ResponseEntity.ok(comments);
	}
}
