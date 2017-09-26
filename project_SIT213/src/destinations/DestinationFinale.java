package destinations;

import information.*;

/** 
 * @authors A.Barry & Y.Le Gall
 */

public class DestinationFinale extends Destination <Boolean> {
       
    /** 
     * un constructeur factorisant les initialisations communes aux
     * réalisations de la classe abstraite Destination
     */
    public DestinationFinale() {
    	super();
    }

    /**
     * reçoit une information
     * @param information  l'information  à recevoir
     */
	@Override
	public void recevoir(Information<Boolean> information)throws InformationNonConforme {
		this.informationRecue = information;
	}  
}
