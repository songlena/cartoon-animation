package cartoon;

import cs15.prj.ticTacToeSupport.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Creating top-level object, setting up the scene, and showing the stage
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), 500, 400);
        stage.setScene(scene);
        stage.setTitle("Lena's Mushroom Runner");
        stage.show();
    }
    public static void main(String[] argv) {
        launch(argv);
    }
}
