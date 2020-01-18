package model;

/**
 * 
 */
public class CuirasseFurtif extends Navire {

    /**
     * Default constructor
     */
    public CuirasseFurtif() {
    	this.setTaille(3);
    }

    public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
     * 
     */
    public int taille;
    public String nom = "CUIR";
    public String getNom() {
    	return this.nom;
    }
}
