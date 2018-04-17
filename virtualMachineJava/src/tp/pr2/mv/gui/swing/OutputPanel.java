package tp.pr2.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr2.mv.Controlers.Controler;
import tp.pr2.mv.MVSystem.OutStrategy;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.MemoryObserver;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.StackObserver;

// TODO: Auto-generated Javadoc
/**
 * The Class OutputPanel.
 */
@SuppressWarnings("serial")
public class OutputPanel extends JPanel {
	
	/** The ctrl. */
	private Controler ctrl;
	
	/** The output text area. */
	private JTextArea outputTextArea;
	
	/**
	 * Instantiates a new output panel.
	 *
	 * @param ctrl the ctrl
	 */
	OutputPanel(Controler ctrl){
		this.ctrl = ctrl;
		initGUI();
	}
	 
 	/**
 	 * Instantiates a new output panel.
 	 *
 	 * @param cpu the cpu
 	 * @param stack the stack
 	 * @param memory the memory
 	 */
 	OutputPanel(Observable<CPUObserver> cpu,
			Observable<StackObserver<Integer>> stack,
			Observable<MemoryObserver<Integer>> memory) {
		
	}
	
	/**
	 * Inits the gui.
	 */
	private void initGUI(){
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Output Panel"));
		outputTextArea = new JTextArea(10, 15);
		outputTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
		outputTextArea.setEditable(false);
		
		OutStrategy outCurr = ctrl.getOutStream();
		OutStrategy outNew = new OutStreamGUI(outCurr, outputTextArea);
		ctrl.setOutStream( outNew );
		
		this.add(new JScrollPane(outputTextArea));
	}
	
	/**
	 * The Class OutStreamGUI.
	 */
	private class OutStreamGUI implements OutStrategy{
		
		/** The output text area. */
		JTextArea outputTextArea;
		
		/** The old. */
		OutStrategy old;
		
		/**
		 * Instantiates a new out stream gui.
		 *
		 * @param old the old
		 * @param outputTextArea the output text area
		 */
		public OutStreamGUI(OutStrategy old, JTextArea outputTextArea){
			this.old = old;
			this.outputTextArea = outputTextArea;
			
		}

		/* (non-Javadoc)
		 * @see tp.pr2.mv.MVSystem.OutStrategy#open()
		 */
		@Override
		public void open() throws IOException {
			
		}

		/* (non-Javadoc)
		 * @see tp.pr2.mv.MVSystem.OutStrategy#close()
		 */
		@Override
		public void close() throws IOException {
			old.close();	
		}

		/* (non-Javadoc)
		 * @see tp.pr2.mv.MVSystem.OutStrategy#write(int)
		 */
		@Override
		public void write(int c) throws IOException {
			// 1. pasar c al OutStrategy original
			old.write(c);
			outputTextArea.append(String.valueOf((char)c));
			
			 // 2. concatenar c al contenido del outputTextArea 

			
		}
	}
}
