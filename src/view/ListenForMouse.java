package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenForMouse implements MouseListener {

    // Called when a mouse button is clicked

    public void mouseClicked(MouseEvent e) {
        cellule parent = (cellule)e.getSource();
        System.out.println("Mouse Panel Pos: " + e.getX() + " " + e.getY() + "\n");

        //System.out.println("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
        System.out.println(parent.getx() + " " + parent.gety());
        System.out.println("Mouse Button: " + e.getButton()  + "\n");
        if (parent.getAppartient().equals("j1")){
            System.out.println("Grille1");
        }else{
            System.out.println("Grille2");
        }

        System.out.println("Mouse Clicks: " + e.getClickCount()  + "\n");

    }

    // Called when the mouse enters the component assigned

    // the MouseListener

    public void mouseEntered(MouseEvent e) {
        JPanel parent = (JPanel)e.getSource();
        if (parent.getBackground().equals(Color.green)) {
            parent.setBackground(Color.RED);
        }
        //parent.revalidate();
    }
    // Called when the mouse leaves the component assigned
    // the MouseListener

    public void mouseExited(MouseEvent e) {
        JPanel parent = (JPanel)e.getSource();
        if (parent.getBackground().equals(Color.RED)) {
            parent.setBackground(Color.green);
        }
    }
    // Mouse button pressed
    public void mousePressed(MouseEvent arg0) {
    }
    // Mouse button released
    public void mouseReleased(MouseEvent arg0) {

    }
}
