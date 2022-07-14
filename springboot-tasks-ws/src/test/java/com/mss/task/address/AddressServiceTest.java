package com.mss.task.address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class AddressServiceTest {

	@InjectMocks
	AddressService addressService;
	@Mock
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Test
	public void insertData()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(1);
		Map<String, Object> insertMap=addressService.insertAddress(insertDataAddress());
		assertEquals("Successfully Inserted Data", insertMap.get("Data"));
	}
	@Test
	public void insertDataFalse()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(0);
		Map<String, Object> insertMap=addressService.insertAddress(insertDataAddress());
		assertEquals("Not Inserted", insertMap.get("Data"));
	}
	@Test
	public void insertDataException()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenThrow(NullPointerException.class);
		Map<String, Object> insertMap=addressService.insertAddress(insertDataAddress());
		assertTrue(insertMap.isEmpty());
	}
	private Address insertDataAddress() {
		Address address= new Address();
		address.setUserId(1);
		address.setAddress("CCC");
		address.setPin(54);
		address.setState("AP");
		return address;
	}
	@Test
	public void updateAddressData()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(1);
		Map<String, Object> updateMap=addressService.updateAddress(insertDataAddress());
		assertEquals("Successfully Updated", updateMap.get("Data"));
	}
	@Test
	public void updateAddressDataCase()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(0);
		Map<String, Object> updateMap=addressService.updateAddress(insertDataAddress());
		assertEquals("Not Updated", updateMap.get("Hloo"));
	}
	@Test
	public void updateDataException()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenThrow(NullPointerException.class);
		Map<String, Object> updateMap=addressService.updateAddress(insertDataAddress());
		assertTrue(updateMap.isEmpty());
	}
	@Test
	public void deleteAddressData()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(1);
		Map<String, Object> deleteMap=addressService.deleteAddress(insertDataAddress());
		assertEquals("Successfully Deleted", deleteMap.get("Data"));
	}
	@Test
	public void deleteAddressDataCase()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(0);
		Map<String, Object> deleteMapCase=addressService.deleteAddress(insertDataAddress());
		assertEquals("Not Deleted", deleteMapCase.get("Data"));
	}
	@Test
	public void deleteAddressException()
	{
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenThrow(NullPointerException.class);
		Map<String, Object> deleteMapCase=addressService.deleteAddress(insertDataAddress());
		assertTrue(deleteMapCase.isEmpty());
	}
//	@Test
//	public void getAddressTest()
//	{
//		Mockito.when(namedParameterJdbcTemplate.queryForList(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class)));
//		List<HashMap<String, Object>> listMap = addressService.GetAddress(getAddressData());	
//	}
	private List<Map<String, Object>> getAddressData() {
		List<Map<String, Object>> listMap1 = new ArrayList<>();
		Map<String,Object> mapData = new HashMap<>();
		mapData.put("userid", 101);
		mapData.put("address", "ABC");
		mapData.put("state", "ABC");
		mapData.put("pin", 123);
		listMap1.add(mapData);
		return listMap1;
	}
//	@Test
//	public void getAddressException()
//	{
//		Mockito.when(namedParameterJdbcTemplate.queryForList(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenThrow(NullPointerException.class);
//		Map<String, Object> deleteMapCase=addressService.GetAddress(insertDataAddress());
//		assertTrue(deleteMapCase.isEmpty());
//	}
}
