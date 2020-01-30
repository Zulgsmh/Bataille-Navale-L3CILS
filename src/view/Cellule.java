package view;
import java.awt.*;
import javax.swing.*;


public class Cellule extends JPanel {
    Color violet = new Color(110,74,227);
    Color violetF = new Color(42,0,51);

    private int x,y;
    private String nom = "";
    private String appartient;
    Cellule(int x, int y, String appart){
        this.x = x;
        this.y = y;
        this.appartient = appart;
        this.setBackground(violet);

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