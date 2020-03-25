package ba.unsa.etf.rs.tut4;
import java.util.ArrayList;

public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;

    public Artikal(String sifra, String naziv, double cijena) {
        setSifra(sifra);
        setNaziv(naziv);
        setCijena(cijena);
    }

    public void setSifra(String sifra) {
        if(sifra.contentEquals("")) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra = sifra;
    }

    public void setNaziv(String naziv) {
        if(naziv.contentEquals("")) throw  new IllegalArgumentException("Naziv je prazn");
        this.naziv = naziv;
    }

    public void setCijena(double cijena) {
        if(cijena<=0) throw  new  IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    @Override
    public String toString() {
        return this.naziv+", "+this.sifra+", "+ this.cijena;
    }

    public  static ArrayList<Artikal> izbaciDuplikate (ArrayList<Artikal> lista){
     for (int i=0;i<lista.size();i++){
         for (int j = i+1; j <lista.size() ; j++) {
             if(lista.get(i)!=lista.get(j) && lista.get(i).equals(lista.get(j))){
                 lista.remove(j);
                 j--;
             }
         }
     }
        return  lista;
    }
    @Override
    public boolean equals(Object obj) {
        Artikal artikal = (Artikal)obj;
        return this.getCijena()==artikal.getCijena()  && this.getNaziv().contentEquals(artikal.getNaziv())
                && this.getSifra().contentEquals(artikal.getSifra());
    }
}
