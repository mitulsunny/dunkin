package com.dunkin.shadman.onlineStore.helper.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDBQuery {
	public int getID(String username) throws SQLException {
		String dbQuery = "select * from members where username='"+username+"'";
		ResultSet result = DatabaseHelper.getResultSet(dbQuery);
		int id = 0;
		
		while(result.next()) {
			id = result.getInt("memberID");
		}
		
		return id;
	}
	
	public List<Members> getMembers() throws SQLException {
		List<Members> m = new ArrayList<Members>();
		String dbQuery = "select * from members";
		ResultSet result = DatabaseHelper.getResultSet(dbQuery);
		
		while(result.next()) {
			Members mem = new Members();
			mem.setMemberID(result.getInt("memberID"));
			mem.setUsername(result.getString("username"));
			mem.setName(result.getString("name"));
			mem.setEmail(result.getString("email"));
			m.add(mem);
		}
		
		return m;
	}
	
	public static void main(String[] args) throws SQLException {
		ApplicationDBQuery app = new ApplicationDBQuery();
		int id = app.getID("admin");
		System.out.println(id);
		List<Members> listMembers = app.getMembers();
		System.out.println("=============");
		for(Members e:listMembers) {
			System.out.println(e.getUsername());
			System.out.println(e.getName());
			System.out.println(e.getEmail());
			System.out.println(e.getMemberID());
			System.out.println("=============");
		}
	}
}
