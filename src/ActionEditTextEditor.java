
public class ActionEditTextEditor {

		GUI_TextEditor gui;
		
	public ActionEditTextEditor(GUI_TextEditor gui) {
		this.gui = gui;
	}
	
	public void undo() {
		
		gui.um.undo();
	}
	
	public void redo() {
		
		gui.um.redo();
	}
}
