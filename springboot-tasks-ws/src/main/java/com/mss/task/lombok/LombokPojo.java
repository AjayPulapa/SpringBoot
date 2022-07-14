package com.mss.task.lombok;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class LombokPojo {
	@Id
   private int id;
   private String name;
}
