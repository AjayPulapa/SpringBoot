package com.mss.task.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	@Autowired
	JdbcTemplate jdbctemplate;

	// Insert the Data
	public Map<String, Object> insertEmployee(Employee employee) {
		Map<String, Object> response = new HashMap<String, Object>();
		int id = employee.getId();
		String name = employee.getName();
		int age = employee.getAge();
		try {
			String insertQuery = "insert into employee1 values(?,?,?)";
			int result = jdbctemplate.update(insertQuery, id, name, age);
			if (result > 0) { 
				response.put("message", "Rows Inserted Successfully"); 
			} else {
				response.put("message", "Rows Not Inserted");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	// Update the Data
	public Map<String, Object> updateEmployee(int id, String name) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			String updateQuery = "update employee1 set name=? where id=?";
			int result = jdbctemplate.update(updateQuery, name, id);
			if (result > 0) {
				response.put("Data", "Updated Successfully");
			} else {
				response.put("Data", "Not Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	// Delete the Data
	public Map<String, Object> deleteEmployee(int id) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			String deleteQuery = "delete from employee1 where id=?";
			int result = jdbctemplate.update(deleteQuery, id);
			if (result > 0) {
				response.put("message", "Deleted Successfully");
			} else {
				response.put("message", "Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	// Getting the Table Data

	public List<Map<String, Object>> getEmployeeDetails(int id, int age) {
		List<Map<String, Object>> response = new ArrayList<Map<String, Object>>();
		String selectQuery=null;
		try {
	            selectQuery = "select * from employee1 where id=?";
				String ageQuery = " AND age= ?";
				selectQuery = selectQuery + ageQuery;
	             response = jdbctemplate.queryForList(selectQuery, id, age);
		}
     
	catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
//	public long count(Employee1 employee) {
//		// TODO Auto-generated method stub
//		String s="select * from employee1";
//		result
//	}

	
	
	//selectQuery = "select * from employee1 where 1=1";
//	if (id!=0) {
//		selectQuery = selectQuery + "and id=?";		
//	}
//	if(age!=0)
//	{
//		selectQuery = selectQuery + "and age=?";
//	}

 //Getting the Data from the Table of Employee
// ======================================================================================

  public List<HashMap<String, Object>> getEmployeeDetails1(Employee employee)
   {
  List<HashMap<String,Object>> data=new ArrayList(); 
  List<Map<String,Object>> datalist =new ArrayList<Map<String, Object>>(); 
  HashMap<String, Object> datamap=null; 
  try 
  { 
	  String selectQuery ="select * from employee1";
       datalist=jdbctemplate.queryForList(selectQuery);
     for(Map<String,Object> map : datalist) 
     {
    	 datamap=new HashMap<String,Object>();
             datamap.put("eid",map.get("id")); 
             datamap.put("ename",map.get("name"));
             datamap.put("eage",map.get("age"));
                data.add(datamap);
       } 
     } 
  catch (Exception e) 
  { 
	  e.printStackTrace();
	  }
  return data; 
  } 
  }
 
