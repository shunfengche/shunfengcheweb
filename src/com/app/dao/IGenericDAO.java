package com.app.dao;

import java.util.List;

import net.sf.json.JSONArray;



public interface IGenericDAO{

	

	
	JSONArray getObjectsByConditions(String sql);
	
	
}
