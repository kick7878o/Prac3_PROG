package activities;
public class Activitats {
    protected static int numActivitats = 0;

    protected String codiActivitat; // Code uniquely identifying the activity
    protected String nomEntitat; // Name of the entity associated with the activity
    protected String nomActivitat; // Name of the activity
    protected String lloc; // Location of the activity
    protected String codiPostal; // Postal code of the activity
    protected String dia; // Day of the activity

    /**
     * Constructor to create a new activity.
     *
     * @param nomEntitat    The name of the entity organizing the activity.
     * @param nomActivitat  The name of the activity.
     * @param lloc      The location of the activity.
     * @param codiPostal    The postal code of the activity.
     * @param dia           The day of the activity.
     */

    public Activitats(String entitat, String nomActivitat, String lloc, String codiPostal, String dia) {
        Activitats.numActivitats++;
        this.nomEntitat = entitat;
        this.nomActivitat = nomActivitat;
        this.lloc = lloc;
        this.codiPostal = codiPostal;
        this.dia = dia;

        // Automatically generate the code based on the first 3 letters of the entity name
        this.codiActivitat = nomEntitat.substring(0, 2).toUpperCase() + (100 + Activitats.numActivitats);
    }
    /**
     * Getter method to retrieve the code of the activity.
     *
     * @return The code of the activity.
     */
	public String getCodiActivitat(){
		return codiActivitat;
	}
    /**
     * Creates a copy of the current activity.
     *
     * @return A new Activity object with the same attributes as the current one.
     */
	public Activitats copia() {
		return new Activitats(nomEntitat, nomActivitat, lloc, codiPostal, dia);
	}
}
