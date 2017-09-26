package transmetteurs;

import destinations.*;
import information.*;


/** 
 * @authors A.Barry & Y.Le Gall
 */
public class TransmetteurParfait  extends  Transmetteur<Boolean,Boolean> {
   
    /** 
     * un constructeur factorisant les initialisations communes aux
     * réalisations de la classe abstraite Transmetteur
     */
    public TransmetteurParfait() {
    	super();
    }

	@Override
	public void recevoir(Information<Boolean> information) throws InformationNonConforme {
		this.informationRecue = information;		
	}

	@Override
	public void emettre() throws InformationNonConforme {
		// Emission vers les composants connectés
		for (DestinationInterface <Boolean> destinationConnectee : destinationsConnectees) {
			destinationConnectee.recevoir(this.informationRecue);
		}
		this.informationEmise = this.informationRecue;  	
	}
   	
}
