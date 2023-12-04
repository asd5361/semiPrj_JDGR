package com.semi.jdgr.blog.service;

import java.io.File;
import java.sql.Connection;
import java.util.List;
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
		//if(대표블로그면..url ) {} else {대표블로그 아니면}
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
	public int createBlog(BlogVo blogVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// 비즈니스 로직
        Pattern blogTitleRegex = Pattern.compile("^[가-힣a-zA-Z0-9\\s]{1,25}$"); // 한글, 영문, 숫자, 띄어쓰기 혼용가능 (25자 이내)
        Pattern blogUrlRegex = Pattern.compile("^[a-z0-9]{4,32}$"); // 최소 4자 최대 32자 영문소문자, 숫자로 입력
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
        if (!blogImgMatcher.matches()) {
            throw new Exception("올바르지 않은 이미지 파일 확장자입니다. 파일 확장자: " + fileExtension);
        }

        // 블로그 타이틀 정규표현식과 일치하는지 확인
        if (!blogTitleMatcher.matches()) {
            throw new Exception("블로그 타이틀이 적절하지 않습니다.");
        }

        // 블로그 URL 정규표현식과 일치하는지 확인
        if (!blogUrlMatcher.matches()) {
            throw new Exception("블로그 URL이 적절하지 않습니다.");
        }
        
        // 블로그 개수가 3개 이상이면 생성불가(해야됨)
        
        
		
		// dao
		BlogDao dao = new BlogDao();
		int result = dao.createBlog(conn, blogVo);
		// dao에서 업데이트된 blogVo가져와야함 세션에 저장용도
		
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
}
