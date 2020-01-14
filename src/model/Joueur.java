package model;

import java.util.*;

/**
 * 
 */
public class Joueur {

	/**
	 * Default constructor
	 */
	public Joueur() {
	}

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private String nom;

	/**
	 * 
	 */
	public String[][] maGrille = new String[10][10];

	/**
	 * 
	 */
	public String[][] grilleAdverse = new String[10][10];

	public PorteAvion p1 = new PorteAvion();
	public CuirasseFurtif c1 = new CuirasseFurtif();
	public CuirasseFurtif c2 = new CuirasseFurtif();
	public SousMarinNucleaire s1 = new SousMarinNucleaire();
	public Zodiac z1 = new Zodiac();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String[][] getMaGrille() {
		return maGrille;
	}

	public void setMaGrille(String[][] maGrille) {
		this.maGrille = maGrille;
	}

	public void setMaGrille(int x, int y, String truc) {
		this.maGrille[x][y] = truc;
	}

	public String[][] getGrilleAdverse() {
		return grilleAdverse;
	}

	public void setGrilleAdverse(String[][] grilleAdverse) {
		this.grilleAdverse = grilleAdverse;
	}

	public void setGrilleAdverse(int x, int y) {
		// DOTO : mettre condition de tire
		this.grilleAdverse[x - 1][y - 1] = "POUF";
	}

	/**
	 * 
	 */
	public void couler() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void placerbateau() {
		Scanner in = new Scanner(System.in);
		System.out.println("COMBIEN DE BATEAU?");
		int nbbateau = in.nextInt();
		int typebateau = 0;
		int x = 0;
		int y = 0;
		int taille = 0;
		boolean verticale = true;
		for (int nb = 0; nb < nbbateau; nb++) {
			boolean valid = false;
			while (!valid) {
				System.out.print("quel bateau : \n 1)portes avion \n 2)sous-marin \n 3)cuirassé \n 4)zodiac\n");
				typebateau = in.nextInt();
				System.out.print("pos x :");
				x = in.nextInt() - 1;
				System.out.print("pos y :");
				y = in.nextInt() - 1;
				System.out.print("dir : \n 1)verticale \n 2)horizontale\n");
				int dir = in.nextInt();
				verticale = true;
				if (dir == 1) {
					verticale = true;
				} else {
					verticale = false;
				}

				int taillebat = 6 - typebateau;
				if (verticale) {
					if (y + taillebat > 10) {
						valid = false;
						System.out.println("INVALIDE");
					} else {
						valid = true;
					}
				} else {
					if (x + taillebat > 10) {
						valid = false;
						System.out.println("INVALIDE");
					} else {
						valid = true;
					}
				}
			}
			if (typebateau == 1) {
				taille = this.p1.getTaille();
				this.remplissage(verticale, x, y, "PORT", taille);
			} else if (typebateau == 2) {
				taille = this.s1.getTaille();
				this.remplissage(verticale, x, y, "SOUS", taille);
			} else if (typebateau == 3) {
				taille = this.c1.getTaille();
				this.remplissage(verticale, x, y, "CUIR", taille);
			} else if (typebateau == 4) {
				taille = this.z1.getTaille();
				this.remplissage(verticale, x, y, "ZODI", taille);
			}
			this.displayMaGrille();
		}
	}

	public void remplissage(boolean verticale, int x, int y, String mot, int t) {
		this.p1.utilisable = false;
		if (verticale) {
			for (int i = 0; i < t; i++) {
				this.setMaGrille(x, y + i, mot);
			}
		} else {
			for (int i = 0; i < t; i++) {
				this.setMaGrille(x + i, y, mot);
			}
		}
	}

	public void displayMaGrille() {
		System.out.println("\n\n MaGrille : ");
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				String maCase = "";
				if (this.maGrille[i][j] != null) {
					maCase = " " + this.maGrille[i][j] + " ";
				} else {
					maCase = " ---- ";
				}
				System.out.print(maCase);
			}
			System.out.println("");
		}
	}

	public void displayGrilleAdverse() {
		System.out.println("\n\n Grille Adverse : ");
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				String maCase = " " + this.grilleAdverse[i][j] + " ";
				System.out.print(maCase);
			}
			System.out.println("");
		}

	}
}