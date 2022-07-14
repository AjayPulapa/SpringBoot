package com.mss.task.address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
//@Component
//@Service
//@Controller
public class AddressService {
  @Autowired
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  public Map<String, Object> insertAddress(Address addresses) {
	  int userId = addresses.getUserId();
	  String address = addresses.getAddress();
		 String state=addresses.getState();
	  int pin = addresses.getPin();
	  Map<String, Object> response = new HashMap();
	  try {
	  String insertQuery = "INSERT INTO address (userid,address,state,pin)VALUES(:UserId,:Address,:State,:Pin)";
	  MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("UserId", userId)
		  .addValue("Address", address).addValue("State",state).addValue("Pin",pin);
	  int result = namedParameterJdbcTemplate.update(insertQuery, sqlParameterSource);
	  if (result > 0) {
	  response.put("Data", "Successfully Inserted Data");
	  } 
	  else {
	  response.put("Data", "Not Inserted");
	  }
	  }
	  catch (Exception ex) {
	  ex.printStackTrace();
	  }
	  return response;

	  }
  //============================================================
  public Map<String, Object> updateAddress(Address addresses) {
	  Map<String, Object> response = new HashMap();
	  String address=addresses.getAddress();
	  int uid=addresses.getUserId();
	  try {
	  String updateQuery = "UPDATE ADDRESS SET address=:Address WHERE userid=:Uid";
	  MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("Address", address)
		  .addValue("Uid", uid);
	  int result = namedParameterJdbcTemplate.update(updateQuery, sqlParameterSource);
	  if (result == 1) {
	  response.put("Data", "Successfully Updated");
	  } 
	  else {
	  response.put("Hloo", "Not Updated");
	  }
	  }
	  catch (Exception ex) {
	  ex.printStackTrace();
	  }
	  return response;

	  }
  //=============================================================
  public Map<String, Object> deleteAddress(Address addresses) {
	  int  uid=addresses.getUserId();
	  Map<String, Object> response = new HashMap();
	  try {
	  String deleteQuery = "DELETE from ADDRESS where userid=:Uid";
	  MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("Uid", uid);
	  int result = namedParameterJdbcTemplate.update(deleteQuery, sqlParameterSource);
	  if (result == 1) {
	  response.put("Data", "Successfully Deleted");
	  } 
	  else {
	  response.put("Data", "Not Deleted");
	  }
	  }
	  catch (Exception ex) {
	  ex.printStackTrace();
	  }
	  return response;

	  }
  //=================================================================
  public List<HashMap<String, Object>> GetAddress(Address address) {
	     List<HashMap<String,Object>> data= new ArrayList();
		  List<Map<String, Object>> datalist = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> mapdata=null;
		  try {
			  String selectQuery="SELECT * FROM address";
		     MapSqlParameterSource parameter=new MapSqlParameterSource();
		     datalist =namedParameterJdbcTemplate.queryForList(selectQuery,parameter);
		     for(Map<String, Object> map:datalist)
		     {
		    	 mapdata=new HashMap<String, Object>();
		    	 mapdata.put("Id",map.get("id"));
		    	 mapdata.put("UserId",map.get("userid"));
		    	 mapdata.put("Address",map.get("address"));
		    	 mapdata.put("state",map.get("state"));
		    	 mapdata.put("pin",map.get("pin"));
		    	 mapdata.put("Date",map.get("date"));
		    	 data.add(mapdata);
		     }
		  }
		  catch (Exception ex) {
		  ex.printStackTrace();
		  }
	       return data;
		  }
  //==============================================================
  public List<HashMap<String, Object>> GetAddressById(Address address) {
	     List<HashMap<String,Object>> data= new ArrayList();
		  List<Map<String, Object>> datalist = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> mapdata=null;
		  try {
			  String selectQuery="SELECT * FROM address where id:=Id";
		     MapSqlParameterSource parameter=new MapSqlParameterSource().addValue("Id",address.getId());
		     datalist =namedParameterJdbcTemplate.queryForList(selectQuery,parameter);
		     for(Map<String, Object> map:datalist)
		     {
		    	 mapdata=new HashMap<String, Object>();
		    	 mapdata.put("Id",map.get("id"));
		    	 mapdata.put("UserId",map.get("userid"));
		    	 mapdata.put("Address",map.get("address"));
		    	 mapdata.put("state",map.get("state"));
		    	 mapdata.put("pin",map.get("pin"));
		    	 mapdata.put("Date",map.get("date"));
		    	 data.add(mapdata);
		     }
		  }
		  catch (Exception ex) {
		  ex.printStackTrace();
		  }
	       return data;
		  }
}
	 

