import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ActionTextEditor {
	
	GUI_TextEditor gui;
	String file_Name;
	String file_Path;
	
	public ActionTextEditor(GUI_TextEditor gui) {
		this.gui= gui ;
	}
	
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");
		file_Name = null;
		file_Path = null;
		
		
	}
	public void Open() {
		
		FileDialog fD = new FileDialog(gui.window,"Open",FileDialog.LOAD);
		fD.setVisible(true);
		
		
		if(fD.getFile()!=null) {
			file_Name = fD.getFile();
			file_Path = fD.getDirectory();
			gui.window.setTitle(file_Name);
		}
		
		
		// readable file
		try {
			BufferedReader bR = new BufferedReader(new FileReader(file_Path +file_Name));
			
			gui.textArea.setText("");
			String line =null;
			 while((line = bR.readLine())!=null){
				 gui.textArea.append(line + "\n");
			 }
			 bR.close(); 
			
		}catch(Exception e) {
			System.out.println("File unavailable!");
		}
		
	}
	
	public void save() {
		
		if(file_Name == null) {
			saveAs();
		}
		else {
			try {
				FileWriter fW = new FileWriter(file_Path + file_Name);
				fW.write(gui.textArea.getText());
				gui.window.setTitle(file_Name);
				fW.close();
				
			}catch(Exception e) {
				System.out.println("Incorrect, try again");
			}
		}
		
		
	}
	public void saveAs() {
		
		FileDialog fD = new FileDialog(gui.window,"Save",FileDialog.SAVE);
		fD .setVisible(true);
		
		if (fD.getFile()!=null) {
			file_Name = fD.getFile();
			file_Path = fD.getDirectory();
			gui.window.setTitle(file_Name);
		}
		
	
	try {
		
		FileWriter fW = new FileWriter(file_Path + file_Name);
		fW.write(gui.textArea.getText());
		fW.close();
		
	}catch(Exception e) {
		System.out.println("Incorrect, try again");
	}
		
		
	}
	

}
