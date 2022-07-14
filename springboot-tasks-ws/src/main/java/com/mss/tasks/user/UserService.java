package com.mss.tasks.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String, Object> insertUser(User user) {
		String name = user.getName();
		String email = user.getEmail();
		String password = user.getPassword();
		int age = user.getAge();
		Map<String, Object> response = new HashMap();
		try {
			String insertQuery = "INSERT INTO user (name,email,password,age) VALUES(:Name,:Email,:Password,:Age)";
			MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("Name", name)
					.addValue("Email", email).addValue("Password", password).addValue("Age", age);
			int result = namedParameterJdbcTemplate.update(insertQuery, sqlParameterSource);
			if (result == 1) {
				response.put("Data", "Successfully Inserted Data");
			} else {
				response.put("Data", "Not Inserted");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}

	// ============================================================
	public Map<String, Object> updateUser(User user) {
		Map<String, Object> response = new HashMap();
		String name = user.getName();
		String email = user.getEmail();
		try {
			String updateQuery = "UPDATE user SET email=:email WHERE name=:name";
			MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("email", email)
					.addValue("name", name);
			int result = namedParameterJdbcTemplate.update(updateQuery, sqlParameterSource);
			if (result == 1) {
				response.put("Data", "Successfully Updated");
			} else {
				response.put("Data", "Not Updated");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}

	// =============================================================
	public Map<String, Object> deleteUser(User user) {
		String name = user.getName();
		Map<String, Object> response = new HashMap();
		try {
			String deleteQuery = "DELETE from USER where name=:name";
			MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("name", name);
			int result = namedParameterJdbcTemplate.update(deleteQuery, sqlParameterSource);
			if (result == 1) {
				response.put("Data", "Successfully Deleted");
			} else {
				response.put("Data", "Not Deleted");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}

	// =================================================================
	public List<HashMap<String, Object>> GetUserDetails(User user) {
		List<HashMap<String, Object>> data = new ArrayList();
		List<Map<String, Object>> datalist = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> mapdata = null;
		try {
			String selectQuery = "SELECT * FROM user";
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			datalist = namedParameterJdbcTemplate.queryForList(selectQuery, parameter);
			for (Map<String, Object> map : datalist) {
				mapdata = new HashMap<String, Object>();
				mapdata.put("Id", map.get("id"));
				mapdata.put("Name", map.get("name"));
				mapdata.put("Email", map.get("email"));
				mapdata.put("Password", map.get("password"));
				mapdata.put("Age", map.get("age"));
				mapdata.put("Date", map.get("date"));
				data.add(mapdata);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

}
