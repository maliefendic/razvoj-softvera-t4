package ba.unsa.etf.rs.tut4;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Artikal {
    private SimpleStringProperty sifra,naziv;
    private SimpleDoubleProperty cijena;

    public Artikal(String sifra, String naziv, double cijena) {
       this.sifra=new SimpleStringProperty(sifra);
        this.naziv= new SimpleStringProperty(naziv);
        this.cijena = new SimpleDoubleProperty(cijena);
    }

    public void setSifra(String sifra) {
        this.sifra.set(sifra);
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public void setCijena(double cijena) {
        this.cijena.set(cijena);
    }

    public String getSifra() {
        return sifra.get();
    }

    public SimpleStringProperty sifraProperty() {
        return sifra;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public double getCijena() {
        return cijena.get();
    }

    public SimpleDoubleProperty cijenaProperty() {
        return cijena;
    }

    @Override
    public String toString() {
        return this.naziv.get()+", "+this.sifra.get()+", "+ this.cijena.get();
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
