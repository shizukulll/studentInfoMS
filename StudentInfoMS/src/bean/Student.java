package bean;

import dao.impl.studentDaoImpl;
import java.sql.SQLException;

public class Student {
    private String name;
    private String id;
    private String age;
    private  String sex;
    private String major;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public Student(String name,String id,String age,String sex,String major){
        setName(name);  setId(id);
        setAge(age);    setSex(sex);
        setMajor(major);
    }

    @Override
    public String toString() {
        return
                name + '\t' +
                id + '\t' +
                age + '\t' +
                sex + '\t' +
                major + '\t';
    }

    public Student(String name, String id){
        setName(name);
        setId(id);
    }

    public boolean delete(){
        return  new studentDaoImpl().delete(getId());
    }

    public boolean insert(){
        return new studentDaoImpl().insert(getName(),getId(),
                getAge(),getSex(),getMajor());
    }

    public boolean change(){
        return new studentDaoImpl().change(getName(),getId(),getAge(),getSex(),getMajor());
    }
    public Student[] search(){
        return new studentDaoImpl().search(getName());
    }
}
