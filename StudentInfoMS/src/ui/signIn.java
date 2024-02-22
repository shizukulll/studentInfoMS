package ui;

import Observer.MySubject;
import bean.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class signIn {
    private static signIn instance = null;
    private JFrame frame;
    // 私有构造方法，防止被实例化
    private signIn() {
        MySubject mySubject = MySubject.getInstance();
        mySubject.notifyObservers("进入注册页面，注册页面使用单例模式");
        frame = new JFrame("sign in");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(320, 250);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        JLabel nameLabel = new JLabel("Nick:");
        nameLabel.setBounds(10,80,80,25);
        panel.add(nameLabel);

        JTextField nickField = new JTextField(10);
        nickField.setBounds(100,80,165,25);
        panel.add(nickField);

        JButton signInButton = new JButton("sign in");
        signInButton.setBounds(350/2-40, 120, 80, 25);
        panel.add(signInButton);

        JButton cancelButton = new JButton("cancel");
        cancelButton.setBounds(350/2-40, 160, 80, 25);
//        panel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if( new Admin().signIn(userText.getText(),passwordText.getText(),nickField.getText())){
                        Dialog  dialog = new Dialog("注册成功",1);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null); // 居中显示
                        dialog.setVisible(true);
                        closeWindow();
                    }else{
                        Dialog  dialog = new Dialog("注册失败，请选择其他id",2);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null); // 居中显示
                        dialog.setVisible(true);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        frame.add(panel);
        frame.setVisible(true);
    }

    // 静态工程方法，创建实例
    public static signIn getInstance() {
        if (instance == null) {
            instance = new signIn();
        }
        return instance;
    }


    public void closeWindow() {
        if (frame != null) {
            frame.dispose(); // 释放窗口占用的资源
//            instance = null; // 将单例实例置为 null，以便于垃圾收集
        }

    }
}
