package tp.pr2.mv.gui.swing;


import java.awt.BorderLayout;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import tp.pr2.mv.Controlers.Controler;
import tp.pr2.mv.MVSystem.InStrategy;


// TODO: Auto-generated Javadoc
/**
 * The Class InputPanel.
 */
@SuppressWarnings("serial")
public class InputPanel extends JPanel{
	
	/** The ctrl. */
	private Controler ctrl;
	
	/** The input text area. */
	private JTextArea inputTextArea;
	
	/**
	 * Instantiates a new input panel.
	 *
	 * @param ctrl the ctrl
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	InputPanel(Controler ctrl) throws IOException{
		this.ctrl = ctrl;
		initGUI();
	}
	
	/**
	 * Inits the gui.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void initGUI() throws IOException{
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Input Panel"));
		inputTextArea = new JTextArea(10, 15);
		inputTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
		inputTextArea.setEditable(false);
		
		InStrategy inCurr = ctrl.getInStream();
		InStrategy inNew = new InStreamGUI(inCurr, inputTextArea);
		ctrl.setInStream(inNew);
		
		this.add(new JScrollPane(inputTextArea));
		

	}
	
	/**
	 * The Class InStreamGUI.
	 */
	private class InStreamGUI implements InStrategy {
		
		/** The input text area. */
		JTextArea inputTextArea;
		
		/** The old. */
		InStrategy old;
		
		/** The content. */
		StringBuilder content = new StringBuilder();
		
		/** The pos. */
		int pos;
		
		/**
		 * Instantiates a new in stream gui.
		 *
		 * @param old the old
		 * @param inputTextArea the input text area
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public InStreamGUI(InStrategy old, JTextArea inputTextArea) throws IOException{
			this.old = old;
			this.inputTextArea = inputTextArea;
			int c = 0;
			pos = 0;
			ctrl.setInStream(old);
			
			
			
			while(c != -1 ){
				c = old.read();
				if(c != -1)
					content.append((char)c);
			}
			
			  inputTextArea.setText(content.toString());
		}
		
		/* (non-Javadoc)
		 * @see tp.pr2.mv.MVSystem.InStrategy#open()
		 */
		@Override
		public void open() throws FileNotFoundException {
			
		}

		/* (non-Javadoc)
		 * @see tp.pr2.mv.MVSystem.InStrategy#close()
		 */
		@Override
		public void close() throws IOException {
			old.close();
			
		}

		/* (non-Javadoc)
		 * @see tp.pr2.mv.MVSystem.InStrategy#read()
		 */
		@Override
		public int read() throws IOException {
			int c = 0;
			if(pos != content.length()){
		
				c = content.codePointAt(pos);
				if(c!=10 && c!=13)
					content.setCharAt(pos, '*');
				inputTextArea.setText(content.toString());
				pos ++;
				return c;
			}
			else
				return -1;
			
		}

	}
}

