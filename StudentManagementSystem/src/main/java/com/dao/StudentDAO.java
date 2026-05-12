package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Bean.StudentBean;

public class StudentDAO {
    Connection con = DBConnection.getConnection();
//insert
	 public int saveStudent(StudentBean s) {
		int status=0;
		try {
			String sql="insert into student90(name,email,course) values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getEmail());
			pstmt.setString(3, s.getCourse());
			
			status=pstmt.executeUpdate();
			}catch (Exception e) {
			e.printStackTrace();
			}
		 return status;
 
   }
	 //View
	 
	 public List<StudentBean> getAllStudents(){
		 ArrayList<StudentBean> list=new ArrayList<StudentBean>();
		 
		 try {
			 String sql="select*from student90";
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 ResultSet rs=pstmt.executeQuery();
			 
			 while(rs.next()) {
				 StudentBean s =new StudentBean();
				 s.setId(rs.getInt("id"));
				 s.setName(rs.getString("name"));
				 s.setEmail(rs.getString("email"));
				 s.setCourse(rs.getString("course"));
				 
				 list.add(s);
			 }
			 
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		 return list;
		 
	 }
	 //Delete
	 public int deleteStudent(int id) {
		 int status=0;
		 try {
			 String sql="delete from student90 where id=?";
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1, id);
			 status=pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		 return status;
	 }
	 //update
	 public int updateStudent(StudentBean s) {
		 int status=0;
		 try {
			 String sql="update student90 set name=?,email=?,course=? where id=?";
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, s.getName());
			 pstmt.setString(2, s.getEmail());
			 pstmt.setString(3,s.getCourse());
			 pstmt.setInt(4, s.getId());
			 status=pstmt.executeUpdate();
		 }catch (Exception e) {
			 
			 e.printStackTrace();
		}
		 return status;
	 }
	 
	 //get student by id
	 public StudentBean getsaveStudentById(int id) {

		    StudentBean s = new StudentBean();

		    try {

		        String sql =
		                "select * from student90 where id=?";

		        PreparedStatement pstmt =
		                con.prepareStatement(sql);

		        pstmt.setInt(1, id);

		        ResultSet rs =
		                pstmt.executeQuery();

		        if(rs.next()) {

		            s.setId(rs.getInt("id"));
		            s.setName(rs.getString("name"));
		            s.setEmail(rs.getString("email"));
		            s.setCourse(rs.getString("course"));
		        }

		    } catch (Exception e) {

		        e.printStackTrace();
		    }

		    return s;
		}
    
}
