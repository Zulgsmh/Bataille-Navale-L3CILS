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
	public Navire[] listNavire = {p1, c1, c2, s1, z1}; 

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
	public void clearMagrille() {
		for (int row = 0; row < 10; row++) {
			   for (int col = 0; col < 10; col++) {
			      this.maGrille[row][col] = null;
			   }
			}
	}
	public String[][] getGrilleAdverse() {
		return grilleAdverse;
	}

	public void setGrilleAdverse(String[][] grilleAdverse) {
		this.grilleAdverse = grilleAdverse;
	}

	public void setGrilleAdverse(int x, int y) {
		// DOTO : mettre condition de tire
		this.grilleAdverse[x - 1][y - 1] = "PLOF";
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
				System.out.print("quel bateau : \n 1)portes avion \n 2)sous-marin \n 3)cuirassé1 \n 4)cuirassé2 \n 5)zodiac\n");
				typebateau = in.nextInt();
				System.out.print("pos x :");
				x = in.nextInt() - 1;
				System.out.print("pos y :");
				y = in.nextInt() - 1;
				System.out.print("dir : \n 1)verticale \n 2)horizontale\n");
				int dir = in.nextInt();
				if (dir == 1) {
					verticale = true;
				} else {
					verticale = false;
				}
				
				int taillebat = 0;
				switch(typebateau) {
					case 1:
						taillebat = 5;
						break;
					case 2:
						taillebat = 4;
						break;
					case 3:
					case 4:
						taillebat = 3;
						break;
					case 5:
						taillebat = 2;
						break;
				}
				if (verticale) {
					if (y + taillebat > 10) {
						valid = false;
					} else {
						valid = true;
						for (int j = y; j < y+taillebat; j++) {
							this.displayMaGrille();
							System.out.print(x);
							System.out.println(this.maGrille[x][j]);
							if (this.maGrille[x][j] != null) {
								valid = false;
								break;
							}
						}
					}
				} else {
					if (x + taillebat > 10) {
						valid = false;
						
					} else {
						valid = true;
						for (int i = x; i < x+taillebat; i++) {
							if (this.maGrille[i][y] != null) {
								
								valid = false;
								break;
							}
						}
					}
				}
				System.out.println(valid);
				if(!valid) {
					System.out.println("INVALIDE");
				}
			}
			Position posNavire = new Position(x, y, verticale);
			if (typebateau == 1) {
				this.p1.setPosition(posNavire);
			} else if (typebateau == 2) {
				this.s1.setPosition(posNavire);
			} else if (typebateau == 3) {
				this.c1.setPosition(posNavire);
				this.c1.setNom("CUI1");
			} else if (typebateau == 4) {
				this.c2.setPosition(posNavire);
				this.c2.setNom("CUI2");
			}else if (typebateau == 5) {
				this.z1.setPosition(posNavire);
			}
			this.remplissage();
			this.displayMaGrille();
		}
	}

	public void remplissage() {
		this.clearMagrille();
		for (int i = 0; i < listNavire.length; i++) {
			if(listNavire[i].getPosition() != null) {
				for(int j = 0; j < listNavire[i].getTaille(); j++) {
					
					int x = listNavire[i].getPosition().getPosX();
					int y = listNavire[i].getPosition().getPosY();
					String nom = listNavire[i].getNom();
					//verticale
					if(listNavire[i].getPosition().getSens()) {
						this.setMaGrille(x, y + j, nom);
					//Horizontale
					}else {
						this.setMaGrille(x + j, y, nom);
					}
				}
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
				String maCase = "";
				if (this.grilleAdverse[i][j] != null) {
					maCase = " " + this.grilleAdverse[i][j] + " ";
				} else {
					maCase = " ---- ";
				}
				System.out.print(maCase);
			}
			System.out.println("");
		}

	}
}