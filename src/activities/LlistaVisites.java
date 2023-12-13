    package activities;
    
    public class LlistaVisites {
        private Visites[] llista;
        private int nElem;
        
        public LlistaVisites(int mida) {
                llista=  new Visites[mida];
                nElem= 0;
            }

        public Visites[] getLlista() {
            return llista;
        }

        public void setLlista(Visites[] llista) {
            this.llista = llista;
        }

        public int getnElem() {
            return nElem;
        }

        public void setnElem(int nElem) {
            this.nElem = nElem;
        }

        public void agefirVisita(Visites act){
            if(nElem<llista.length){
                    for (int i = 0; i < nElem; i++) {
                        if(act.getNomEntitat().charAt(0)<=(llista[i].getNomEntitat().charAt(0))){
                            for(int k=nElem; k>i; k--){
                                llista[k]=llista[k-1];
                            }
                            llista[i]=act;
                        }
                } 
            }
        }
        public void eliminarUsuari(String codi) {
            int i = 0;
            while (i < nElem)
                if (llista[i].getCodiActivitat().equalsIgnoreCase(codi)) {
                    for (int j = i; j < nElem - 1; j++) {
                        llista[j] = llista[j + 1];
                    }
                    nElem--;
                } else
                    i++;
        }
    }


        