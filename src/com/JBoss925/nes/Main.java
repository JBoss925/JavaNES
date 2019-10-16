package com.JBoss925.nes;

import com.JBoss925.nes.components.ROM;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
//        launch(args);

        // Initialize ROM
        ROM rom = new ROM(new File(System.getProperty("user.home") + "/ROMS/Super Mario Bros. (World).nes"));
        Emulator emulator = new Emulator(rom);
        emulator.start();
    }
}
