package com.newlecture.webprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.webprj.dao.MemberDao;
import com.newlecture.webprj.entity.Member;

public class JdbcMemberDao implements MemberDao {
	
	
	public Member get(String id) {
		Member m = null;
        
        String sql = "SELECT * FROM Member WHERE id=?";
        String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
         
         // Jdbc 드라이버 로드
         try {
            Class.forName("com.mysql.jdbc.Driver");
  
            // 연결 / 인증
            Connection conn = DriverManager.getConnection(url, "sist", "cclass"); // dclass
  
            // 실행
           /* Statement st = conn.createStatement();*/
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
            st.setString(1, id);
            
            // 결과 가져오기
            ResultSet rs = st.executeQuery();
  
            while (rs.next()) {
               m = new Member(
                     rs.getString("id"),
                     rs.getString("pwd"),
                     rs.getString("name"),
                     rs.getString("gender"),
                     rs.getString("birthday"),
                     rs.getString("phone"),
                     rs.getString("email"));
               
            }
  
            rs.close();
            st.close();
            conn.close();
         
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         }
     
         return m;
	}


	   public int insert(String id, String pwd, String name, String gender, String birthday, String phone, String email) {
		 String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	       String sql = "insert into Member (id,pwd,name,gender,birthday,phone,email) values (?,?,?,?,?,?,?)";

	      // Jdbc 드라이버 로드
	      try {
	         Class.forName("com.mysql.jdbc.Driver");

	         // 연결 / 인증
	         Connection conn = DriverManager.getConnection(url, "sist", "cclass"); // dclass

	         // 실행
	         /* Statement st = conn.createStatement(); */
	         PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
	         st.setString(1,"id"); //물음표에 알맞게 넣을 값들
	         st.setString(2,"pwd");
	         st.setString(3,"name");
	         st.setString(4,"gender");
	         st.setString(5,"birthday");
	         st.setString(6,"phone");
	         st.setString(7,"email");
	         
	         
	         // 입력되었는지 알려주는 결과를 가져온다.
	         int result = st.executeUpdate();
	         
	         st.close();
	         conn.close();

	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return insert(new Member(id, pwd, name, null, null, phone, email));
	   }


	   public int insert(Member member) {
		    String sql = "INSERT INTO Notice(id, title, content, writerid) VALUES((select ifnull(max(cast(id as unsigned)),0) +1 id from Notice n),?,?,?)";
			String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		    //String sql = "UPDATE Notice SET title=?, content=? WHERE id=?";

		    // Jdbc 드라이버 로드
		    try {
		       Class.forName("com.mysql.jdbc.Driver");

		       // 연결 / 인증
		       Connection conn = DriverManager.getConnection(url, "sist", "cclass"); // dclass

		       // 실행
		      /* Statement st = conn.createStatement();*/
		       PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
		       st.setString(1, member.getId());
		       st.setString(2, member.getPwd());
		       st.setString(3, member.getName());
		       st.setString(4, member.getGender());
		       st.setString(5, member.getBirthday());
		       st.setString(6, member.getPhone());
		       st.setString(7, member.getEmail());
		       //st.setInt(parameterIndex, x); int면 int형에 맞게 써줘
		       
		      // 결과 가져오기
		       int result = st.executeUpdate();
	       
		       st.close();
		       conn.close();
		    
		    } catch (ClassNotFoundException e) {
		       e.printStackTrace();
		    } catch (SQLException e) {
		       e.printStackTrace();
		    }
	      return 0;
	   }
}
