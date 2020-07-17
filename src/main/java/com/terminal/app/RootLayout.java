package com.terminal.app;

import java.io.IOException;
import java.io.InputStream;

import com.kodedu.terminalfx.TerminalBuilder;
import com.kodedu.terminalfx.TerminalTab;
import com.kodedu.terminalfx.config.TerminalConfig;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RootLayout {

	public static TerminalTab terminal;
	private Stage primaryStage;
	private BorderPane rootLayout;

	public RootLayout(Stage primaryStage) {
		super();
		this.primaryStage = primaryStage;
	}

	public void init() {
		this.initBorderPane();
		this.initContent();

	}

	private void initBorderPane() {
		try {
	        InputStream sceneStream = Main.class.getResourceAsStream("/fxml/RootLayout.fxml");
	        FXMLLoader loader = new FXMLLoader();
	        rootLayout = loader.load(sceneStream);
	        
	        Scene scene = new Scene(rootLayout);
	        scene.getStylesheets().add(Main.class.getResource("/styles/Styles.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void initContent() {
		TabPane tabPane = new TabPane();

//      Custom Config
		TerminalConfig customConfig = new TerminalConfig();
		customConfig.setBackgroundColor(Color.rgb(165, 165, 165));
		customConfig.setForegroundColor(Color.rgb(255, 255, 64));
		customConfig.setCursorColor(Color.rgb(255, 0, 0, 0.5));
		customConfig.setCursorBlink(true);
		customConfig.setCursorColor(Color.rgb(255, 255, 64));
		
		TerminalBuilder terminalBuilder = new TerminalBuilder(customConfig);
		terminal = terminalBuilder.newTerminal();

		tabPane.getTabs().addAll(terminal);
		rootLayout.setCenter(tabPane);
	}
}
