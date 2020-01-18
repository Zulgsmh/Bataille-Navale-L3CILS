package model;

/**
 * 
 */
public class Zodiac extends Navire {

    /**
     * Default constructor
     */
    public Zodiac() {
    	this.setTaille(2);
    }

    public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
     * 
     */
    public int taille;
    public String nom = "ZODI";
    public String getNom() {
    	return this.nom;
    }

}
