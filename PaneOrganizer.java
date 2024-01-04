package cartoon;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PaneOrganizer {
    private BorderPane root;
    private Label label;
    private Mushroom ball;
    private HBox buttonPane;
    private HBox labelPane;

    public PaneOrganizer() {
        this.root = new BorderPane();
        this.labelPane = new HBox();
        this.buttonPane = new HBox();
        this.label = new Label();

        new Cartoon(this.root);
        this.ball = new Mushroom(this.root, this.label);
        this.labelPane.getChildren().add(this.label);
        this.root.setTop(this.labelPane);
        this.labelPane.setAlignment(Pos.CENTER);

        this.root.setBottom(this.buttonPane);
        this.setUpButton(this.buttonPane);
    }
    public BorderPane getRoot() {
        return this.root;
    }
    // this method adds a quit button to the program that exits the program upon click
    private void setUpButton(HBox buttonPane) {
        Button b1 = new Button("Quit");
        buttonPane.getChildren().addAll(b1);
        b1.setOnAction((ActionEvent e) -> System.exit(0));
        this.buttonPane.setOnKeyPressed((KeyEvent e) -> this.onKeyPressed(e));
    }
    // this method responds to different keys that are pressed, either ENTER or BACK_SPACE, and calls different
    // methods defined in the Mushroom class to change the color of the mushroom based on which key is pressed
    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case ENTER:
                this.ball.invertColor();
                break;
            case BACK_SPACE:
                this.ball.originalColor();
                break;
            default:
                break;
            }
       keyEvent.consume();
    }
}
