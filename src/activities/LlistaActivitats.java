    package activities;
    
    public class LlistaActivitats {
        private Activitats[] llista;
        private int nElem;
        
        public LlistaActivitats(int mida) {
                llista=  new Activitats[mida];
                nElem= 0;
            }

        public Activitats[] getLlista() {
            return llista;
        }

        public void setLlista(Activitats[] llista) {
            this.llista = llista;
        }

        public int getnElem() {
            return nElem;
        }

        public void setnElem(int nElem) {
            this.nElem = nElem;
        }

        public void agefirActivitat(Activitats act){
            if(nElem < llista.length) {
                llista[nElem] = act.copia();
                nElem++;
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
