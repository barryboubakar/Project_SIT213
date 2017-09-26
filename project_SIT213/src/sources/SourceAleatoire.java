/**
 * 
 */
package sources;


import java.util.Random;

import information.Information;
import information.InformationNonConforme;
import destinations.DestinationInterface;

/**
 *  Classe proposant une source fixe d'informations dont les
 * éléments sont de type T
 * @authors A.Barry & Y.Le Gall
 *
 */
public class SourceAleatoire extends Source <Boolean> {

	private int nbBits;
	private int seed;

	/**
	 * constructeur de la classe
	 */
	public SourceAleatoire(int nbBits,int seed) {
		super();
		this.nbBits = nbBits;
		this.seed = seed;
	}

    /**
     * retourne la dernière information émise par la source
     * @return une information   
     */
    public Information <Boolean>  getInformationEmise() {
    	return this.informationEmise;
    }
    
    /**
     * Emet l'information générée
     */
    public void emettre() throws InformationNonConforme {
	    // On génère la chaine d'information aléatoire
    	Boolean[] infoGen = new Boolean[nbBits];
    	Random rand = new Random(seed);
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
