package ba.unsa.etf.rs.tut4;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;
import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start(Stage  stage) throws IOException {
        Racun racun= new Racun();
        Controller ctrl= new Controller(racun);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/tutorijal.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        stage.setTitle("tutorijal 3");
        stage.setScene(new Scene(root, 500, 520));
        stage.setResizable(false);
        stage.show();
        stage.toFront();
    }
    @Test
    void unosArtikla(FxRobot robot){
        robot.clickOn("#poljeUpisa");
        robot.write("hljeb,hlj123,1\nmaslo,mas123," +
                "2\nriza, riz231,3");
        robot.clickOn("#btnDodajArtikle");
        TextArea polje=  robot.lookup("#poljePotvrdeUpisa").queryAs(TextArea.class);
        assertEquals("hlj123, hljeb, 1.0\n" +
                "mas123, maslo, 2.0\n" +
                " riz231, riza, 3.0\n", polje.getText());
    }
  


}