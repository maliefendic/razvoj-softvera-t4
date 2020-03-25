package ba.unsa.etf.rs.tut4;
import java.util.ArrayList;

public class Racun {
    private class Stavke{
        Artikal artikal;
        int kolicina;
        public Stavke(Artikal artikal, int kolicina) {
            this.artikal = artikal;
            this.kolicina = kolicina;
        }

        public void setArtikal(Artikal artikal) {
            this.artikal = artikal;
        }

        public void setKolicina(int kolicina) {
            this.kolicina = kolicina;
        }

        public Artikal getArtikal() {
            return artikal;
        }

        public int getKolicina() {
            return kolicina;
        }
    }
    private ArrayList<Stavke> stavke;
    public  Racun(){
    }

   public  void dodajStavku(Artikal artikal, int kolicina){
       stavke.add(new Stavke(artikal, kolicina));
   }

   public  double ukupanIznos(){
       double suma=0;
       for (int i = 0; i <stavke.size() ; i++) {
           suma+=stavke.get(i).getArtikal().getCijena()*stavke.get(i).getKolicina();
       }
       return  suma;
   }
}
