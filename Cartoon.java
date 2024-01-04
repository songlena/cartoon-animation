package cartoon;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Cartoon {
    private Ellipse ellipse;
    private Rectangle background;
    private Rectangle foreground;

    public Cartoon(Pane root){

        LinearGradient g
                = LinearGradient.valueOf("linear-gradient(from 0% 0% to 100% 100%, lightblue  20% , cornflowerblue 70%, royalblue 100%)");
        this.ellipse = new Ellipse(Constants.SUN_SIZE, Constants.SUN_SIZE);
        this.background = new Rectangle(Constants.RECT_WIDTH, Constants.RECT_HEIGHT, g);
        this.foreground = new Rectangle(Constants.GRASS_WIDTH, Constants.GRASS_HEIGHT, Color.SEAGREEN);

        root.getChildren().addAll(this.background, this.foreground, this.ellipse);
        this.setupSun();
        this.setupGrass();
    }
    // this method sets up the Sun by adding the yellow color, positioning x and y, and implementing a blur effect
    private void setupSun() {
        this.ellipse.setFill(Color.YELLOW);
        this.ellipse.setCenterX(Constants.SUN_POSITION);
        this.ellipse.setCenterY(Constants.SUN_POSITION);
        this.ellipse.setEffect(new GaussianBlur());
    }
    // this method sets up the grass by adding the position of the rectangle (x and y)
    private void setupGrass() {
        this.foreground.setX(Constants.GRASS_XPOSITION);
        this.foreground.setY(Constants.GRASS_YPOSITION);
    }
}
