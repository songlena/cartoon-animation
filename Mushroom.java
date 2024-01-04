package cartoon;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class Mushroom {
        private Ellipse ball;
        private Circle shape1;
        private Circle shape2;
        private Circle shape3;
        private Circle shape4;
        private Ellipse base;
        private Label label;
        private int laps = 0;

        public Mushroom(Pane root, Label label) {
            this.ball = new Ellipse();
            this.shape1 = new Circle();
            this.shape2 = new Circle();
            this.shape3 = new Circle();
            this.shape4 = new Circle();
            this.base = new Ellipse();
            this.label = label;
            root.getChildren().addAll(this.base, this.ball, this.shape1, this.shape2, this.shape3, this.shape4);
            this.setUpEllipses();
            this.setUpCircles();
            this.setXLoc(Constants.X_LOC);
            this.updateMushroom();
        }
    // this method designs the ellipses of the mushroom (adds color and lighting)
    public void setUpEllipses() {
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-140.0);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(10.0);
            this.ball.setFill(Color.ORANGERED);
            this.ball.setCenterX(Constants.BALL_XLOC);
            this.ball.setCenterY(Constants.BALL_YLOC);
            this.ball.setRadiusX(Constants.BALL_XRADIUS);
            this.ball.setRadiusY(Constants.BALL_YRADIUS);
            this.ball.setEffect(lighting);

            this.base.setFill(Color.BISQUE);
            this.base.setCenterX(Constants.BASE_XLOC);
            this.base.setCenterY(Constants.BASE_YLOC);
            this.base.setRadiusX(Constants.BASE_XRADIUS);
            this.base.setRadiusY(Constants.BASE_YRADIUS);
            this.base.setEffect(lighting);
        }
        //this method designs the circles of the mushroom based on size and color
        public void setUpCircles(){
            this.shape1.setFill(Color.IVORY);
            this.shape1.setCenterX(Constants.CIRCLE1_XLOC);
            this.shape1.setCenterY(Constants.CIRCLE1_YLOC);
            this.shape1.setRadius(Constants.CIRCLE_RADIUS);

            this.shape2.setFill(Color.IVORY);
            this.shape2.setCenterX(Constants.CIRCLE2_XLOC);
            this.shape2.setCenterY(Constants.CIRCLE2_YLOC);
            this.shape2.setRadius(Constants.CIRCLE_RADIUS);

            this.shape3.setFill(Color.IVORY);
            this.shape3.setCenterX(Constants.CIRCLE3_XLOC);
            this.shape3.setCenterY(Constants.CIRCLE3_YLOC);
            this.shape3.setRadius(Constants.CIRCLE_RADIUS);

            this.shape4.setFill(Color.IVORY);
            this.shape4.setCenterX(Constants.CIRCLE4_XLOC);
            this.shape4.setCenterY(Constants.CIRCLE4_YLOC);
            this.shape4.setRadius(Constants.CIRCLE_RADIUS);
        }
        // this method is called in PaneOrganizer to change the color of the mushroom based on a key press
        public void invertColor() {
            this.ball.setFill(Color.IVORY);
            this.shape1.setFill(Color.ORANGERED);
            this.shape2.setFill(Color.ORANGERED);
            this.shape3.setFill(Color.ORANGERED);
            this.shape4.setFill(Color.ORANGERED);
        }
        // this method is called in PaneOrganizer to change the color of the mushroom based on a key press
        public void originalColor() {
            this.ball.setFill(Color.ORANGERED);
            this.shape1.setFill(Color.IVORY);
            this.shape2.setFill(Color.IVORY);
            this.shape3.setFill(Color.IVORY);
            this.shape4.setFill(Color.IVORY);
        }
        // this method sets the center of each shape in terms of the x position and locks it
        private void setXLoc(double x) {
            this.ball.setCenterX(x);
            this.shape1.setCenterX(x);
            this.shape2.setCenterX(x + Constants.CIRCLE2_XLOC);
            this.shape3.setCenterX(x - Constants.CIRCLE2_XLOC);
            this.shape4.setCenterX(x);
            this.base.setCenterX(x);
        }
        // this method is responsible for moving the mushroom back and forth across the screen and calling the method
        //that updates the label based on laps run
        private void updateMushroom() {
            final Timeline timeline = new Timeline();
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.setAutoReverse(true);

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),
                    (ActionEvent e) ->
                            this.updateLabel(),
                    new KeyValue(this.base.translateXProperty(), Constants.END_VALUE),
                    new KeyValue(this.ball.translateXProperty(), Constants.END_VALUE),
                    new KeyValue(this.shape1.translateXProperty(), Constants.END_VALUE),
                    new KeyValue(this.shape2.translateXProperty(), Constants.END_VALUE),
                    new KeyValue(this.shape3.translateXProperty(), Constants.END_VALUE),
                    new KeyValue(this.shape4.translateXProperty(), Constants.END_VALUE));

            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
        }
        // this method updates the label by incrementing the variable laps by one each time a lap is completed
        private void updateLabel() {
            this.label.setText("Number of laps the mushroom runs: " + this.laps++);
        }

}

