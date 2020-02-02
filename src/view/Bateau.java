package view;

import javax.swing.*;
import java.awt.*;

public class Bateau extends JButton {
    private String equipe;
    private Boolean sens;

    Bateau(String equipe, Boolean sens){
        this.equipe = equipe;
        this.sens = sens;
        this.setPreferredSize(new Dimension(150,40));
    }

    public String getEquipe(){ return this.equipe; }
    public Boolean getSens(){ return this.sens; }


}