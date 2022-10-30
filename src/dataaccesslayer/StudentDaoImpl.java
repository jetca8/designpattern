package dataaccesslayer;

import java.util.List;
import transferobjects.StudentDto;
import java.sql.*;
import java.util.ArrayList;

/*
Student Name: Jian Zhou
Student Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
 */
/**
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<StudentDto> getAll() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<StudentDto> students = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID, LastName, FirstName, Email, PhoneNumber FROM student");
            rs = pstmt.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                StudentDto student = new StudentDto();
                student.setStudentID(rs.getInt("StudentID"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setEmail(rs.getString("Email"));
                student.setPhoneNumber(rs.getString("PhoneNumber"));
                students.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
        return students;
    }

    @Override
    public StudentDto getById(Integer studentID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentDto student = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID, LastName, FirstName, Email, PhoneNumber FROM student WHERE StudentID = ?");
            pstmt.setInt(1, studentID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new StudentDto();
                student.setStudentID(rs.getInt("StudentID"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setEmail(rs.getString("Email"));
                student.setPhoneNumber(rs.getString("PhoneNumber"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
        return student;
    }

    @Override
    public void add(StudentDto student) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO student (StudentID, FirstName, LastName, Email, PhoneNumber) "
                    + "VALUES(?, ?, ?, ?, ?)");
            pstmt.setInt(1, student.getStudentID());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert failed!");
            e.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
    }

    @Override
    public void update(StudentDto student) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                "UPDATE student SET FirstName = ?, " + 
		"LastName = ?, " + 
                "Email = ?, " + 
                "PhoneNumber = ? " +         
                            "WHERE StudentID = ?");
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getPhoneNumber());
            pstmt.setInt(5, student.getStudentID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
    }

    @Override
    public void delete(StudentDto student) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                "DELETE FROM student WHERE StudentID = ?"  );
            pstmt.setInt(1, student.getStudentID());
            pstmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeConnection(con,pstmt,rs);
        }
        
    }

    private void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
