package bean;

import dao.impl.adminDaoImpl;

import java.sql.SQLException;

public class Admin {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    String id;
    String pwd;
    public boolean loginCheck(String uid,String upwd) throws SQLException {
        if(new adminDaoImpl().check(uid,upwd)){
            return true;
        }else {
            return false;
        }
    }

    public boolean signIn(String uid,String upwd,String uname) throws SQLException {
        if(new adminDaoImpl().insert(uid,upwd,uname)){
            return true;
        }else{
            return false;
        }
    }
}
