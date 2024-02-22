import Observer.ConsoleObserver;
import Observer.MySubject;

import javax.swing.*;

import static ui.login.CreatGUI;

public class Main {
    public static void main(String[] args) {
        ConsoleObserver observer = new ConsoleObserver();
        MySubject mySubject = MySubject.getInstance();
        mySubject.registerObserver(observer);
        mySubject.notifyObservers("进入main方法，被观察者使用单例模式，可以在多个场景页面被使用，观察者会打印所有操作到控制台");

        //最丑的默认
//        try {
//            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }

        //还可以，说是系统默认风格
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //win风格，和上面系统默认没区别
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //紫色太骚
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreatGUI();
            }
        });
    }
}