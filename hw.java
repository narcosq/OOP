import java.util.Date;

public enum Priority {
    LOW, MEDIUM, HIGH
}


public interface Task {
    void setTask(String taskName, String taskDescription);
    void setTaskName(String taskName);
    void setTaskDescription(String taskDescription);
    void markAsComplete();
    void setPriority(Priority priority);
    void setDeadline(Date date);
}

public class HomeworkTask implements Task {
    // Implement the methods defined in the Task interface
    // Implement the custom toString() method
}

// Implement MeetingTask and ShoppingTask similarly

@FXML
private ListView<Task> listView;

ObservableList<Task> tasks = FXCollections.observableArrayList();

public void initialize() {
    // Initialize the ListView
    listView.setItems(tasks);
}

@FXML
private Label selectedText;

@FXML
protected void onListClicked() {
    int selectedIndex = listView.getSelectionModel().getSelectedIndex();
    selectedText.setText(tasks.get(selectedIndex).toString());
}
