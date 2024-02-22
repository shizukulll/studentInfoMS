package ui;

import bean.Student;
import ui.factory.UIFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changePanel extends UIFrame {

//    JFrame frame = new JFrame("change");

    JPanel panel= new JPanel();
    public changePanel(){
        setTitle("change");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(320, 250);
        panel.setLayout(null);
        setContentPane(panel);
        setupUI();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setupUI() {
        JLabel nameLab = new JLabel("姓名");
        nameLab.setBounds(10,20,80,25);
        panel.add(nameLab);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100,20,165,25);
        panel.add(nameText);

        JLabel idLabel = new JLabel("学号");
        idLabel.setBounds(10,50,80,25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100,50,165,25);
        panel.add(idText);

        JLabel ageLabel = new JLabel("年龄");
        ageLabel.setBounds(10,80,80,25);
        panel.add(ageLabel);

        JTextField ageField = new JTextField(10);
        ageField.setBounds(100,80,165,25);
        panel.add(ageField);

        JLabel sexLabel = new JLabel("性别");
        sexLabel.setBounds(10,110,80,25);
        panel.add(sexLabel);

        JTextField sexField = new JTextField(10);
        sexField.setBounds(100,110,165,25);
        panel.add(sexField);

        JLabel majorLabel = new JLabel("专业");
        majorLabel.setBounds(10,140,80,25);
        panel.add(majorLabel);

        JTextField majorField = new JTextField(10);
        majorField.setBounds(100,140,165,25);
        panel.add(majorField);

        JButton insertBtn = new JButton("更改");
        insertBtn.setBounds(350/2-40,180,80,25);
        panel.add(insertBtn);
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student stu = new Student(nameText.getText(),idText.getText(),
                        ageField.getText(),sexField.getText(),majorField.getText());
                if(stu.change()){
                    Dialog  dialog = new Dialog("修改成功",1);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null); // 居中显示
                    dialog.setVisible(true);
                    close();
                }else{
                    Dialog  dialog = new Dialog("修改失败",1);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null); // 居中显示
                    dialog.setVisible(true);
                }
            }
        });
    }

    @Override
    public void close() {dispose();    }
}