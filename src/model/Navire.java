package model;

import java.util.*;

/**
 * 
 */
public abstract class Navire {

    /**
     * Default constructor
     */
    public Navire() {
    }

    private int vie;
   

	/**
     * 
     */
    private int id;

    /**
     * 
     */
    private Position position;

    /**
     * 
     */
    private Boolean estTouche;

    /**
     * 
     */
    private Boolean estCoule;
    private String nom;
    public int taille;
    public Boolean utilisable;


//---------------ACCESSEURS-------------------------
    
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getNom() {
    	return nom;
    }
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Boolean getEstTouche() {
		return estTouche;
	}

	public void setEstTouche(Boolean estTouche) {
		this.estTouche = estTouche;
		this.vie --;
		if(this.vie==0) {
			this.getEstCoule();
			System.out.println("bateau coule");
		}
	}
	
	public void setVie(int v) {
    	this.vie = v;
	}
	public int getVie() {
		return this.vie;
	}

	public Boolean getEstCoule() {
		return estCoule;
	}

	public void setEstCoule(Boolean estCoule) {
		this.estCoule = estCoule;	
	}
	
    public int getTaille() {
		return taille;
	}
   

}