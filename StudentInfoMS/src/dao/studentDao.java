package dao;

import bean.Student;

public interface studentDao {
    boolean insert(String name,String id,String age,String sex,String major);
    boolean delete(String id);
    boolean change(String name, String id, String age, String sex, String major);
    Student[] search(String name);

}
