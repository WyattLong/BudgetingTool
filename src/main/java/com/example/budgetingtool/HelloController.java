package com.example.budgetingtool;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtIncome;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnSubmit;
    @FXML
    private Label lbl50;
    @FXML
    private Label lbl30;
    @FXML
    private Label lbl20;
    @FXML
    private Label lblError;


    //performs the math to get the values for, %50, %30, %20 of the users income
    protected void budget() {
        //gets the users input and sets the value equal to double
        double income = Double.parseDouble(txtIncome.getText());

        //math for 50,30,20
        double fifty = income/2;
        double thirty = income*0.3;
        double twenty = income*0.2;

        //Sets the value to the 100th decimal place
        String fif = String.format("%.2f", fifty);
        String thir = String.format("%.2f", thirty);
        String twen = String.format("%.2f", twenty);

        //changes the labels to the values of 50,30,20
        lbl50.setText("$" + fif);
        lbl30.setText("$" + thir);
        lbl20.setText("$" + twen);

    }

    @FXML
    protected void onBtnSubmitClicked() {
        //checks to see if the text field is empty
        if (txtIncome.getText() == "") {
            lblError.setText("PLEASE ENTER A NUMBER");
        } else {
            //forces the field to be numeric only
            txtIncome.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        txtIncome.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });

            budget();
        }

    }

    //clears all the values
    @FXML
    protected void onBtnClearClicked() {
        txtIncome.clear();
        lbl50.setText("");
        lbl30.setText("");
        lbl20.setText("");
        lblError.setText("");
    }

}