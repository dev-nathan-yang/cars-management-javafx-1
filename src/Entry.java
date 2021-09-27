import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Entry extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		
		Parent p = FXMLLoader.load(getClass().getResource("/app/view/gui/main_view.fxml"));
		Scene scene = new Scene(p,900 , 400);
		
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
