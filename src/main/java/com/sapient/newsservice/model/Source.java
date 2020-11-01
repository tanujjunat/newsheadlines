package com.sapient.newsservice.model;

import java.io.Serializable;
import java.util.Date;

public class Source implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4376503048167363578L;
	
	public String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name;
	
	
	

}
