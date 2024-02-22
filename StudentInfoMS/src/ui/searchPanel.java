package ui;

import bean.Student;
import ui.factory.UIFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchPanel extends UIFrame {
//    JFrame frame = new JFrame("search");

    JPanel panel= new JPanel();
    public searchPanel(){
        setTitle("search");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        panel.setLayout(null);
        setContentPane(panel);
        setupUI();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setupUI() {
        JLabel nameLab = new JLabel("name");
        nameLab.setBounds(10,20,80,25);
        panel.add(nameLab);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100,20,165,25);
        panel.add(nameText);//ljy

        JTextArea resultTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setBounds(10, 60, 280, 100);
        panel.add(scrollPane);

        JButton insertBtn = new JButton("查询");
        insertBtn.setBounds(350/2-40,180,80,25);
        panel.add(insertBtn);
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student stu = new Student(nameText.getText(),"null");
                Student[] searchResult = stu.search();
                if(searchResult.length > 0){
                    StringBuilder sb = new StringBuilder();
                    for(Student student : searchResult){
                        sb.append(student.toString()).append("\n");
                    }
                    resultTextArea.setText(sb.toString());
                    Dialog dialog = new Dialog("查询成功", 1);
                    dialog.pack();//ljy
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }else{
                    resultTextArea.setText("");
                    Dialog dialog = new Dialog("未找到匹配记录", 1);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            }
        });
    }

    @Override
    public void close() { dispose();    }
}
