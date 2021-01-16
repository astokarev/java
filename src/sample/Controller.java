package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    public TextArea chat;
    @FXML
    public TextField message;


   public void btnClick(ActionEvent actionEvent) {
       Date date = new Date();
       String strDateFormat = "HH:mm:ss";
       DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
       String formattedDate= dateFormat.format(date);
       if (message.getText() != null) {
           chat.appendText(formattedDate.toString() + ": " + message.getText()+"\n");
           message.setText(null);
       }
    }
}
