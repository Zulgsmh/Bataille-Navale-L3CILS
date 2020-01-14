package model;

/**
 * 
 */
public class SousMarinNucleaire extends Navire {

    /**
     * Default constructor
     */
    public SousMarinNucleaire() {
    	this.setTaille(4);
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
    private int taille;


}
