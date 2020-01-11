package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.TouchScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class BaseTouchScreen extends Application implements TouchScreen {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Base Fridge Touch Screen");
		stage.show();
	}
}
