package model;

/**
 * 
 */
public class Position {

    /**
     * Default constructor
     */
    public Position(int posX,int posY, boolean sens) {
    	this.posX=posX;
    	this.posY=posY;
    	this.sens=sens;
    }

    public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean getSens() {
		return sens;
	}

	public void setSens(boolean sens) {
		this.sens = sens;
	}

	/**
     * 
     */
    private int posX = -1;

    /**
     * 
     */
    private int posY = -1;

    /**
     * 
     */
    private boolean sens = true;


    /**
     *
     */
    public void flipToHoriztontal() {
        // TODO implement here
    }

    /**
     * 
     */
    public void flipToVertical() {
        // TODO implement here
    }

}