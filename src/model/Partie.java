package model;
import java.util.*;

import model.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
	public Boolean touche;
	private Boolean typeNormal=false;
	private Boolean typeRadar=false;
	private Boolean typeArti=false;
	private Boolean typeAR=false;
	private String[] direction ={"E","O","N","S"};
	private int x1,y1,x2,y2;
	private int x,y;
	private int j1tire = 0;
	private int j2tire = 0;




	/**
	 * 
	 */
	public void setTypeNormal(Boolean b){
		this.typeNormal=b;
	}
	public boolean getTypeNormal(){
		return typeNormal;
	}
	public void setTypeRadar(boolean b){
		this.typeRadar=b;
	}
	public boolean getTypeRadar(){
		return typeRadar;
	}
	public void setTypeArti(boolean b){
		this.typeArti=b;
	}
	public boolean getTypeArti(){
		return typeArti;
	}
	public void setTypeAR(boolean b){
		this.typeAR=b;
	}
	public boolean getTypeAR(){
		return typeAR;
	}
	public int getJ1tire(){return j1tire;}
	public int getJ2tire(){return j2tire;}
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
		System.out.println("Quelle type de jeux voulez-vous: " +
				"\n1)Normal " +
				"\n2)Radar  " +
				"\n3)Artiellerie"+
				"\n4)Mode Alerte Rouge");
		Scanner on = new Scanner(System.in);
		String sy = on.nextLine();
		int y = Integer.parseInt(sy);
		if(y==1) {
			this.setTypeNormal(true);
		}
		else if(y==2) {
			this.setTypeRadar(true);
		}
		else if(y==3){
			this.setTypeArti(true);
		}
		else if(y==4){
			this.setTypeAR(true);
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
		j1tire++;
		if(j1.getEstOrdi()){
			System.out.println("j1 joue !");
			if(!j2.getaTouche()) {
				int x = new Random().nextInt(10) + 1;
				int y = new Random().nextInt(10) + 1;
				System.out.println(j2.getMaGrille()[x-1][y-1]);
				while(true) {
					x = new Random().nextInt(10) + 1;
					y = new Random().nextInt(10) + 1;
					if(j2.getMaGrille()[x-1][y-1]==null){break;}
					if(!j2.getMaGrille()[x-1][y-1].equals("PLOF")&&!j2.getMaGrille()[x-1][y-1].equals("SHOT")){break;}
				}
				j2.setx1(x);
				j2.sety1(y);
				System.out.println("aléa généré x:"+x+" y : "+y);
				Boolean[] result = this.j2.getShot(x, y);
				mort = result[0];
				touche = result[1];
			}else{
				j2.setCompteur(j2.getCompteur()+1);
				System.out.println("Je veux coulé ce bateau de ses morts x:"+j2.getx1()+" y : "+j2.gety1());
				System.out.println("right :"+j2.getRight());
				System.out.println("left :"+j2.getLeft());
				System.out.println("up :"+j2.getUp());
				System.out.println("down :"+j2.getDown());
				System.out.println("atouche :"+j2.getaTouche());
				if(j2.getRight()){
					if(j2.getx1()+j2.getCompteur()>0 && j2.getx1()+j2.getCompteur()<11) {
						Boolean[] result = this.j2.getShot(j2.getx1() + j2.getCompteur(), j2.gety1());
						mort = result[0];
						touche = result[1];
					}else {
						j2.setCompteur(0);
						j2.setRight(false);
						j2.setLeft(true);
					}
				}else if(j2.getLeft()){
					if(j2.getx1()-j2.getCompteur()>0 && j2.getx1()-j2.getCompteur()<11) {
					Boolean[] result = this.j2.getShot(j2.getx1()-j2.getCompteur(), j2.gety1());
					mort = result[0];
					touche = result[1];
					}else{
						j2.setCompteur(0);
						j2.setLeft(false);
						j2.setUp(true);
					}
				}else if(j2.getUp()){
					System.out.println("DANS UP");
					if(j2.gety1()+j2.getCompteur()>0 && j2.gety1()+j2.getCompteur()<11) {
						Boolean[] result = this.j2.getShot(j2.getx1(), j2.gety1()+j2.getCompteur());
						mort = result[0];
						touche = result[1];
					}else{
						j2.setCompteur(0);
						j2.setUp(false);
						j2.setDown(true);
					}
				}else if(j2.getDown()){
					if(j2.gety1()-j2.getCompteur()>0 && j2.gety1()-j2.getCompteur()<11) {
						Boolean[] result = this.j2.getShot(j2.getx1(), j2.gety1()-j2.getCompteur());
						mort = result[0];
						touche = result[1];
					}else{
						j2.setCompteur(0);
						j2.setDown(false);
						j2.setaTouche(false);
					}
				}
			}
			this.j1.setGrilleAdverse(this.j2.maGrille);
			this.j1.displayGrilleAdverse();
			this.j1.displayMaGrille();
			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}

		// TODO implement here
		else if (!j1.getEstOrdi()){
			System.out.println("\n\n\nTour de J1 :");
			Scanner in = new Scanner(System.in);
			System.out.print("ou veux-tu tirer en x : ");
			int x = in.nextInt();
			System.out.print("ou veux-tu tirer en y : ");
			int y = in.nextInt();
			Boolean[] result = this.j2.getShot(x,y);
			mort = result[0];
			touche= result[1];
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
		j2tire++;
		if(j2.getEstOrdi()){
			System.out.println("j1 joue !");
			if(!j1.getaTouche()) {
				int x = new Random().nextInt(10) + 1;
				int y = new Random().nextInt(10) + 1;
				System.out.println(j1.getMaGrille()[x-1][y-1]);
				while(true) {
					x = new Random().nextInt(10) + 1;
					y = new Random().nextInt(10) + 1;
					if(j1.getMaGrille()[x-1][y-1]==null){break;}
					if(!j1.getMaGrille()[x-1][y-1].equals("PLOF")&&!j1.getMaGrille()[x-1][y-1].equals("SHOT")){break;}
				}
				j1.setx1(x);
				j1.sety1(y);
				System.out.println("aléa généré x:"+x+" y : "+y);
				Boolean[] result = this.j1.getShot(x, y);
				mort = result[0];
				touche = result[1];
			}else{
				j1.setCompteur(j1.getCompteur()+1);
				System.out.println("Je veux coulé ce bateau de ses morts x:"+j1.getx1()+" y : "+j1.gety1());
				System.out.println("right :"+j1.getRight());
				System.out.println("left :"+j1.getLeft());
				System.out.println("up :"+j1.getUp());
				System.out.println("down :"+j1.getDown());
				System.out.println("atouche :"+j1.getaTouche());
				if(j1.getRight()){
					if(j1.getx1()+j1.getCompteur()>0 && j1.getx1()+j1.getCompteur()<11) {
						Boolean[] result = this.j1.getShot(j1.getx1() + j1.getCompteur(), j1.gety1());
						mort = result[0];
						touche = result[1];
					}else {
						j1.setCompteur(0);
						j1.setRight(false);
						j1.setLeft(true);
					}
				}else if(j1.getLeft()){
					if(j1.getx1()-j1.getCompteur()>0 && j1.getx1()-j1.getCompteur()<11) {
						Boolean[] result = this.j1.getShot(j1.getx1()-j1.getCompteur(), j1.gety1());
						mort = result[0];
						touche = result[1];
					}else{
						j1.setCompteur(0);
						j1.setLeft(false);
						j1.setUp(true);
					}
				}else if(j1.getUp()){
					System.out.println("DANS UP");
					if(j1.gety1()+j1.getCompteur()>0 && j1.gety1()+j1.getCompteur()<11) {
						Boolean[] result = this.j1.getShot(j1.getx1(), j1.gety1()+j1.getCompteur());
						mort = result[0];
						touche = result[1];
					}else{
						j1.setCompteur(0);
						j1.setUp(false);
						j1.setDown(true);
					}
				}else if(j1.getDown()){
					if(j1.gety1()-j1.getCompteur()>0 && j1.gety1()-j1.getCompteur()<11) {
						Boolean[] result = this.j1.getShot(j1.getx1(), j1.gety1()-j1.getCompteur());
						mort = result[0];
						touche = result[1];
					}else{
						j1.setCompteur(0);
						j1.setDown(false);
						j1.setaTouche(false);
					}
				}
			}
			this.j2.setGrilleAdverse(this.j1.maGrille);
			this.j2.displayGrilleAdverse();
			this.j2.displayMaGrille();
			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
//		if(j2.getEstOrdi()){
//			System.out.println("J2 joue !");
//			int x;
//			int y;
//			while(true) {
//				x = new Random().nextInt(10) + 1;
//				y = new Random().nextInt(10) + 1;
//				if (j1.getMaGrille()[x - 1][y - 1] == null) {
//					break;
//				}
//				if (!j1.getMaGrille()[x - 1][y - 1].equals("PLOF") && !j1.getMaGrille()[x - 1][y - 1].equals("SHOT")) {
//					break;
//				}
//			}
//			Boolean[] result = this.j1.getShot(x,y);
//			mort = result[0];
//			touche= result[1];
////			if (this.j1.getDejaCible()) {
////				this.j1.setDejaCible(false);
////				//System.out.println("Tu as deja tire ici mon khey !");
////				this.J2tirer();
////			}
//			this.j2.setGrilleAdverse(this.j1.maGrille);
////			this.j2.displayGrilleAdverse();
////			this.j2.displayMaGrille();
//			try
//			{
//				Thread.sleep(10);
//			}
//			catch(InterruptedException ex)
//			{
//				Thread.currentThread().interrupt();
//			}
//		}
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
			Boolean[] result = this.j1.getShot(x,y);
			mort = result[0];
			touche= result[1];
			if (this.j1.getDejaCible()) {
				this.j1.setDejaCible(false);
				System.out.println("Tu as d�ja tir� ici mon khey !");
				this.J2tirer();
			}
			this.j2.setGrilleAdverse(this.j1.maGrille);
//			this.j2.displayGrilleAdverse();
//			this.j2.displayMaGrille();
		}

		return this.mort;


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