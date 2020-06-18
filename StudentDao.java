package tw.com.phctw.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import tw.com.phctw.bean.Student;

public class StudentDao {
	public StudentDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","12913804"); 
			con.close();  
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
	public ArrayList<Student> selectStudent(){
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","12913804"); 
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENTINFO"); 
			ResultSet rs = stmt.executeQuery();  
			  
			while(rs.next()){  
				Student s = new Student();
				s.setSno(rs.getString("SNO"));
				s.setsName(rs.getString("SNAME"));
				s.setAge(rs.getInt("AGE"));
				s.setSex(rs.getInt("SEX"));
				s.setpId(rs.getString("PID"));
				list.add(s);
			} 
			con.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return list;
	}
	
	public Student getStudent(String sno) {
		if(!validSno(sno)) {
			return null;
		}
		Student s = new Student();
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","12913804"); 
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENTINFO "
														+ "WHERE SNO = ?"); 
			stmt.setString(1, sno);
			ResultSet rs = stmt.executeQuery();  
			while(rs.next()){  
				s.setSno(rs.getString("SNO"));
				s.setsName(rs.getString("SNAME"));
				s.setAge(rs.getInt("AGE"));
				s.setSex(rs.getInt("SEX"));
				s.setpId(rs.getString("PID"));
			} 
			con.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return s;
	}
	
	public boolean insertStudent(Student student) {
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","12913804"); 
			PreparedStatement stmt = con.prepareStatement("INSERT INTO STUDENTINFO "
					 + "(SNO, SNAME, AGE, SEX, PID) VALUES (?, ?, ?, ?, ?)");  
		    stmt.setString(1, student.getSno());
		    stmt.setString(2, student.getsName());
		    stmt.setInt(3, student.getAge());
		    stmt.setInt(4, student.getSex());
		    stmt.setString(5, student.getpId());
		    result = stmt.executeUpdate();
		    if(result == 1) {
		    	System.out.println("Insert complete...");
		    }else {
		    	System.out.println("Insert failed...");
		    }
			con.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return result == 1;
	}
	
	public boolean updateStudent(Student student) {
		if(!validSno(student.getSno())) {
			return false;
		}
		
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","12913804"); 
			PreparedStatement stmt = con.prepareStatement("UPDATE STUDENTINFO "
					 + "SET SNAME = ?, AGE = ?, SEX = ?, PID = ?"
					 + "WHERE SNO = ?");  
		    stmt.setString(1, student.getsName());
		    stmt.setInt(2, student.getAge());
		    stmt.setInt(3, student.getSex());
		    stmt.setString(4, student.getpId());
		    stmt.setString(5, student.getSno());
		    result = stmt.executeUpdate();
		    if(result == 1) {
		    	System.out.println("Update complete...");
		    }else {
		    	System.out.println("Update failed...");
		    }
			con.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return result == 1;
	}
	
	public boolean deleteStudent(String sno) {
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","12913804"); 
			PreparedStatement stmt = con.prepareStatement("DELETE FROM STUDENTINFO "
														+ "WHERE SNO = ?");  
		    stmt.setString(1, sno);
		    result = stmt.executeUpdate();
		    if(result == 1) {
		    	System.out.println("Delete complete...");
		    }else {
		    	System.out.println("Delete failed...");
		    }
			con.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return result == 1;
	}
	
	public boolean deleteAll() {
		int result = -1;
		int require = selectStudent().size();
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","12913804"); 
			PreparedStatement stmt = con.prepareStatement("DELETE FROM STUDENTINFO");  
		    result = stmt.executeUpdate();
		    if(result == require) {
		    	System.out.println("Delete ALL complete...");
		    }else {
		    	System.out.println("Delete ALL failed...");
		    }
			con.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return result == require;
	}
	
	private boolean validSno(String sno) {
		ArrayList<Student> list = selectStudent();
		boolean result = false;
		for(Student s : list) {
			if(s.getSno().equals(sno)) {
				result = true;
			}
		}
		return result;
	}
}
