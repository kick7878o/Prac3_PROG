package activities;
public class Visites extends Activitats{
	private String espai;
	private boolean audioguia;
	private boolean adaptat;
	
	
	public Visites (String entitat, String nomActivitat, String lloc, String codiPostal, String dia, boolean audio, boolean adap) {
		super(entitat, nomActivitat, lloc, codiPostal, dia);
		audioguia=audio;
		adaptat= adap;
	}

	public String getEspai() {
		return espai;
	}

	public void setEspai(String espai) {
		this.espai = espai;
	}

	public boolean getAudioguia(){
		return audioguia;
	}

	public void setAudioguia(boolean audioguia){
		this.audioguia=audioguia;
	}

	public boolean getAdaptat(){
		return adaptat;
	}

	public void setAdaptat(boolean adaptat){
		this.adaptat=adaptat;
	}
	
	public Visites copia() {
		return new Visites(nomEntitat, nomActivitat, lloc, codiPostal, dia, audioguia, adaptat);
	}
	
	
	
	
}
