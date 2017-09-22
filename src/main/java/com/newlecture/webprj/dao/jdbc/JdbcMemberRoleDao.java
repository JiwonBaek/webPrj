package com.newlecture.webprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.webprj.dao.MemberRoleDao;
import com.newlecture.webprj.entity.NoticeView;

public class JdbcMemberRoleDao implements MemberRoleDao {


	public String getDefaultRoleId(String memberId) {
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "select roleId from MemberRole where memberId=? and defaultRole=1;";

		String iid = "";
		// jdbc ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ���� /����
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// ����
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberId);

			// ��� ��������
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				iid = rs.getString("roleId");

			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return iid;
	}
}

