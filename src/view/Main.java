package view;
import controller.BatailleController;
import model.*;

public class Main {

    public static void main(String[] args) {
        Gui t1 = new Gui();
        t1.setLocationRelativeTo(null); //centre au milieu de l'ecran
        t1.setVisible(true);
        Partie p = new Partie();
        Affichage a = new Affichage();
        BatailleController c = new BatailleController(a, p);
        a.setVisible(true);
        //bonjour
    }

}
