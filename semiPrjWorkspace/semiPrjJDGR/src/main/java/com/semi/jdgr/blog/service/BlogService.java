package com.semi.jdgr.blog.service;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.semi.jdgr.blog.dao.BlogDao;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.blog.vo.GroupVo;
import com.semi.jdgr.user.member.vo.MemberVo;
import com.semi.jdgr.util.JDBCTemplate;

public class BlogService {

	// url에 맞는 블로그 정보 가져오기
	public BlogVo getUserblog(MemberVo loginMemberVo, String getBlogUrl) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		BlogVo blogUrlVo = dao.getUserBlog(conn, loginMemberVo, getBlogUrl);
		
		// close
		JDBCTemplate.close(conn);
		
		return blogUrlVo;
	}
	
	// 대표블로그 정보 가져오기
	public BlogVo getUserReqblog(MemberVo memberVo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		BlogVo blogVo = dao.getUserReqBlog(conn, memberVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return blogVo;
	}
	
	// 카테고리 그룹정보 가져오기
	public List<GroupVo> getGroupList(BlogVo blogVo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		List<GroupVo> groupVoList = dao.getGroupList(conn, blogVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return groupVoList;
	}

	// 블로그 리스트 가져오기
	public List<BlogVo> getBlogList(MemberVo memberVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		List<BlogVo> blogVoList = dao.getBlogList(conn, memberVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return blogVoList;
	}

	// 대표 블로그 수정하기
	public int editBlogRep(BlogVo blogVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		int result = dao.editBlogRep(conn, blogVo);
		
		// tx
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 블로그 만들기
	public Map<String, Object> createBlog(BlogVo blogVo, MemberVo loginMemberVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		BlogDao dao = new BlogDao();
		List<BlogVo> blogAllList = dao.getBlogAllList(conn); // 모든 블로그 정보 가져오기

        // 블로그 url이 다른사람것과 겹치는지확인
        for(BlogVo listVo : blogAllList) {
        	if(listVo.getBlogUrl().equals(blogVo.getBlogUrl())) {
        		throw new Exception("이미 사용중인 URL입니다.");
        	}
        }
		int result = dao.createBlog(conn, blogVo);
		List<BlogVo> userBlogList = dao.getBlogList(conn, loginMemberVo); // 해당유저의 블로그 리스트 가져오기
		
		// 비즈니스 로직
        Pattern blogTitleRegex = Pattern.compile("^[가-힣a-zA-Z0-9\\s]{0,25}$"); // 한글, 영문, 숫자, 띄어쓰기 혼용가능 (25자 이내)
        Pattern blogUrlRegex = Pattern.compile("^[a-zA-Z0-9]{4,32}$"); // 최소 4자 최대 32자 영문, 숫자로 입력
        Pattern blogImgRegex = Pattern.compile("^(jpg|jpeg|png|gif|svg)$"); // 이미지파일만 받기
        
        // 이미지 경로
        String blogImgPath = blogVo.getBlogImg();
        String sep = File.separator;
        // 파일 이름 추출
        int lastSeparatorIndex = blogImgPath.lastIndexOf(sep);
        String fileName = lastSeparatorIndex >= 0 ? blogImgPath.substring(lastSeparatorIndex + 1) : blogImgPath;
        // 확장자 추출
        int dotIndex = fileName.lastIndexOf('.');
        String fileExtension = null;
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            fileExtension = fileName.substring(dotIndex + 1);
        }
        // Matcher 객체 생성
        Matcher blogTitleMatcher = blogTitleRegex.matcher(blogVo.getBlogTitle());
        Matcher blogUrlMatcher = blogUrlRegex.matcher(blogVo.getBlogUrl());
        Matcher blogImgMatcher = blogImgRegex.matcher(fileExtension);
        // 이미지 파일 확장자 정규표현식과 일치하는지 확인
        if(!blogImgMatcher.matches()) {
            throw new Exception("올바르지 않은 이미지 파일 확장자입니다. 파일 확장자: " + fileExtension);
        }

        // 블로그 타이틀 정규표현식과 일치하는지 확인
        if(!blogTitleMatcher.matches()) {
            throw new Exception("블로그 타이틀이 적절하지 않습니다.");
        }
        // 블로그 URL 정규표현식과 일치하는지 확인
        if(!blogUrlMatcher.matches()) {
            throw new Exception("블로그 URL이 적절하지 않습니다.");
        }
        
        // 블로그 개수가 3개 이상이면 생성불가(해야됨)
        if(userBlogList.size() > 3) {
        	throw new Exception("블로그는 3개까지만 생성 가능합니다.");
        }
        // 블로그명이 없으면 닉네임님의 블로그 고정
        if(blogVo.getBlogTitle() == null) {
        	blogVo.setBlogTitle(loginMemberVo.getMemNick() +  "님의 블로그");
        }
        // 블로그 url이 값이 없는지 확인
        if(blogVo.getBlogUrl() == null) {
        	throw new Exception("블로그 URL을 입력해주세요.");
        }
        
        // 블로그 세션 업데이트를 위한 BlogList와 result
        Map<String, Object> blogInfo = new HashMap<String, Object>();
        blogInfo.put("result", result);
        blogInfo.put("userBlogList", userBlogList);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return blogInfo;
	}

	// 블로그 정보 수정
	public BlogVo editInfo(BlogVo blogVo) {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		int result = dao.editInfo(blogVo); // 수정 업데이트 결과값
		
		//dao.
		
		// 비즈니스 로직
        Pattern blogTitleRegex = Pattern.compile("^[가-힣a-zA-Z0-9\\s]{0,25}$"); // 한글, 영문, 숫자, 띄어쓰기 혼용가능 (25자 이내)
        Pattern blogImgRegex = Pattern.compile("^(jpg|jpeg|png|gif|svg)$"); // 이미지파일만 받기
        
        // 이미지 경로
        String blogImgPath = blogVo.getBlogImg();
        String sep = File.separator;
        // 파일 이름 추출
        int lastSeparatorIndex = blogImgPath.lastIndexOf(sep);
        String fileName = lastSeparatorIndex >= 0 ? blogImgPath.substring(lastSeparatorIndex + 1) : blogImgPath;
        // 확장자 추출
        int dotIndex = fileName.lastIndexOf('.');
        String fileExtension = null;
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            fileExtension = fileName.substring(dotIndex + 1);
        }
        // Matcher 객체 생성
        Matcher blogTitleMatcher = blogTitleRegex.matcher(blogVo.getBlogTitle());
        Matcher blogUrlMatcher = blogUrlRegex.matcher(blogVo.getBlogUrl());
        Matcher blogImgMatcher = blogImgRegex.matcher(fileExtension);
        // 이미지 파일 확장자 정규표현식과 일치하는지 확인
        if(!blogImgMatcher.matches()) {
            throw new Exception("올바르지 않은 이미지 파일 확장자입니다. 파일 확장자: " + fileExtension);
        }
        // 블로그 타이틀 정규표현식과 일치하는지 확인
        if(!blogTitleMatcher.matches()) {
            throw new Exception("블로그 타이틀이 적절하지 않습니다.");
        }
		
		return null;
	}
	
}
