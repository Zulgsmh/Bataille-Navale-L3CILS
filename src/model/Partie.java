package model;
import model.*;
import java.util.*;

/**
 * 
 */
public class Partie {

    /**
     * Default constructor
     */
    public Partie() {
    }

    /**
     * 
     */
    public int idPartie;

    /**
     * 
     */
    public ModeJeu ModeJ;



    /**
     * 
     */
    public void startBataille() {
        // TODO implement here
    }

    /**
     * 
     */
    public void placerBateauJ1(Joueur j1) {
        // TODO implement here
 	   Scanner in = new Scanner(System.in);
 	   System.out.println("COMBIEN DE BATEAU?");
   	   int nbbateau = in.nextInt();
   	   for (int nb = 0; nb < nbbateau; nb++) {
 	   System.out.print("quel bateau : \n 1)portes avion \n 2)sous-marin \n 3)cuirassé \n 4)zodiac\n");
        int typebateau = in.nextInt();
   	   System.out.print("pos x :");
        int x = in.nextInt()-1;
   	   System.out.print("pos y :");
        int y = in.nextInt()-1;
   	   System.out.print("dir : \n 1)verticale \n 2)horizontale\n");
        int dir = in.nextInt();
        boolean verticale = true;
        if(dir == 1) {
        	verticale = true;
        }else {
        	verticale = false;
        }
        if(typebateau == 1) {
        	j1.p1.utilisable = false;
        	int t = j1.p1.getTaille();
        	if(verticale) {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x, y+i, "PUTE");
        		}
        	}else {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x+i, y, "PUTE");
        		}
        	}
        }else if(typebateau == 2) {
        	j1.s1.utilisable = false;
        	int t = j1.s1.getTaille();
        	if(verticale) {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x, y+i, "SOUS");
        		}
        	}else {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x+i, y, "SOUS");
        		}
        	}
        }else if(typebateau == 3) {
        	j1.c1.utilisable = false;
        	int t = j1.c1.getTaille();
        	if(verticale) {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x, y+i, "CUIR");
        		}
        	}else {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x+i, y, "CUIR");
        		}
        	}
        }else if(typebateau == 4) {
        	j1.z1.utilisable = false;
        	int t = j1.z1.getTaille();
        	if(verticale) {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x, y+i, "ZODI");
        		}
        	}else {
        		for(int i = 0; i < t; i++) {
        			j1.setMaGrille(x+i, y, "ZODI");
        		}
        	}
        }
        j1.displayMaGrille();
   	   }
    }

    /**
     * 
     */
    public void placerBateauJ2() {
        // TODO implement here
    }

    /**
     * 
     */
    public void swapJoueur() {
        // TODO implement here
    }

    /**
     * 
     */
    public void stopBataille() {
        // TODO implement here
    }

}