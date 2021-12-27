package LMS.JavaFx;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BackgroundImg {
    public Background getBackgroundImage() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src/main/resources/Test6.jpeg");
        Image image = new Image(input);

        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        return new Background(backgroundimage);
    }
}
