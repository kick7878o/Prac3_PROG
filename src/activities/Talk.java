package activities;

/**Class Talks.java
 * 
 * This class is made for storing talks
 * 
 * @author Aleix Chillida Subirats (aleix.chillida@estudiants.urv.cat)
 */
public class Talk extends Activitats {
    private String hour; // Hour of the speech
    private String nameSpeaker; // Name of the speaker

    /** Constructor of the talks
     * @param nomEntitat
     * @param nomActivitat
     * @param lloc
     * @param codiPostal
     * @param dia
     * @param nameSpeaker
    */
    public Talk(String nomEntitat, String nomActivitat, String lloc, String codiPostal, String dia, String nameSpeaker){
        super(nomEntitat, nomActivitat, lloc, codiPostal, dia);
        this.hour = "17:00 h";
        this.nameSpeaker = nameSpeaker;
    }

    public String getHour() { return hour; }
    public void setHour(String hour) { this.hour = hour; }
    public String getNameSpeaker() { return nameSpeaker; }
    public void setNameSpeaker(String nameSpeaker) { this.nameSpeaker = nameSpeaker; }

     /** Method that duplicates an instance of Talk
     * @return duplicate
     */
    public Talk copyTalk(){
        return new Talk(nomEntitat, nomActivitat, lloc, codiPostal, dia, nameSpeaker);
    }
    @Override
    public String toString() {
        return super.toString() + "\nTalk [nameSpeaker=" +nameSpeaker+ ", hour= " +hour+ "]";
    }     
}
