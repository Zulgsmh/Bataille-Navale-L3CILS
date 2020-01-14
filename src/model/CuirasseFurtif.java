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

	/**
     * 
     */
    private int taille;


}
