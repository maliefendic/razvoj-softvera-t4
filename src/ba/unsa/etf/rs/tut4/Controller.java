package ba.unsa.etf.rs.tut4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.skin.ComboBoxListViewSkin;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class Controller {
    @FXML
    public  Button btnDodajArtikle;
    @FXML
   public TextArea poljeUpisa;
    @FXML
    public TextArea poljePotvrdeUpisa;
    @FXML
    public  Button btnDodajNaRacun;
    @FXML
    public TextArea poljePregled;
    @FXML
    public ComboBox comoboks1;
    @FXML
    public Spinner spiner;

    ArrayList<Artikal> artikli= new ArrayList<>();
    ArrayList<Racun> racuni = new ArrayList<>();
    public Racun r= new Racun();

    public void dodajArtikle(ActionEvent actionEvent) throws IOException {

        /*StringReader sr = new StringReader(poljeUpisa.getText());
        BufferedReader br = new BufferedReader(sr);
        String linija = "";
        while ((linija = br.readLine()) != null){
            String a[]=linija.split(",");
            artikli.add(new Artikal(a[0],a[1],Double.parseDouble(a[2])));
        }*/
        for (String s:poljeUpisa.getText().split("\\n") ) {
            String a[]=s.split(",");
            artikli.add(new Artikal(a[0],a[1],Double.parseDouble(a[2])));
        }

      Artikal.izbaciDuplikate(artikli);
        String s="";
        for (int i=0;i<artikli.size();i++){
           s+=artikli.get(i).toString()+"\n";
        }
        poljePotvrdeUpisa.setText(s);


       for (int i=0;i<artikli.size();i++){
           comoboks1.getItems().add(artikli.get(i).getSifra());
        }

    }


    public void dodajNaRacun(ActionEvent actionEvent) {
         int i= (int) spiner.getValue();
        r.dodajStavku(artikli.get(comoboks1.getSelectionModel().getSelectedIndex()),i);
        poljePregled.setText("");
        poljePregled.setText(r.toString());
    }

    public void promjeniUkolicini(ActionEvent actionEvent) {
        System.out.println(comoboks1.getSelectionModel().getSelectedIndex());
        int i=comoboks1.getSelectionModel().getSelectedIndex();
        SpinnerValueFactory<Integer>  v= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100000,1);
        spiner.setValueFactory(v);
    }
}
