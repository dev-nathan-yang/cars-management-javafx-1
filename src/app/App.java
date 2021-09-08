package app;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		Scene scene = new Scene(new Pane(), 600, 400);
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] r) {
		launch(r);
	}

}
