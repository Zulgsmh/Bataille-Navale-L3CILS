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
    public Partie(Joueur j1, Joueur j2) {
    	this.j1 = j1;
    	this.j2 = j2;
    }

    /**
     * 
     */
    public int idPartie;

    /**
     * 
     */
    public ModeJeu ModeJ;
    
    public Joueur j1;
    public Joueur j2;


    /**
     * 
     */
    public void startBataille() {
        // TODO implement here
    }

    /**
     * 
     */
    public void placerBateauJ1() {
        // TODO implement here
    	System.out.println("Placement des bateau de j1");
    	this.j1.placerBateau();
    	

    }
    public void placerBateauJ2() {
        // TODO implement here
    	System.out.println("Placement des bateau de j2");
    	this.j2.placerBateau();
    	
    }
    /**
     * 
     */
    
    
    public void J1tirer() {
    	
        // TODO implement here
        System.out.println("\n\n\nTour de J1 :");
    	   Scanner in = new Scanner(System.in);
    	   System.out.print("ou veux-tu tirer en x : ");
           int x = in.nextInt();
    	   System.out.print("ou veux-tu tirer en y : ");
           int y = in.nextInt();
           this.j2.getShot(x,y);
           if(this.j2.getDejaCible()) {
        	   this.j2.setDejaCible(false);
        	   System.out.println("Tu as déja tiré ici mon khey !");
        	   this.J1tirer();
           }
           this.j1.setGrilleAdverse(this.j2.maGrille);
           this.j1.displayGrilleAdverse();
           this.j1.displayMaGrille();
    }
    public void J2tirer() {
    	
        // TODO implement here
        System.out.println("\n\n\n Tour de J2 :");
    	   Scanner in = new Scanner(System.in);
    	   System.out.print("ou veux-tu tirer en x : ");
           String sx = in.nextLine();
    	   System.out.print("ou veux-tu tirer en y : ");
           String sy = in.nextLine();
           int x = Integer.parseInt(sx);
           int y = Integer.parseInt(sy);
        this.j1.getShot(x,y);
        if(this.j1.getDejaCible()) {
        	this.j1.setDejaCible(false);
     	    System.out.println("Tu as déja tiré ici mon khey !");
        	this.J2tirer();
        }
        this.j2.setGrilleAdverse(this.j1.maGrille);
        this.j2.displayGrilleAdverse();
        this.j2.displayMaGrille();
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