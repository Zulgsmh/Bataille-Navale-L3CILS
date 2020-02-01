package view;

import controller.BatailleController;
import controller.Menu1Controller;
import model.Partie;

public class Main {

    public static void main(String[] args) {
        Menu1 t1 = new Menu1();
        Partie p = new Partie();
        Affichage a = new Affichage();
        Menu1Controller m = new Menu1Controller(p, t1);
       // BatailleController c = new BatailleController(a, p);
    }

}
