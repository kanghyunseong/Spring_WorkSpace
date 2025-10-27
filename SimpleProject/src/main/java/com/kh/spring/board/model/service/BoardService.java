package com.kh.spring.board.model.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.BoardDTO;
import com.kh.spring.board.model.dto.ReplyDTO;

public interface BoardService {
	
	// 게시글 목록 조회 + 페이징처리
	// 총 게시글 수 조회
	//int selectListCount();
	// 목록 조회
	Map<String,Object> findAll(Long boardNo);
	
	// 게시글 작성
	int save(BoardDTO board,MultipartFile upfile,HttpSession session);
	
	// 게시글 상세보기(조회수 증가)
	BoardDTO findByBoardNo(Long boardNo);
	
	// 게시글 삭제하기
	int deleteByBoardNo(Long boardNo);
	
	// 게시글 수정하기
	int update(BoardDTO board);
	
	int insertReply(ReplyDTO replyDTO,HttpSession session);
	
	// ---------------------------------
	
}
