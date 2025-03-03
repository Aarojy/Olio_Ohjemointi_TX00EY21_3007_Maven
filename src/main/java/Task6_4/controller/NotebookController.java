package Task6_4.controller;

import Task6_4.model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NotebookController {
    private Notebook notebook;
    private String uneditedTitle;
    private String uneditedText;

    @FXML
    private TextArea addedText;

    @FXML
    private TextField addedTitle;

    @FXML
    private TextArea selectedText;

    @FXML
    private TextField selectedTitle;

    @FXML
    private ListView noteList;

    @FXML
    private Button saveButton;

    @FXML
    private ToggleButton editButton;

    public NotebookController() {
        this.notebook = new Notebook();
    }

    @FXML
    public void initialize() {
        this.notebook = new Notebook();
        selectedText.setEditable(false);
        selectedTitle.setEditable(false);
        saveButton.setDisable(true);
    }


    @FXML
    public void addNote() {
        String title = addedTitle.getText();
        String note = addedText.getText();

        if (title == null || title.isEmpty() || note == null || note.isEmpty()) {
            System.out.println("Title or note is empty");
        }
        else if (!notebook.titleInUse(title)) {
            notebook.addNote(title, note);
            System.out.println("Note added");
            noteList.getItems().add(title);
        }
    }

    @FXML
    public void selectNote() {
        selectedText.setEditable(false);
        selectedTitle.setEditable(false);
        saveButton.setDisable(true);
        if (editButton.isSelected()) {
            editButton.setSelected(false);
        }

        try {
            String title = (String) noteList.getSelectionModel().getSelectedItem();
            String note = notebook.getNoteByTitle(title).getText();
            selectedTitle.setText(title);
            selectedText.setText(note);
        } catch (Exception e) {
            System.out.println("Note not found");
        }
    }

    @FXML
    public void removeNote() {

        try {
            String title = (String) noteList.getSelectionModel().getSelectedItem();
            notebook.removeNoteByTitle(title);
            noteList.getItems().remove(title);
            selectedTitle.clear();
            selectedText.clear();
        } catch (Exception e) {
            System.out.println("Note not found");
        }

    }

    @FXML
    public void toggleEdit() {
        if (selectedText.isEditable() == true) {
            selectedTitle.setText(uneditedTitle);
            selectedText.setText(uneditedText);
        } else {
            try {
                uneditedTitle = (String) noteList.getSelectionModel().getSelectedItem();
                uneditedText= notebook.getNoteByTitle(uneditedTitle).getText();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        selectedText.setEditable(!selectedText.isEditable());
        selectedTitle.setEditable(!selectedTitle.isEditable());
        saveButton.setDisable(!saveButton.isDisabled());
    }

    @FXML
    public void saveNote() {
        try {
            String title = (String) noteList.getSelectionModel().getSelectedItem();
            notebook.removeNoteByTitle(title);
            notebook.addNote(selectedTitle.getText(), selectedText.getText());
            noteList.getItems().remove(title);
            noteList.getItems().add(selectedTitle.getText());
            selectedTitle.clear();
            selectedText.clear();
        } catch (Exception e) {
            System.out.println("Note not found");
        }
        toggleEdit();
        selectedTitle.clear();
        selectedText.clear();
        editButton.setSelected(false);
    }
}
