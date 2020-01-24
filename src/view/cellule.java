package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class cellule extends JPanel {
    private int x,y;
    private String nom = "";
    private String appartient;
    cellule(int x, int y, String appart){
        this.x = x;
        this.y = y;
        this.appartient = appart;
        this.setBackground(Color.green);

    }

    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }

    public String getAppartient() {
        return appartient;
    }
}
