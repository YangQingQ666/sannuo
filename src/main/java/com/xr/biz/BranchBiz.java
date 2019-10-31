package com.xr.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xr.entity.Boss;
import com.xr.entity.Branch;

public interface BranchBiz {
	String getBigBranchs(Boss boss) throws SQLException;
	String getBigBranch(Boss boss) throws SQLException;
	String getBigBranchs() throws SQLException;
	String getsmallBranchs(String partid) throws SQLException;
	String getsmallBranch(String partid) throws SQLException;
	
}
