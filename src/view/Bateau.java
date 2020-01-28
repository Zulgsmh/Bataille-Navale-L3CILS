package view;

import javax.swing.*;

public class Bateau extends JButton {
    private String equipe;
    private Boolean sens;
    Bateau(String equipe, Boolean sens){
        this.equipe = equipe;
        this.sens = sens;

    }

    public String getEquipe(){ return this.equipe; }
    public Boolean getSens(){ return this.sens; }
}
