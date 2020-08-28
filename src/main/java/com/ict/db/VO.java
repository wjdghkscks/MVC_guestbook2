package com.ict.db;

public class VO {

	String idx, name, subject, content, file_name, email, pwd, regdate;
	
	public VO() { }

	public VO(String idx, String name, String subject, String content, String file_name, String email, String pwd,
			String regdate) {
		super();
		this.idx = idx;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.file_name = file_name;
		this.email = email;
		this.pwd = pwd;
		this.regdate = regdate;
	}

	public String getIdx() {
		return idx;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getFile_name() {
		return file_name;
	}

	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
}
