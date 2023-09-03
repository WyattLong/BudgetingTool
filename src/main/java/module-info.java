module com.example.budgetingtool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.budgetingtool to javafx.fxml;
    exports com.example.budgetingtool;
}