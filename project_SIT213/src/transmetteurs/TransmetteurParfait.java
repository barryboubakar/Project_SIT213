package transmetteurs;

import destinations.*;
import information.*;

/** 
 * Classe d'un composant transmetteur parfait d'informations dont
 * les éléments sont de type Booléan en entrée et de type Booléan en sortie;
 * @author A.Barry et Y.Le Gall
 */
public class TransmetteurParfait  extends  Transmetteur<Boolean,Boolean> {
   
    /** 
     * un constructeur factorisant les initialisations communes aux
     * réalisations de la classe abstraite Transmetteur
     */
    public TransmetteurParfait() {
    	super();
    }

	
	/** 
     * reçoit l'information venant de la source 
     * @param information l'information émise par la source connectée
     */
    @Override
	public void recevoir(Information<Boolean> information) throws InformationNonConforme {
		this.informationRecue = information;		
	}

    /** 
     * emet l'information vers la(les) destination(s) connecté(e)s 
     */
	@Override
	public void emettre() throws InformationNonConforme {
		// Emission vers les composants connectés
		for (DestinationInterface <Boolean> destinationConnectee : destinationsConnectees) {
			destinationConnectee.recevoir(this.informationRecue);
		}
		this.informationEmise = this.informationRecue;  	
	}
   	
}
