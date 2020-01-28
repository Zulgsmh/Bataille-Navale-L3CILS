package view;
import javax.swing.*;
import java.awt.*;

public class Cellule extends JPanel {
    private int x,y;
    private String nom = "";
    private String appartient;
    Cellule(int x, int y, String appart){
        this.x = x;
        this.y = y;
        this.appartient = appart;
        this.setBackground(Color.CYAN);

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
    public void setColor(Color color){
        this.setBackground(color);
    }
    public void setNom(String nom){
        this.nom = nom;
    }
}
