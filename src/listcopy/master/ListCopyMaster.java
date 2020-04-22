
package listcopy.master;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListCopyMaster extends Application {

    
    public static void main(String[] args) {
          launch(args);
    }
    
    ListView listView1;
    ListView listview2;
    Button copy;
    ObservableList<String> modfyList;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Multiple Selection Lists");
        listView1 = new ListView();
        listview2 = new ListView();
        copy = new Button("Copy >>> ");  ////Button
        modfyList = FXCollections.observableArrayList();
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView1.setItems(modfyList);
        modfyList.addAll("Black", "Blue", "Cyan", "Dark Geay", "Gray", "Green", "Blue", "Gray", "Dark Geay",  "Green", "Black","Red");
        listView1.setPrefSize(120, 100);
        listview2.setPrefSize(120, 100);
        copy.setOnAction(Copy -> {
            if (listView1.getSelectionModel().getSelectedItems().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "No item selections ", ButtonType.OK);
                alert.show();
            } else {
                listview2.getItems().addAll(listView1.getSelectionModel().getSelectedItems());
                listView1.getSelectionModel().clearSelection();
                listview2.getSelectionModel().clearSelection();
            }
        });
        HBox Box = new HBox(10, listView1, copy, listview2);
        Box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(Box, 600, 200);
        stage.setScene(scene);
        stage.show();
    }

}

