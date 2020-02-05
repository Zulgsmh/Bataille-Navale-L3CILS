package view.plateau;

import javax.swing.*;
import java.awt.*;

public class Bateau extends JButton {
    private final String equipe;
    private final Boolean sens;

    Bateau(String equipe, Boolean sens){
        this.equipe = equipe;
        this.sens = sens;
        this.setPreferredSize(new Dimension(600,40));
    }

    public String getEquipe(){ return this.equipe; }
    public Boolean getSens(){ return this.sens; }


}