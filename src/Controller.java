import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    GridPane grid1, grid2, grid3, grid4, grid5, grid6, grid7, grid8, grid9;

    @FXML
    TextField grid1_text1, grid1_text2, grid1_text3, grid1_text4, grid1_text5, grid1_text6, grid1_text7, grid1_text8, grid1_text9,
            grid2_text1, grid2_text2, grid2_text3, grid2_text4, grid2_text5, grid2_text6, grid2_text7, grid2_text8, grid2_text9,
            grid3_text1, grid3_text2, grid3_text3, grid3_text4, grid3_text5, grid3_text6, grid3_text7, grid3_text8, grid3_text9,
            grid4_text1, grid4_text2, grid4_text3, grid4_text4, grid4_text5, grid4_text6, grid4_text7, grid4_text8, grid4_text9,
            grid5_text1, grid5_text2, grid5_text3, grid5_text4, grid5_text5, grid5_text6, grid5_text7, grid5_text8, grid5_text9,
            grid6_text1, grid6_text2, grid6_text3, grid6_text4, grid6_text5, grid6_text6, grid6_text7, grid6_text8, grid6_text9,
            grid7_text1, grid7_text2, grid7_text3, grid7_text4, grid7_text5, grid7_text6, grid7_text7, grid7_text8, grid7_text9,
            grid8_text1, grid8_text2, grid8_text3, grid8_text4, grid8_text5, grid8_text6, grid8_text7, grid8_text8, grid8_text9,
            grid9_text1, grid9_text2, grid9_text3, grid9_text4, grid9_text5, grid9_text6, grid9_text7, grid9_text8, grid9_text9;

    public Controller () {
        //runs before initializer
    }

    @FXML public void initialize () {
        //runs after constructor
        //populateTextFields();
    }

    //method to loop through every textfield and set random numbers in random textfields
    private void populateTextFields() {

    }

}
