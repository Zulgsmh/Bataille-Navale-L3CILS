package controller;

import model.Partie;
import view.Menu1;
import view.Menu2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu1Controller {
    private Partie p;
    private Menu1 m;

    public Menu1Controller(Partie p, Menu1 m){
        this.p = p;
        this.m = m;
        this.m.addButtonMenu1Listener(new menu1Listener());

        this.m.setVisible(true);
        this.m.setLocationRelativeTo(null);


    }

    public class menu1Listener implements MouseListener {


        public void mouseClicked(MouseEvent e) {
            Menu2 m1 = new Menu2();
            m1.setVisible(true);
            JButton parent = (JButton)e.getSource();
            System.out.println("test");

        }

        public void mousePressed(MouseEvent e) {
            JButton parent = (JButton)e.getSource();
            System.out.println(parent.getText());
            System.out.println("test1");

        }

        public void mouseReleased(MouseEvent e) {
            JButton parent = (JButton)e.getSource();
            System.out.println(parent.getText());
            System.out.println("test2");

        }

        public void mouseEntered(MouseEvent e) {
            JButton parent = (JButton)e.getSource();
            System.out.println(parent.getText());
            System.out.println("test3");



        }

        public void mouseExited(MouseEvent e) {
            JButton parent = (JButton)e.getSource();
            System.out.println(parent.getText());
            System.out.println("test4");

           if(parent.getText().equals("xButton")){
               parent.setBackground(Color.black);
               parent.setForeground(Color.white);
           }
//

        }
    }

}







