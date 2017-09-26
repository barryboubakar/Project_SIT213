/**
 * 
 */
package sources;


import information.Information;
import information.InformationNonConforme;
import destinations.DestinationInterface;

/**
 *  Classe proposant une source fixe d'informations dont les
 * éléments sont de type T
 * @authors A.Barry & Y.Le Gall
 *
 */
public class SourceFixe extends Source <Boolean> {

	/**
	 * constructeur de la classe
	 */
	public SourceFixe(String chaineBits) {
		super();
		Boolean[] infoGen = new Boolean[chaineBits.length()];
		for(int i=0;i<chaineBits.length();i++){
			if(chaineBits.charAt(i) == '1'){
				infoGen[i] = true;
			}
			else
				infoGen[i] = false;			
		}
		super.informationGeneree = new Information<Boolean>(infoGen);
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
	    // Emission vers les composants connectés
		for (DestinationInterface <Boolean> destinationConnectee : destinationsConnectees) {
	            destinationConnectee.recevoir(informationGeneree);
		}
		this.informationEmise = informationGeneree;   			 			      
    }
}
