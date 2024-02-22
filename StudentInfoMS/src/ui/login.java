package ui;

import Observer.MySubject;
import bean.Admin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class login {
    private JPanel panel1;
    public static void CreatGUI() {
        JFrame frame= new JFrame("login");
        JPanel rootPane=new login().panel1;
        frame.setContentPane(rootPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(320, 200);
        frame.setLocationRelativeTo(rootPane);
        frame.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
        placeComponents(rootPane);
    }
    private static void placeComponents(JPanel panel) {
        MySubject mySubject = MySubject.getInstance();
        mySubject.notifyObservers("进入登录页面，注册页面使用单例模式");
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

        JButton loginButton = new JButton("login");
        loginButton.setBounds(350/2, 200/2-12, 80, 25);
        panel.add(loginButton);

        JButton signInButton = new JButton("sign in");
        signInButton.setBounds(350/2-140, 200/2-12, 80, 25);
        panel.add(signInButton);
        
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.print("sign in");
                signIn signInWindow = signIn.getInstance();
            }
        });


        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(new Admin().loginCheck(userText.getText(),passwordText.getText())){
//                        System.out.print("login");
                        Dialog dialog = new Dialog("登录成功",3);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                        mainPanel mp = new mainPanel();
//                        ((JFrame)e.getSource()).dispose();
                        Window window = SwingUtilities.getWindowAncestor((Component)e.getSource());
                        if (window != null) {
                            window.dispose();
                        }
                    }else{

                        Dialog dialog = new Dialog("登录失败，请检查用户名或密码",4);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null); // 居中显示
                        dialog.setVisible(true);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        loginButton.addActionListener(listener);

    }

}
