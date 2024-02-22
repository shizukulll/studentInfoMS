package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel messageLabel;
    private int type = 0;

    public Dialog(String message, int type) {
        this.type = type; // 将传入的type值赋给类的type变量  
        initialize(message);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // ... 其他代码保持不变 ...  
    }

    private void initialize(String message) {
        // 初始化contentPane  
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout()); // 可以设置布局管理器  
        setContentPane(contentPane);

        // 设置提示信息的标签  
        messageLabel = new JLabel(message);
        contentPane.add(messageLabel, BorderLayout.CENTER); // 将标签添加到内容面板中，并指定位置  

        // 初始化并添加按钮  
        buttonOK = new JButton("OK");
        buttonCancel = new JButton("Cancel");

        // 将按钮添加到内容面板的南部（下方）  
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.add(buttonOK);
        buttonPane.add(buttonCancel);
        contentPane.add(buttonPane, BorderLayout.SOUTH);

        // ... 其他初始化代码 ...  

        // 添加按钮的事件监听器  
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 设置默认的关闭操作和键盘行为（这些可以在构造函数中设置）  
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (type == 1) {
            // 注册成功
        } else if (type == 2) {
            //注册失败
        } else if (type == 3) {
            //登录成功
        } else if (type == 4) {
            //登录失败
        }
        dispose();
    }

    private void onCancel() {
        if (type == 1) {
            // 注册成功
        } else if (type == 2) {
            //注册失败
        } else if (type == 3) {
            //登录成功
        } else if (type == 4) {
            //登录失败
        }
        dispose();
    }

    public static void main(String[] args) {
        // 测试对话框
        Dialog dialog = new Dialog("这是一个提示框", 0);
        dialog.pack();
        dialog.setLocationRelativeTo(null); // 居中显示
        dialog.setVisible(true);
    }
}