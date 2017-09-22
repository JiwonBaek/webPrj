package com.newlecture.webprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.webprj.dao.NoticeDao;
import com.newlecture.webprj.entity.Notice;
import com.newlecture.webprj.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {

	public List<NoticeView> getList(int page, String query) {
        String sql = "SELECT *FROM NoticeView WHERE title like ? order by regDate desc limit ?, 10";       
        String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
        // JDBC 드라이버 로드
        
        List<NoticeView> list=null;
        int offset = (page-1)*10;

        try {
           Class.forName("com.mysql.jdbc.Driver");
           
           // 연결 / 인증
            Connection con = DriverManager.getConnection(url, "sist", "cclass");
        
            // 실행
            //Statement st = con.createStatement();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+query+"%");
            st.setInt(2, offset);
 
            // 결과 가져오기
            ResultSet rs = st.executeQuery();
        
            // Model 
            list = new ArrayList<>();
            
            // 결과 사용하기
            while (rs.next()) {
               NoticeView n = new NoticeView();
               n.setId(rs.getString("id"));
               n.setTitle(rs.getString("title"));
               n.setWriterId(rs.getString("writerId"));
               n.setWriterName(rs.getString("writerName"));
               n.setContent(rs.getString("content"));
               n.setHit(rs.getInt("hit"));
               n.setCountCmt(rs.getInt("countCmt"));
               
               list.add(n);
        }
            
        rs.close();
        st.close();
        con.close();
        
           
        } catch (ClassNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
     return list;
  }

   public int getCount() {

      String sqlCount = "select count(*) count from Notice";
      
      String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
      
      
      int count =0;
        // JDBC 드라이버 로드
        try {
           Class.forName("com.mysql.jdbc.Driver");
         
            // 연결 / 인증
            Connection con = DriverManager.getConnection(url, "sist", "cclass");
      
            
            //페이징
            Statement stCount = con.createStatement();
            ResultSet rsCount = stCount.executeQuery(sqlCount);
            rsCount.next();
            count = rsCount.getInt("count");
      
      
            // Model 
            
            // 결과 사용하기
            
            rsCount.close();
            stCount.close();
            con.close();
            
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return count;
   }


   public NoticeView get(String id) {
      
        String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
        String sql = "SELECT *FROM NoticeView WHERE id = ?";
        NoticeView n = null;
         
         try {
            Class.forName("com.mysql.jdbc.Driver");

            // 연결 / 인증
            Connection con = DriverManager.getConnection(url, "sist", "cclass");

            // 실행
            //Statement st = con.createStatement();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            
            // 결과 가져오기
            ResultSet rs = st.executeQuery();

            // Model 
            
            
            // 결과 사용하기
            if (rs.next()) {
               n = new NoticeView();
               n.setId(rs.getString("id"));
               n.setTitle(rs.getString("title"));
               n.setContent(rs.getString("content"));
               n.setWriterId(rs.getString("writerid"));
               n.setRegDate(rs.getDate("regDate"));
               n.setHit(rs.getInt("hit"));
               //..
               
            }
            rs.close();
            st.close();
            con.close();
            
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      
      return  n;
   }


   public int update(String id, String title, String content) {
      
      String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
       String sql = "update Notice set title = ?, content =?  where id = ?";
       int result =0;
         try {
            Class.forName("com.mysql.jdbc.Driver");

            // 연결 / 인증
            Connection con = DriverManager.getConnection(url, "sist", "cclass");

            // 실행
            //Statement st = con.createStatement();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, content);
            st.setString(3, id);
            
            // 업데이스 결과 가져오기 몇개인지
            result = st.executeUpdate();
            

            // Model 
            
               
            st.close();
            con.close();
            
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      return result;
      
   }
   
}