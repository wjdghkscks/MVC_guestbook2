package com.ict.db;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class DAO {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 사용할 메소드 생성
	
	public List<VO> getList() {
		List<VO> list = null;
		list = sqlSessionTemplate.selectList("list");
		return list;
	}
	
	public int getWrite(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.insert("write", vo);
		return result;
	}
	
	public VO getOneList(String idx) {
		VO vo = new VO();
		vo = sqlSessionTemplate.selectOne("onelist", idx);		
		return vo;
	}
	
	public int getUpdate(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.update("update", vo);
		return result;
	}
	
	public int getDelete(String idx) {
		int result = 0;
		result = sqlSessionTemplate.delete("delete", idx);
		return result;
	}
	
}
