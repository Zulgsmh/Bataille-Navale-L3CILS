package model;

/**
 * 
 */
public class PorteAvion extends Navire {

    /**
     * Default constructor
     */
    public PorteAvion() {
        this.setTaille(5);
        this.setVie(5);
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

    public String getNom() {
        String nom = "PORT";
        return nom;
    }

}
