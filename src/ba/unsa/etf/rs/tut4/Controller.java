package ba.unsa.etf.rs.tut4;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class Controller {

    public Button btnDodajArtikle;
    public TextArea poljeUpisa;
    public TextArea poljePotvrdeUpisa;
    public Button btnDodajNaRacun;
    public Spinner spiner;
    public TextArea poljePregled;
    public ChoiceBox choiceboks;

    public Racun racun = new Racun();
    public ObservableList <Artikal>  artikli =FXCollections.observableArrayList();
    public SimpleStringProperty postojeciRacuni= new SimpleStringProperty("");


    @FXML
    public void initialize(){
       poljePotvrdeUpisa.textProperty().bindBidirectional(postojeciRacuni); // uspostavljena veza izmedju stringa koji ima nazive svih dadanih artikala

            }
    public void promjeniUkoliciniv(ActionEvent actionEvent) {
    }

    public void dodajNaRacun(ActionEvent actionEvent) {
    }

    public void dodajArtikle(ActionEvent actionEvent) {
        for (String s:poljeUpisa.getText().split("\\n") ) {
            String a[]=s.split(",");
            artikli.add(new Artikal(a[0],a[1],Double.parseDouble(a[2])));
        }
        Artikal.izbaciDuplikate(artikli);
        postojeciRacuni.set(IspisiArtikle(artikli));


    }
    public  String IspisiArtikle(ObservableList<Artikal> ar){
        String s="";
        for (Artikal a :ar )
            s+=a.getNaziv()+", "+a.getSifra()+", "+ a.getCijena()+"\n";
        return s;
    }
}
