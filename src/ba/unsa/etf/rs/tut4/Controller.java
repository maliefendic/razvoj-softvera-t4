package ba.unsa.etf.rs.tut4;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class Controller {
    @FXML
    Button btnDodajArtikle;
    @FXML
    TextArea poljeUpisa;
    @FXML
    TextArea poljePotvrdeUpisa;
    public void dodajArtikle(ActionEvent actionEvent) throws IOException {
        ArrayList<Artikal> artikli= new ArrayList<>();
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
    }
}
