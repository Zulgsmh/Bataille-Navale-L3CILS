package model;

import model.Position;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//PorteAvion pa= new PorteAvion();
//
////System.out.println(pos);
//
//Position pos1= new Position(2,3,"vertical");
//pa.setPosition(pos1);
//Position pos=pa.getPosition();
////System.out.println(pos.getPosX());
//
Joueur j1=new Joueur();
////j1.displayMaGrille();
//
Joueur j2=new Joueur();
//
		Partie p = new Partie(j1,j2);
//		placement des bateau
		p.placerBateauJ1();
		p.placerBateauJ2();
		
//		boucle de la game
		for(int i = 0; i < 10; i++) {
			p.J1tirer();
			p.J2tirer();
		}
		

	}

}
 