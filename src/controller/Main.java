package controller;
import view.*;
import model.*;
public class Main {
    public static void main(String[] args) {
        Partie p = new Partie();
        Affichage a = new Affichage();
        BatailleController c = new BatailleController(a, p);
        a.setVisible(true);
    }
}
