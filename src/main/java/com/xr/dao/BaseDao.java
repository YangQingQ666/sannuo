package com.xr.dao;

import java.sql.*;

/**
 *
 * @author Administrator 数据库连接
 */
public class BaseDao {
	// 连接字符串
	public String driver = "com.mysql.jdbc.Driver";// 数据库驱动
	public String url = "jdbc:mysql://47.103.156.108:3306/sannuo?useUnicode=true&characterEncoding=UTF-8";// 建立到给定数据库
																	// URL 的连接。
	public String username = "dms";// 数据库用户
	public String password = "Wzh000426-";// 数据库密码
	// 声明接口
	public Connection con;
	public PreparedStatement pstmt;
	public ResultSet rs;

	// 获得数据库连接
	public Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 释放数据库资源
	public void CloseAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}