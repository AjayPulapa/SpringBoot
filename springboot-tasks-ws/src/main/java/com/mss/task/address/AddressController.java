package com.mss.task.address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/address")
public class AddressController {
  @Autowired
  AddressService addressService;
  @PostMapping("/address")
  public Map<String, Object> insertAddress(@RequestBody Address address)
  {
	  return addressService.insertAddress(address);
  }
  @PutMapping("/address")
  public Map<String, Object> updateAddress(@RequestBody Address address)
  {
	  return addressService.updateAddress(address);
  }
  @DeleteMapping("/address")
  public Map<String, Object> deleteAddress(@RequestBody Address address)
  {
	  return addressService.deleteAddress(address);
  }
  @GetMapping("/address")
  public List<HashMap<String, Object>> GetAddress(Address address)
  {
	  return addressService.GetAddress(address);
  }
  @GetMapping("/address/id")
  public List<HashMap<String, Object>> GetAddressById(@RequestBody Address address)
  {
	  return addressService.GetAddressById(address);
  }
}
