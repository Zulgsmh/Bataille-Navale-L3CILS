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
	public int nbBateau=1;
	public Boolean mort;
	public Boolean touche;
	private Boolean typeNormal=false;
	private Boolean typeRadar=false;
	private Boolean typeAR=false;
	private Boolean typeArti=false;
	private Boolean j1DoitPlacerBateau = true;
	private Boolean j1DoitTirer = false;
	private Boolean j2DoitPlacerBateau = false;
	private Boolean j2DoitTirer = false;



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
	public boolean J1doitplacerBat(){
		return j1DoitPlacerBateau;
	}
	public void setJ1doitplacerBat(Boolean bool){
		j1DoitPlacerBateau = bool;
	}
	public void setJ1DoitTirer(Boolean bool){
		j1DoitTirer = bool;
	}
	public void setJ2DoitTirer(Boolean bool){
		j2DoitTirer = bool;
	}
	public boolean J2doitplacerBat(){
		return j2DoitPlacerBateau;
	}
	public void setJ2doitplacetBat(Boolean bool){
		j2DoitPlacerBateau = bool;
	}

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
		this.j1.placerBateau(this.nbBateau,false);

	}


	public void placerBateauJ2() {
		// TODO implement here
		System.out.println("Placement des bateau de j2");
		this.j2.placerBateau(this.nbBateau,false);

	}

	public int getNbBateau(){return this.nbBateau ;}
	/**
	 *
	 */
	public Boolean getJ1DoitTirer(){
		return j1DoitTirer;
	}
	public Boolean getJ2DoitTirer(){
		return j2DoitTirer;
	}


	public Boolean J1tirer() {
		if(j1.getEstOrdi()){
			System.out.println("J1 joue !");
			int x=new Random().nextInt(10)+1;
			int y = new Random().nextInt(10)+1;
			Boolean[] result = this.j2.getShot(x, y, false);
			mort = result[0];
			touche = result[1];
			if (this.j2.getDejaCible()) {
				this.j2.setDejaCible(false);
				System.out.println("Tu as d�ja tir� ici mon khey !");
				this.J1tirer();
			}
			this.j1.setGrilleAdverse(this.j2.maGrille);
			this.j1.displayGrilleAdverse();
			this.j1.displayMaGrille();

			try
			{
				Thread.sleep(1000);
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
			Boolean[] result = this.j2.getShot(x, y, false);
			mort = result[0];
			touche = result[1];
			if (this.j2.getDejaCible()) {
				this.j2.setDejaCible(false);
				System.out.println("Tu as d�ja tir� ici mon khey !");
				this.J1tirer();
			}
			this.j1.setGrilleAdverse(this.j2.maGrille);
			this.j1.displayGrilleAdverse();
			this.j1.displayMaGrille();

			if (typeRadar) {
				int rad = 0;
				Boolean vue = false;
				String cellule = "rien";
				while (!vue){
					for (int k = 0; k < 10; k++) {
						for (int i = 0; i < 2 * k + 1; i++) {
							for (int j = 0; j < 2 * k + 1; j++) {
								if (x + i - k - 1 < 10 && x + i - k - 1 >= 0 && y + j - k - 1 < 10 && y + j - k - 1 >= 0) {
									cellule = j1.maGrille[x + i - k - 1][y + j - k - 1];
								}
								if (cellule != null) {
									if (cellule.equals("PORT")) {
										System.out.println(cellule);
										System.out.println("k :" + k);
										rad = k;
										vue = true;

										break;
									}
								}
							}
							if (vue){
								break;
							}
						}
						if (vue){
							break;
						}
					}
					System.out.println("distance=" + rad);
				}
			}
		}
		return mort;
	}

	public Boolean J2tirer() {


		if(j2.getEstOrdi()){
			System.out.println("J2 joue !");
			int x=new Random().nextInt(10)+1;
			int y = new Random().nextInt(10)+1;
			Boolean[] result = this.j2.getShot(x, y, false);
			mort = result[0];
			touche = result[1];
			if (this.j1.getDejaCible()) {
				this.j1.setDejaCible(false);
				System.out.println("Tu as deja tire ici mon khey !");
				this.J2tirer();
			}
			this.j2.setGrilleAdverse(this.j1.maGrille);
			this.j2.displayGrilleAdverse();
			this.j2.displayMaGrille();
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
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
			Boolean[] result = this.j2.getShot(x, y, false);
			mort = result[0];
			touche = result[1];
            if (this.j1.getDejaCible()) {
                this.j1.setDejaCible(false);
                System.out.println("Tu as d�ja tir� ici mon khey !");
                this.J2tirer();
            }
            this.j2.setGrilleAdverse(this.j1.maGrille);
            this.j2.displayGrilleAdverse();
            this.j2.displayMaGrille();
            System.out.println("bien taype radar: " + typeRadar);

            if (typeRadar) {
                int rad = 0;
                Boolean vue = false;
                String cellule = "rien";
                while (!vue) {
                    for (int k = 0; k < 10; k++) {
                        for (int i = 0; i < 2 * k + 1; i++) {
                            for (int j = 0; j < 2 * k + 1; j++) {
                                if (x + i - k - 1 < 10 && x + i - k - 1 >= 0 && y + j - k - 1 < 10 && y + j - k - 1 >= 0) {
                                    cellule = j1.maGrille[x + i - k - 1][y + j - k - 1];
                                }
                                if (cellule != null) {
                                    if (cellule.equals("PORT")) {
                                        System.out.println(cellule);
                                        System.out.println("k :" + k);
                                        rad = k;
                                        vue = true;

                                        break;
                                    }
                                }
                            }
                            if (vue) {
                                break;
                            }
                        }
                        if (vue) {
                            break;
                        }
                    }
                    System.out.println("distance=" + rad);
                }
            }
        }
		return this.mort;
	}

	public Boolean ordiMove(Joueur player){
			System.out.println("j1 joue !");
			if(!player.getaTouche()) {
				int x = new Random().nextInt(10) + 1;
				int y = new Random().nextInt(10) + 1;
				System.out.println(player.getMaGrille()[x-1][y-1]);
				while(true) {
					x = new Random().nextInt(10) + 1;
					y = new Random().nextInt(10) + 1;
					if(player.getMaGrille()[x-1][y-1]==null){break;}
					if(!player.getMaGrille()[x-1][y-1].equals("PLOF")&&!player.getMaGrille()[x-1][y-1].equals("SHOT")){break;}
				}
				player.setx1(x);
				player.sety1(y);
				System.out.println("aléa généré x:"+x+" y : "+y);
				Boolean[] result = player.getShot(x, y, false);
				mort = result[0];
				touche = result[1];
			}else{
				player.setCompteur(player.getCompteur()+1);
				System.out.println("Je veux coulé ce bateau de ses morts x:"+player.getx1()+" y : "+player.gety1());
				System.out.println("right :"+player.getRight());
				System.out.println("left :"+player.getLeft());
				System.out.println("up :"+player.getUp());
				System.out.println("down :"+player.getDown());
				System.out.println("atouche :"+player.getaTouche());
				if(player.getRight()){
					if(player.getx1()+player.getCompteur()>0 && player.getx1()+player.getCompteur()<11) {
						Boolean[] result = player.getShot(player.getx1() + player.getCompteur(), player.gety1(), false);
						mort = result[0];
						touche = result[1];
					}else {
						player.setCompteur(0);
						player.setRight(false);
						player.setLeft(true);
					}
				}else if(player.getLeft()){
					if(player.getx1()-player.getCompteur()>0 && player.getx1()-player.getCompteur()<11) {
						Boolean[] result = player.getShot(player.getx1()-player.getCompteur(), player.gety1(), false);
						mort = result[0];
						touche = result[1];
					}else{
						player.setCompteur(0);
						player.setLeft(false);
						player.setUp(true);
					}
				}else if(player.getUp()){
					System.out.println("DANS UP");
					if(player.gety1()+player.getCompteur()>0 && player.gety1()+player.getCompteur()<11) {
						Boolean[] result = player.getShot(player.getx1(), player.gety1()+player.getCompteur(), false);
						mort = result[0];
						touche = result[1];
					}else{
						player.setCompteur(0);
						player.setUp(false);
						player.setDown(true);
					}
				}else if(player.getDown()){
					if(player.gety1()-player.getCompteur()>0 && player.gety1()-player.getCompteur()<11) {
						Boolean[] result = player.getShot(player.getx1(), player.gety1()-player.getCompteur(), false);
						mort = result[0];
						touche = result[1];
					}else{
						player.setCompteur(0);
						player.setDown(false);
						player.setaTouche(false);
					}
				}
			}
			j1.setGrilleAdverse(player.maGrille);
//			j1.displayGrilleAdverse();
//			j1.displayMaGrille();
			return mort;
	}
	/**
	 *
	 */

	/**
	 *
	 */
	public void stopBataille() {
		// TODO implement here
	}

}