package activities;

/**Class ListTalks.java
 * 
 * This class is made for storing a list of talks
 * 
 * @author Aleix Chillida Subirats (aleix.chillida@estudiants.urv.cat)
 */

public class ListTalks {
    private Talk[] listTalks;
    private int nElem;

    public ListTalks(int size){
         listTalks = new Talk[size];
         nElem = 0;
    }

    /** Getter
     * @return number of elements on list
     */
    public int getnElem(){
        return nElem;
    }


    /** Setter
     * @param nElem
     */
    public void setnElem(int nElem) {
        this.nElem = nElem;
    }


    /**Getter
     * @return list of talks
     */
    public Talk[] getListTalks(){
        return listTalks;
    }

    /** Setter
     * @param listTalks
     */
    public void setListTalks(Talk[] listTalks) {
        this.listTalks = listTalks;
    }

    /** Method to add a talk to the list
    * @param talk instance of Talk 
    */
    public void addTalk(Talk talk){
        if(nElem < listTalks.length) {
            listTalks[nElem] = talk.copyTalk();
            nElem++;
        }
    }
    /** Method to delete a talk from the list
    * @param codiActivitat  
    */
    public void deleteTalk(String codiActivitat){
        int i = 0;
        while(i < nElem){
            if(listTalks[i].getCodiActivitat().equalsIgnoreCase(codiActivitat)){
                for(int j = i; j < nElem; j++){
                    listTalks[j] = listTalks[j + 1];                   
                }
                nElem--;
            } else {
                i++;
            }
        }
    }
     
    @Override
    public String toString(){
        String aux = "Talks List:\n";

        for(int i = 0; i < nElem; i++){
            aux+= "\n [" +i+"] " +listTalks+ "\n";
        }
        return aux;
    }





}
