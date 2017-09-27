package sources;


import java.util.Random;

import information.Information;
import information.InformationNonConforme;
import destinations.DestinationInterface;

/**
 * Classe proposant une source aléatoire d'informations dont les
 * éléments sont de type Booléen
 * @author A.Barry et Y.Le Gall
 *
 */
public class SourceAleatoire extends Source <Boolean> {

	private int nbBits;
	private int seed;
	private boolean pSeed = false;
	
	/**
	 * constructeur de la classe avec seed
	 * @param nbBits correspond au nombre de bits à générer. Valeurs comprise entre 0 et 999 999
	 * @param seed définit la semance d'initialisation pour l'algorithme de génération aléatoire
	 */
	public SourceAleatoire(int nbBits,int seed) {
		super();
		this.nbBits = nbBits;
		this.seed = seed;
		this.pSeed = true;
	}
	/**
	 * constructeur de la classe sans seed
	 * @param nbBits correspond au nombre de bits à générer. Valeurs comprise entre 0 et 999 999.
	 */
	public SourceAleatoire(int nbBits) {
		super();
		this.nbBits = nbBits;
	}
	

    /**
     * retourne la dernière information émise par la source
     * @return une information   
     */
    public Information <Boolean>  getInformationEmise() {
    	return this.informationEmise;
    }
    
    /**
     * emet l'information générée
     */
    public void emettre() throws InformationNonConforme {
	    // On génère la chaine d'information aléatoire
    	Boolean[] infoGen = new Boolean[nbBits];
    	Random rand;
    	if(pSeed == true)
    		 rand = new Random(seed);
    	else
    		rand = new Random();
    	
    	for(int i=0;i<nbBits;i++){
    		infoGen[i] = rand.nextBoolean();
		}
		super.informationGeneree = new Information<Boolean>(infoGen);
		
		// Emission vers les composants connectés   
		for (DestinationInterface <Boolean> destinationConnectee : destinationsConnectees) {
	            destinationConnectee.recevoir(informationGeneree);
		}
		this.informationEmise = informationGeneree;   			 			      
    }
}
