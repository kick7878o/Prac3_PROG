package activities;
public class Activitats {
    protected static int numActivitats = 0;

    protected String codiActivitat;
    protected String nomEntitat;
    protected String nomActivitat;
    protected String lloc;
    protected String codiPostal;
    protected String dia;

    public Activitats(String entitat, String nomActivitat, String lloc, String codiPostal, String dia) {
        Activitats.numActivitats++;
        this.nomEntitat = entitat;
        this.nomActivitat = nomActivitat;
        this.lloc = lloc;
        this.codiPostal = codiPostal;
        this.dia = dia;

        // Generar automàticament el codi a partir de les 3 primeres lletres del nom de l'entitat
        this.codiActivitat = nomEntitat.substring(0, 3).toUpperCase() + (100 + Activitats.numActivitats);
    }

	public String getCodiActivitat(){
		return codiActivitat;
	}

	public Activitats copia() {
		return new Activitats(nomEntitat, nomActivitat, lloc, codiPostal, dia);
	}
}
