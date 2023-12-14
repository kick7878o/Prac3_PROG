// @author David López

package activities;
/**
 * Represents visits as a type of activity, extending the base class Activities.
 */
public class Visites extends Activitats {
	private boolean audioguia; // Indicates if the visit has an audio guide
	private boolean adaptat; // Indicates if the visit is adapted for special needs
	
	/**
     * Constructor to create a new visit activity.
     *
     * @param nomEntitat    The name of the entity organizing the visit.
     * @param nomActivitat  The name of the visit activity.
     * @param lloc      The location of the visit.
     * @param codiPostal    The postal code of the visit.
     * @param dia           The day of the visit.
     * @param audioguia    True if the visit has an audio guide, false otherwise.
     * @param adaptat       True if the visit is adapted for special needs, false otherwise.
     */
	
	public Visites (String nomEntitat, String nomActivitat, String lloc, String codiPostal, String dia, boolean audio, boolean adap) {
		super(nomEntitat, nomActivitat, lloc, codiPostal, dia);
		audioguia=audio;
		adaptat= adap;
	}
	/**
     * Getter method to retrieve the name of the entity organizing the visit.
     *
     * @return The name of the entity.
     */
	public String getNomEntitat(){
		return nomEntitat;
	}
	/**
     * Setter method to set the name of the entity organizing the visit.
     *
     * @param nomEntitat The name of the entity to set.
     */
	public void setNomEntitat(String nom){
		nomEntitat=nom;
	}
	/**
     * Getter method to check if the visit has an audio guide.
     *
     * @return True if the visit has an audio guide, false otherwise.
     */
	public boolean getAudioguia(){
		return audioguia;
	}
	/**
     * Setter method to set whether the visit has an audio guide.
     *
     * @param audioguia True if the visit has an audio guide, false otherwise.
     */	
	public void setAudioguia(boolean audioguia){
		this.audioguia=audioguia;
	}
	/**
     * Getter method to check if the visit is adapted for special needs.
     *
     * @return True if the visit is adapted, false otherwise.
     */
	public boolean getAdaptat(){
		return adaptat;
	}
	/**
     * Setter method to set whether the visit is adapted for special needs.
     *
     * @param adaptat True if the visit is adapted, false otherwise.
     */
	public void setAdaptat(boolean adaptat){
		this.adaptat=adaptat;
	}

	/**
     * Creates a copy of the current visit activity.
     *
     * @return A new Visits object with the same attributes as the current one.
     */
	
	public Visites copia() {
		return new Visites(nomEntitat, nomActivitat, lloc, codiPostal, dia, audioguia, adaptat);
	}
	
	public String toString() {
          if (adaptat)
               return super.toString() + "Audioguia: " + audioguia + "\n" +
                       "Adaptat: Si\n";
          else
               return super.toString() + "Audioguia: " + audioguia + "\n" +
                       "Adaptat: No\n";
     }
}
