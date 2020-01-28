package model;

/**
 *
 */
public class BatailleNavale {

    /**
     * Default constructor
     */
    public BatailleNavale() {
    }

    /**
     *
     */
    protected Joueur joueur1;

    /**
     *
     */
    protected Joueur joueur2;

    /**
     *
     */
    protected boolean tourJ1;

    /**
     *
     */
    // public int [][]grille1 = new int [10][10];


    /**
     *
     */
    //public int [][]grille2 = new int [10][10];


    /**
     *
     */
    public class MissionRadar extends BatailleNavale {

        /**
         * Default constructor
         */
        public MissionRadar() {
        }

        /**
         *
         */
        public void radar() {
            // TODO implement here
        }

    }

    /**
     *
     */
    public class OperationArtillerie extends BatailleNavale {

        /**
         * Default constructor
         */
        public OperationArtillerie() {
        }

        /**
         *
         */
        public void selection() {
            // TODO implement here
        }

    }

    /**
     *
     */
    public class AlerteRouge extends MissionRadar {

        /**
         * Default constructor
         */
        public AlerteRouge() {
        }

    }

}