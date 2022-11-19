package com.hauptkern.dbeaver_credrecov;
import com.hauptkern.dbeaver_credrecov.utils.CredentialModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.ArrayList;

import com.hauptkern.dbeaver_credrecov.utils.DBeaverDecrypt;
import com.hauptkern.dbeaver_credrecov.utils.Json2Table;

public class CredRecoverController {


    public TextField filePathField;
    public TableView<CredentialModel> credentialsTable;
    public TableColumn<CredentialModel, String> connectionNameColumn;
    public TableColumn<CredentialModel, String> UserColumn;
    public TableColumn<CredentialModel, String> PasswordColumn;

    @FXML
    private void openFileDialog(MouseEvent event) throws Exception {
        event.consume();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Credentials File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON", "*.json"));
        File file = fileChooser.showOpenDialog(new Stage());
        Path filePath = Path.of(file.getAbsolutePath());
        filePathField.setText(filePath.toString());
        String decrypted = new DBeaverDecrypt(filePath).decrypt();
        ArrayList<CredentialModel> output;
        try {
            Json2Table j2t = new Json2Table(decrypted);
            output = j2t.convert();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("An exception occurred!");
            alert.getDialogPane().setContent(new ScrollPane(new TextArea(sw.toString())));
            alert.showAndWait();
            filePathField.clear();
            return;
        }
        connectionNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("connectionName")
        );
        UserColumn.setCellValueFactory(
                new PropertyValueFactory<>("User")
        );
        PasswordColumn.setCellValueFactory(
                new PropertyValueFactory<>("Password")
        );
        ObservableList<CredentialModel> data = FXCollections.observableArrayList(output);
        credentialsTable.getItems().clear();
        credentialsTable.getItems().addAll(data);
    }
}