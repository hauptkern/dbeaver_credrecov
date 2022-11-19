package com.hauptkern.dbeaver_credrecov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CredRecoverApplication{
public static class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CredRecoverApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 340);
        stage.setTitle("DBeaver Credentials Recovery Tool");
        stage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("images/logo.png"))));
        stage.setScene(scene);
        stage.show();
    }

}
    public static void main(String[] args) {
        Application.launch(App.class);
    }
}