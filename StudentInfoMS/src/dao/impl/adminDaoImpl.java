package dao.impl;

import dao.adminDao;
import util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDaoImpl implements adminDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    @Override
    public boolean check(String id, String pwd) throws SQLException {
        conn = DatabaseBean.getConnection();
        String sql = "select *from sjms.admin where id=? and pwd=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            return rs.next() ? true : false;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseBean.close(rs,pstmt,conn);
        }
        return false;
    }


    @Override
    public boolean insert(String id, String pwd, String name) throws SQLException {
        conn= DatabaseBean.getConnection();
        String sql = "insert into sjms.admin (id,pwd,name)VALUES(?,?,?)";
        int isSuccess = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,pwd);
            pstmt.setString(3,name);
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
    public boolean change(String id, String pwd, String name) throws SQLException {
        return false;
    }

}
