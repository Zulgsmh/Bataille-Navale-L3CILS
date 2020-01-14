package model;

import java.util.*;

/**
 * 
 */
public class Position {

    /**
     * Default constructor
     */
    public Position(int posX,int posY, String sens) {
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

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	/**
     * 
     */
    private int posX;

    /**
     * 
     */
    private int posY;

    /**
     * 
     */
    private String sens;


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