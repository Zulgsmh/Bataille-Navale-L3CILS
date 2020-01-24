package model;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // PorteAvion pa= new PorteAvion();
//
////System.out.println(pos);
//
//Position pos1= new Position(2,3,"vertical");
//pa.setPosition(pos1);
//Position pos=pa.getPosition();
////System.out.println(pos.getPosX());
//
		//test
		// test de git
		Joueur j1 = new Joueur();
////j1.displayMaGrille();
//
		Joueur j2 = new Joueur();
//
		Partie p = new Partie();
//		placement des bateau
		p.startBataille();
		p.placerBateauJ1();
		p.placerBateauJ2();

//		boucle de la game
		for (int i = 0; i < 10; i++) {
			if (p.J1tirer()) {
				System.out.println("Joueur 1 a GAGNE !");
				break;
			}
			if (p.J2tirer()) {
				System.out.println("Joueur 2 a GAGNE !");
				break;
			}
		}

	}

}
