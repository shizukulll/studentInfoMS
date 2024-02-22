package ui;

import bean.Student;
import ui.factory.UIFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deletePanel extends UIFrame {
//    JFrame frame = new JFrame("delete");

    JPanel panel= new JPanel();
    public deletePanel(){
        setTitle("delete");
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
        JLabel nameLab = new JLabel("id");
        nameLab.setBounds(10,20,80,25);
        panel.add(nameLab);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100,20,165,25);
        panel.add(nameText);


        JButton insertBtn = new JButton("删除");
        insertBtn.setBounds(350/2-40,180,80,25);
        panel.add(insertBtn);
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student stu = new Student("null",nameText.getText());
                if(stu.delete()){
                    Dialog  dialog = new Dialog("删除成功",1);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                    close();
                }else{
                    Dialog  dialog = new Dialog("删除失败",1);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            }
        });
    }

    @Override
    public void close() {dispose();}
}


