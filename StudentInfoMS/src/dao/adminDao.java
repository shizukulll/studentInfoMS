package dao;

import java.sql.SQLException;

public interface adminDao {
    boolean check(String id,String pwd) throws SQLException;
    boolean insert(String id ,String pwd ,String name) throws SQLException;
    boolean change(String id ,String pwd ,String name) throws SQLException;

}
