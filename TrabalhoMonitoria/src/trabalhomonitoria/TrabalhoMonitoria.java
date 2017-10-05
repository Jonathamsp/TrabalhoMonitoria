package trabalhomonitoria;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 *
 * @author JonathamPetzolddeSou
 */
public class TrabalhoMonitoria extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GoogleMail mail = new GoogleMail();
        Label label1 = new Label("Para:");
        Label label2 = new Label("Assunto:");
        Label label3 = new Label("Mensagem:");
        TextField messageMail = new TextField();
        TextField messageSubject = new TextField();
        TextField messageTo = new TextField();
        Button btn = new Button();
        btn.setText("Enviar");
        label1.setTranslateY(-230);
        messageTo.setTranslateY(-205);
        label2.setTranslateY(-175);
        messageSubject.setTranslateY(-150);
        label3.setTranslateY(-50);
        messageMail.setPrefHeight(200);
        messageMail.setTranslateY(80);
        btn.setTranslateY(220);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mail.sendMail(messageMail.getText(), messageTo.getText(), messageSubject.getText());
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(label1,messageTo, label2, messageSubject, label3, messageMail, btn);
        
        Scene scene = new Scene(root, 600, 500);
        
        primaryStage.setTitle("MailJonatham");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
