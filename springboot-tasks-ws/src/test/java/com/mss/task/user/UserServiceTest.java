package com.mss.task.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.mss.tasks.user.User;
import com.mss.tasks.user.UserService;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	@Mock
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@BeforeEach
	public void insertData()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(1);
		Map<String, Object> insertUserData=userService.insertUser(dataInsert());
		assertEquals("Successfully Inserted Data", insertUserData.get("Data"));
	}
	public User dataInsert() {
		// TODO Auto-generated method stub
		User u= new User();
		u.setName("ABC");
		u.setEmail("ABC");
		u.setPassword("ABC");
		u.setAge(12);
		return u;
		
		
	}
}
