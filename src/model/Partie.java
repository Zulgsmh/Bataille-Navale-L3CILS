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
	public Partie() {
	}

	/**
	 * 
	 */
	public int idPartie;

	/**
	 * 
	 */
	public String ModeJ;

	public Joueur j1 = new Joueur();
	public Joueur j2 = new Joueur();
	public int nbBateau=0;
	public Boolean mort;


	/**
	 * 
	 */
	public void startBataille() {
		System.out.println("Quelle mode voulez-vous: \n1)Joueur1 VS Joueur2  \n2)Joueur1 VS Ordinateur  \n3)Demo");
		Scanner in = new Scanner(System.in);
		String sx = in.nextLine();
		int x = Integer.parseInt(sx);
		if(x==2) {	
			j2.setEstOrdi(true);
		}
		else if(x==3) {
			j1.setEstOrdi(true);
			j2.setEstOrdi(true);
		}
		System.out.println("COMBIEN DE BATEAU?");
		this.nbBateau = in.nextInt();
		// TODO implement here
	}

	/**
	 * 
	 */
	public void placerBateauJ1() {
		// TODO implement here
		System.out.println("Placement des bateau de j1");
		this.j1.placerBateau(this.nbBateau);

	}

	public void placerBateauJ2() {
		// TODO implement here
		System.out.println("Placement des bateau de j2");
		this.j2.placerBateau(this.nbBateau);

	}

	/**
	 * 
	 */

	public Boolean J1tirer() {

		if(j1.getEstOrdi()){
			int x=new Random().nextInt(10)+1;
			int y = new Random().nextInt(10)+1;
			mort = this.j2.getShot(x, y);
			if (this.j2.getDejaCible()) {
				this.j2.setDejaCible(false);
				System.out.println("Tu as d�ja tir� ici mon khey !");
				this.J1tirer();
			}
			this.j1.setGrilleAdverse(this.j1.maGrille);
			this.j1.displayGrilleAdverse();
			this.j1.displayMaGrille();

		}

		// TODO implement here
		else if (!j1.getEstOrdi()){
			System.out.println("\n\n\nTour de J1 :");
			Scanner in = new Scanner(System.in);
			System.out.print("ou veux-tu tirer en x : ");
			int x = in.nextInt();
			System.out.print("ou veux-tu tirer en y : ");
			int y = in.nextInt();
			mort = this.j2.getShot(x, y);
			if (this.j2.getDejaCible()) {
				this.j2.setDejaCible(false);
				System.out.println("Tu as d�ja tir� ici mon khey !");
				this.J1tirer();
			}
			this.j1.setGrilleAdverse(this.j2.maGrille);
			this.j1.displayGrilleAdverse();
			this.j1.displayMaGrille();
		}
		return mort;
	}

	public Boolean J2tirer() {


		if(j2.getEstOrdi()){
			int x=new Random().nextInt(10)+1;
			int y = new Random().nextInt(10)+1;
			mort = this.j1.getShot(x, y);
			if (this.j1.getDejaCible()) {
				this.j1.setDejaCible(false);
				System.out.println("Tu as deja tire ici mon khey !");
				this.J2tirer();
			}
			this.j2.setGrilleAdverse(this.j1.maGrille);
			this.j2.displayGrilleAdverse();
			this.j2.displayMaGrille();
		}
		// TODO implement here
		else if(!j2.getEstOrdi()) {
			System.out.println("\n\n\n Tour de J2 :");
			Scanner in = new Scanner(System.in);
			System.out.print("ou veux-tu tirer en x : ");
			String sx = in.nextLine();
			System.out.print("ou veux-tu tirer en y : ");
			String sy = in.nextLine();
			int x = Integer.parseInt(sx);
			int y = Integer.parseInt(sy);
			mort = this.j1.getShot(x, y);
			if (this.j1.getDejaCible()) {
				this.j1.setDejaCible(false);
				System.out.println("Tu as d�ja tir� ici mon khey !");
				this.J2tirer();
			}
			this.j2.setGrilleAdverse(this.j1.maGrille);
			this.j2.displayGrilleAdverse();
			this.j2.displayMaGrille();
		}

		return this.mort;


	}
	
	public Boolean O1tirer() {

		// TODO implement here
		int x=new Random().nextInt(10);
		int y = new Random().nextInt(10);
		Boolean mort = this.j1.getShot(x, y);
		if (this.j1.getDejaCible()) {
			this.j1.setDejaCible(false);
			System.out.println("Tu as d�ja tir� ici mon khey !");
			this.J2tirer();
		}
		this.j2.setGrilleAdverse(this.j1.maGrille);
		this.j2.displayGrilleAdverse();
		this.j2.displayMaGrille();

		return mort;
	}

	public Boolean O2tirer() {

		// TODO implement here
		int x=new Random().nextInt(10);
		int y = new Random().nextInt(10);
		Boolean mort = this.j1.getShot(x, y);
		if (this.j1.getDejaCible()) {
			this.j1.setDejaCible(false);
			System.out.println("Tu as d�ja tir� ici mon khey !");
			this.J2tirer();
		}
		this.j2.setGrilleAdverse(this.j1.maGrille);
		this.j2.displayGrilleAdverse();
		this.j2.displayMaGrille();

		return mort;
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