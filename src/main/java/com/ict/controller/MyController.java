package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {

	@Inject
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	
	// list
	@RequestMapping(value = "list.do")
	public ModelAndView listCommand() {
		
		ModelAndView mv = new ModelAndView("list");
		
		List<VO> list = dao.getList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	// write
	@RequestMapping(value = "write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	
	// write_ok GET 에러 처리
	@RequestMapping(value = "write_ok.do", method = RequestMethod.GET)
	public ModelAndView writeNoOkCommand() {
		return new ModelAndView("write");
	}
	
	// write_ok
	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public ModelAndView writeOkCommand(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("redirect:list.do");
		
		try {
			
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartRequest mr = new MultipartRequest(
						request, 
						path, 
						500 * 1024 * 1024, 
						"UTF-8",
						new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("name");
			String subject = mr.getParameter("subject");
			String content = mr.getParameter("content");
			String email = mr.getParameter("email");
			String pwd = mr.getParameter("pwd");
			
			// 파일 업로드 유무 구분
			String file_name = "";
			File file = mr.getFile("file_name");
			if (file != null) {
				file_name = mr.getFilesystemName("file_name");
			}
			
			VO vo = new VO("", name, subject, content, file_name, email, pwd, "");

			int result = dao.getWrite(vo);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return mv;
	}
	
	// onelist
	@RequestMapping(value = "onelist.do")
	public ModelAndView listCommand(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("onelist");
		
		String idx = request.getParameter("idx");
		VO vo = dao.getOneList(idx);

		request.getSession().setAttribute("vo", vo);
		
		return mv;
	}
	
	// 파일 다운로드
	@RequestMapping(value = "down.do", method = RequestMethod.GET)
	public void downCommand(HttpServletRequest request, HttpServletResponse response) {

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
			
		try {

			String file_name = request.getParameter("file_name");
			String path = request.getSession().getServletContext().getRealPath("/resources/upload" + file_name);
				
			// browser 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file_name, "UTF-8"));
				
			// I/O
			File file = new File(new String(path.getBytes("UTF-8")));
				
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
				
			int b;
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
				bos.flush();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
	
	// update
	@RequestMapping(value = "update.do")
	public ModelAndView updateCommand() {
		return new ModelAndView("update");
	}
	
	// update_ok GET 에러 처리
	@RequestMapping(value = "update_ok.do", method = RequestMethod.GET)
	public ModelAndView updateNoOkCommand(HttpServletRequest request) {
		String idx = (String)request.getSession().getAttribute("idx");
		return new ModelAndView("onelist?idx=" + idx);
	}
	
	// update_ok
	@RequestMapping(value = "update_ok.do", method = RequestMethod.POST)
	public ModelAndView updateOkCommand(HttpServletRequest request) {
		
		try {
			
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartRequest mr = new MultipartRequest(
						request, 
						path, 
						500 * 1024 * 1024, 
						"UTF-8",
						new DefaultFileRenamePolicy());
			
			String idx = mr.getParameter("idx");
			String name = mr.getParameter("name");
			String subject = mr.getParameter("subject");
			String content = mr.getParameter("content");
			String email = mr.getParameter("email");
			String pwd = mr.getParameter("pwd");
			
			// 파일 업로드 유무 구분
			String file_name = "";
			File file = mr.getFile("file_name");
			
			if (file != null) {
				file_name = mr.getFilesystemName("file_name");
			} else {
				file_name = mr.getParameter("f_name");
			}
			
			VO vo = new VO(idx, name, subject, content, file_name, email, pwd, "");

			int result = dao.getUpdate(vo);
			
			ModelAndView mv = new ModelAndView("redirect:onelist.do?idx=" + idx);
			return mv;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// delete
	@RequestMapping(value = "delete.do")
	public ModelAndView deleteCommand() {
		return new ModelAndView("delete");
	}
	
	// delete_ok GET 에러 처리
	@RequestMapping(value = "delete_ok.do", method = RequestMethod.GET)
	public ModelAndView deleteNoOkCommand(HttpServletRequest request) {
		String idx = (String)request.getSession().getAttribute("idx");
		return new ModelAndView("onelist?idx=" + idx);
	}
	
	// delete_ok
	@RequestMapping(value = "delete_ok.do", method = RequestMethod.POST)
	public ModelAndView deleteOkCommand(HttpServletRequest request) {
		
		VO vo = (VO) request.getSession().getAttribute("vo");
		
		int result = dao.getDelete(vo.getIdx());
		
		return new ModelAndView("redirect:list.do");
	}
	
	
	
	
}
