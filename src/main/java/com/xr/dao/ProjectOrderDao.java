package com.xr.dao;

import java.util.List;
import java.util.Map;

import com.xr.entity.JL;
import com.xr.entity.Project;
import com.xr.entity.ProjectOrder;

public interface ProjectOrderDao {
	Map<String, Map<String, Integer>> findByWhere(List<Object> list);
	List<Project> findByProjectAllByBoy();
	List<Project> findByProjectAllByGily();
	List<JL> findPublicinspectionRecords(String zd,String fd,String start,String end);
}
