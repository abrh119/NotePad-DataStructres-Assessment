import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI_TextEditor implements ActionListener{
	
	
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollBar;
	JMenuBar menuBar;
	JMenu file,moderate;
	JMenuItem fNewFile,fOpenFile,fSaveFile,fSaveFileAs;
	JMenuItem fUndo,fRedo;
	
	ActionTextEditor fileTab = new ActionTextEditor(this);
	ActionEditTextEditor editTab = new ActionEditTextEditor(this);
	UndoManager um = new UndoManager();
	
	
	public static void main(String[] args) {
		new GUI_TextEditor();

	}
	//constructor
	public GUI_TextEditor() {
		windowpanel();
		textBox();
		menuBox();
		fileItem();
		editItem();
		
		window.setVisible(true);
		
	}
	
	//Text editor window details
	public void windowpanel() {
		
		window = new JFrame ("You have opened Text Editor!");
		window.setSize(1000,500);
		window.getContentPane().setBackground(Color.YELLOW);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	//textArea details
	public void textBox() {
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		scrollBar = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollBar);
		//window.add(textArea);
	}
	
	//menuBar properties
	public void menuBox() {
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
	//menuBar Items	
			file = new JMenu("File");
			menuBar.add(file);
			moderate = new JMenu("Manage");
			menuBar.add(moderate);
			
	}
	
	public void fileItem() {
		
		fNewFile = new JMenuItem("New File");
		fNewFile.addActionListener(this);
		fNewFile.setActionCommand("New File");
		file.add(fNewFile);
		
		fOpenFile = new JMenuItem("Open File");
		fOpenFile.addActionListener(this);
		fOpenFile.setActionCommand("Open File");
		file.add(fOpenFile);
		
		fSaveFile = new JMenuItem("Save File");
		fSaveFile.addActionListener(this);
		fSaveFile.setActionCommand("Save File");
		file.add(fSaveFile);
		
		fSaveFileAs = new JMenuItem("Save File As");
		fSaveFileAs.addActionListener(this);
		fSaveFileAs.setActionCommand("Save File As");
		file.add(fSaveFileAs);	
	}
	public void editItem() {
		
		fUndo = new JMenuItem("Undo");
		fUndo.addActionListener(this);
		fUndo.setActionCommand("Undo");
		moderate.add(fUndo);	
		
		fRedo = new JMenuItem("Redo");
		fRedo.addActionListener(this);
		fRedo.setActionCommand("Redo");
		moderate.add(fRedo);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent K
			) {
	
			String command = K .getActionCommand();
			
			switch(command) {
			case "New" : fileTab.newFile();break;
			case "Open" : fileTab.Open();break;
			case "Save" : fileTab.save();break;
			case "SaveAs" : fileTab.saveAs();break;
			case "Undo" : editTab.undo();break;
			case "Redo" : editTab.redo();break;
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
