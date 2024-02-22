package ui;

import Observer.MySubject;
import ui.factory.UIFactory;
import ui.factory.UIFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class mainPanel {
    private JPanel panel;
    private void showFrame(Class<? extends UIFrame> frameClass) {
        UIFrame frame = UIFactory.createFrame(frameClass);
        frame.setVisible(true);
//        this.dispose();
    }



    public mainPanel(){
        MySubject mySubject = MySubject.getInstance();
        mySubject.notifyObservers("进入主页");
        JFrame frame = new JFrame("studentInfoMS");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton insertBtn = new JButton("添加学生信息");
        insertBtn.setBounds(50,30,120,40);
        panel.add(insertBtn);
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mySubject.notifyObservers("进入添加页面，使用工厂模式");
                showFrame(insertPanel.class);
            }
        });

        JButton deleteBtn = new JButton("删除学生信息");
        deleteBtn.setBounds(50,100,120,40);
        panel.add(deleteBtn);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mySubject.notifyObservers("进入删除页面，使用工厂模式");
                showFrame(deletePanel.class);
            }
        });

        JButton changeBtn = new JButton("修改学生信息");
        changeBtn.setBounds(50,170,120,40);
        panel.add(changeBtn);
        changeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mySubject.notifyObservers("进入更改页面，使用工厂模式");
                showFrame(changePanel.class);
            }
        });

        JButton searchBtn = new JButton("查询学生信息");
        searchBtn.setBounds(50,240,120,40);
        panel.add(searchBtn);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mySubject.notifyObservers("进入搜索页面，使用工厂模式");
                showFrame(searchPanel.class);
            }
        });

        JLabel picture = new JLabel();
        URL url = mainPanel.class.getResource("./picture/hello.jpg");
        Icon icon = new ImageIcon(url);
        picture.setIcon(icon);
        picture.setBounds(200,30,350,250);
        panel.add(picture);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new mainPanel();
    }

}
