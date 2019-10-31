package com.xr.dao;

import java.sql.SQLException;
import java.util.List;

import com.xr.entity.Boss;
import com.xr.entity.Branch;
import com.xr.entity.Project;

public interface BranchDao {
	List<Branch> getBigBranchByBid(Boss boss) throws SQLException;
	List<Branch> getBigBranchByBid(String partid) throws SQLException;
	//List<Branch> getMysamllBranchBypartId(String partid) throws SQLException;
	List<Branch> findAllBigBranch() throws SQLException;
	List<Branch> findAllSmallBranch() throws SQLException;
	//List<Branch> getMysamllBranchBypartId(Boss boss) throws SQLException;
	//增加总店铺
	public int allBigBranch(Branch b) throws Exception;
}
