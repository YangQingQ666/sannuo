package com.xr.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xr.entity.JL;

public interface JlDao {
	Map<String, int[]>adminNumberOfQualified();
	Map<String, int[]> zdNumberOfQualified();
	Map<String, int[]> fdNumberOfQualified();
	List adminMaximumDetection() throws SQLException;
	List otherMaximumDetection() throws SQLException;
}
