package dao.impl;

import bean.Student;
import dao.studentDao;
import util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDaoImpl implements studentDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    @Override
    public boolean insert(String name, String id, String age, String sex, String major) {
        conn= DatabaseBean.getConnection();
        String sql = "insert into sjms.student (id,name,age,sex,major)VALUES(?,?,?,?,?)";
        int isSuccess = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,age);
            pstmt.setString(4,sex);
            pstmt.setString(5,major);
            isSuccess = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseBean.close(rs,pstmt,conn);
        }
        if(isSuccess == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        conn= DatabaseBean.getConnection();
        String sql = "DELETE FROM sjms.student WHERE id = ?";
        int isSuccess = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            isSuccess = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseBean.close(rs,pstmt,conn);
        }
        if(isSuccess == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean change(String id, String name, String age, String sex, String major) {
        conn = DatabaseBean.getConnection();
        String sql = "UPDATE sjms.student SET name = ?, age = ?, sex = ?, major = ? WHERE id = ?";
        int isSuccess = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, age);
            pstmt.setString(3, sex);
            pstmt.setString(4, major);
            pstmt.setString(5, id);
            isSuccess = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.close(rs, pstmt, conn);
        }
        if (isSuccess == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student[] search(String name) {
        conn = DatabaseBean.getConnection();
        String sql = "SELECT * FROM sjms.student WHERE name = ?";
        List<Student> studentList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student(rs.getString("name"),rs.getString("id"),
                        rs.getString("age"),rs.getString("sex"),rs.getString("major"));
                studentList.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.close(rs, pstmt, conn);
        }
        return studentList.toArray(new Student[studentList.size()]);
    }
}
