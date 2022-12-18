package practice.designpatterns.observer.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {
    private JFrame frame;
    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go(){
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public class AngelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it. You might regret it later!");
        }
    }

    public class DevilListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on, just do it!");
        }
    }
}
