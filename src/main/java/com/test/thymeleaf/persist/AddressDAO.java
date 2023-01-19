package com.test.thymeleaf.persist;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {

	@Autowired private SqlSessionTemplate template;

	public int num() {

		return template.selectOne("test.num");
	}

	public String txt() {

		return template.selectOne("test.txt");
	}

	public LocalDateTime now() {

		return template.selectOne("test.now");
	}

	public AddressDTO get() {

		return template.selectOne("test.get");
	}

	public HashMap<String, Integer> getMap() {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("kor", 100);
		map.put("eng", 90);
		map.put("math", 80);
		
		return map;
	}

	public List<String> getNames() {
		
		
		return template.selectList("test.getNames");
	}

	public List<AddressDTO> list() {

		return template.selectList("test.list");
	}
	
}






