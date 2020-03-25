package ba.unsa.etf.rs.tut4;
import java.util.ArrayList;

import static java.lang.StrictMath.round;

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
        this.stavke=new ArrayList<>();
    }

   public  void dodajStavku(Artikal artikal, int kolicina){
       this.stavke.add(new Stavke(artikal, kolicina));
   }

   public  double ukupanIznos(){
       double suma=0;
       for (int i = 0; i <stavke.size() ; i++) {
           suma+=stavke.get(i).getArtikal().getCijena()*stavke.get(i).getKolicina();
       }
       return  suma;
   }

    @Override
    public String toString() {
        String s="";
        double suma=0;
        for (int i=0;i<stavke.size();i++){
            suma+=stavke.get(i).getKolicina()*stavke.get(i).getArtikal().getCijena();
            s+=stavke.get(i).getArtikal().getSifra()+" "+stavke.get(i).getKolicina()+" "+stavke.get(i).getKolicina()*stavke.get(i).getArtikal().getCijena() +"\n";
        }
        s+="UKUPNO "+suma;
        return s;
    }
}
