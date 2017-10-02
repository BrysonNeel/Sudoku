import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Controller {

    @FXML ArrayList<GridPane> gridsList = new ArrayList<GridPane>();
    @FXML ArrayList<TextField> textFieldLists = new ArrayList();

    public Controller () {
        //runs before initializer
    }

    @FXML public void initialize () {
        //runs after constructor
        populateTextFields();
    }

    //method to loop through every textfield and set random numbers in random textfields
    private void populateTextFields() {
        for(int i = 0; i < textFieldLists.size(); i++) {
            System.out.println(textFieldLists.get(i));
            textFieldLists.get(i).setText("Test");
        }
    }

}
