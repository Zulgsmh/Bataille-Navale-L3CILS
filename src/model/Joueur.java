package model;

import java.util.*;

/**
 * 
 */
public class Joueur {

    /**
     * Default constructor
     */
    public Joueur() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    public String [][]maGrille = new String [10][10];

    /**
     * 
     */
    public String [][]grilleAdverse = new String [10][10];






    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String[][] getMaGrille() {
		return maGrille;
	}

	public void setMaGrille(String[][] maGrille) {
		this.maGrille = maGrille;
	}

	public String[][] getGrilleAdverse() {
		return grilleAdverse;
	}

	public void setGrilleAdverse(String[][] grilleAdverse) {
		this.grilleAdverse = grilleAdverse;
	}

	/**
     * 
     */
    public void couler() {
        // TODO implement here
    }

    /**
     * 
     */
    public void tirer() {
    	
        // TODO implement here
    	   Scanner in = new Scanner(System.in);
    	   System.out.print("Où veux-tu tirer en x : ");
           String s = in.nextLine();
           
           System.out.println("You entered string "+s);
    }
    
    public void displayMaGrille() {
    	System.out.println("\n\n MaGrille : ");
    	for(int j=0; j<10 ; j++) {
    		for(int i=0; i<10 ; i++ ) {
    			String maCase = " " + this.maGrille[i][j] + " ";
    			System.out.print(maCase);
    		}
    			System.out.println("");
    	}
    }
    public void displayGrilleAdverse() {
    	System.out.println("\n\n Grille Adverse : ");
    	for(int j=0; j<10 ; j++) {
    		for(int i=0; i<10 ; i++ ) {
    			String maCase = " " + this.grilleAdverse[i][j] + " ";
    			System.out.print(maCase);
    		}
    			System.out.println("");
    	}

    }
}