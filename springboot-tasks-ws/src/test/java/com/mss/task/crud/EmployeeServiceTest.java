package com.mss.task.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ietf.jgss.Oid;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import com.mss.task.crud.Employee;
import com.mss.task.crud.EmployeeService;

@SpringBootTest
@ContextConfiguration
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService empService;
	@Mock
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Test
	public void insertEmployee()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenReturn(1);
		Map<String, Object> insertData = empService.insertEmployee(addInsertData());	
		assertEquals("Rows Inserted Successfully",insertData.get("message"));
	}
	@Test
	public void insertEmployeeCase()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenReturn(0);
		Map<String, Object> insertData = empService.insertEmployee(addInsertData());
		assertEquals("Rows Not Inserted",insertData.get("message"));
		//assertEquals("Successfully added the activites.", activitiesData.get("message"));
	}
	@Test
	public void insertEmployeeException()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenThrow(NullPointerException.class);
		Map<String, Object> insertData = empService.insertEmployee(addInsertData());
       		assertTrue(insertData.isEmpty());
	}
	private Employee addInsertData() {
		Employee employee= new Employee();
		employee.setId(1);
		employee.setAge(21); 
		employee.setName("Ajay");
		return employee;
	}
	@Test
	public void updateEmployee()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyInt())).thenReturn(1);
//		Employee employee= new Employee();
//		employee.setId(1);
//		employee.setName("Ajay");
		//Map<String, Object> updateData = empService.updateEmployee(employee.getId(),employee.getName());	
		Map<String, Object> updateData = empService.updateEmployee(1,"ABC");	
		assertEquals("Updated Successfully",updateData.get("Data"));
	}
	@Test
	public void updateEmployeeCase()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyInt())).thenReturn(0);
		Employee employee= new Employee();
		employee.setId(1);
		employee.setName("Ajay");
		Map<String, Object> updateData = empService.updateEmployee(employee.getId(),employee.getName());	
		assertEquals("Not Updated",updateData.get("Data"));
	}
	@Test
	public void updateEmployeeException()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenThrow(NullPointerException.class);
		Map<String, Object> updateData = empService.updateEmployee(1,"ABCD");
       		assertTrue(updateData.isEmpty()); 		
	}
	@Test
	public void deleteEmployeeData()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
		Map<String , Object> deleteData = empService.deleteEmployee(1);
		assertEquals("Deleted Successfully",deleteData.get("message") );
	}
	@Test
	public void deleteEmployeeDataCase()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);
		Map<String , Object> deleteData = empService.deleteEmployee(1);
		assertEquals("Not Deleted",deleteData.get("message"));
	}
	@Test
	public void deleteEmployeeException()
	{
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenThrow(NullPointerException.class);
		Map<String, Object> deleteData = empService.deleteEmployee(1);
       	assertTrue(deleteData.isEmpty());
	}
	@Test
	public void getData()
   {	
	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(getDataCase());
	List<Map<String, Object>> getDataEmployee =empService.getEmployeeDetails(1, 24);
	}
	@Test
	public void getDataException()
   {	
	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenThrow(NullPointerException.class);
	List<Map<String, Object>> getDataEmployee =empService.getEmployeeDetails(1, 24);
	assertTrue(getDataEmployee.isEmpty());
	}
	public List<Map<String,Object>> getDataCase()
	{
		List<Map<String,Object>> getDataCase=new ArrayList<>();
		Map<String, Object> mapData= new HashMap<>();
		mapData.put("id", 1);
		mapData.put("name", "ABC");
		mapData.put("age", 24);
		getDataCase.add(mapData);
		return getDataCase;
	}
	public void getAllData()
	{
		Mockito.when(jdbcTemplate.queryForList(Mockito.anyString())).thenReturn(getDataCase1());
		List<HashMap<String, Object>> getAllDataTest=empService.getEmployeeDetails1(addInsertData());
		//assertEquals(getAllDataTest, );
	}
	public List<Map<String,Object>> getDataCase1()
	{
		List<Map<String,Object>> getDataCase2=new ArrayList<>();
		Map<String, Object> mapData1= new HashMap<>();
		mapData1.put("id", 1);
		mapData1.put("name", "ABC");
		mapData1.put("age", 24);
		getDataCase2.add(mapData1);
		return getDataCase2;
	}
}

