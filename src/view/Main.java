package view;

import controller.BatailleController;
import model.Partie;

public class Main {

    public static void main(String[] args) {
        Menu1 m1 = new Menu1();
        Partie p = new Partie();
        Affichage a = new Affichage(p);
        BatailleController c = new BatailleController(a, p);
        a.setVisible(true);
    }

}
