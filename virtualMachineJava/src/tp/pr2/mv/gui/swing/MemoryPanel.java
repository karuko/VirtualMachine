package tp.pr2.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import tp.pr2.mv.Controlers.Controler;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.Memory;
import tp.pr2.mv.VirtualMachine.MemoryObserver;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.OperandStack;
import tp.pr2.mv.VirtualMachine.ProgramMv;


// TODO: Auto-generated Javadoc
/**
 * The Class MemoryPanel.
 */
@SuppressWarnings("serial")
public class MemoryPanel extends JPanel implements MemoryObserver<Integer>, CPUObserver{
	
	/** The ctrl. */
	private Controler ctrl;
	
	/** The model. */
	private MVTableModel model;
	
	/** The mem pos. */
	private JTextField memPos;
	
	/** The mem value. */
	private JTextField memValue;
	
	/** The set. */
	private JButton set;
	
	

	/**
	 * The Class MVTableModel.
	 */
	private class MVTableModel extends AbstractTableModel{

		
		/** The content. */
		TreeMap<Integer, Integer> content;
		
		/**
		 * Instantiates a new MV table model.
		 */
		public MVTableModel(){
			content = new TreeMap<Integer, Integer>();
		}
		
		/**
		 * Sets the value.
		 *
		 * @param index the index
		 * @param value the value
		 */
		public void setValue(int index, int value){
			content.put(index, value);
			fireTableDataChanged();
			
		}
		
		/**
		 * Reset.
		 */
		public void reset(){
			content.clear();
			fireTableDataChanged();
		}
		
	
		/** The col names. */
		String[] colNames = {"Addres", "Value"};

		
		/* (non-Javadoc)
		 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
		 */
		public String getColumnName(int col) {
			return colNames[col].toString();
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getColumnCount()
		 */
		@Override
		public int getColumnCount() {
			
			return colNames.length;
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getRowCount()
		 */
		@Override
		public int getRowCount() {
			
		return content.size();
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getValueAt(int, int)
		 */
		@Override
		public Object getValueAt(int row, int col) {
			
			Collection<Integer> key = content.keySet();
			int aux = 0;
			
			for(Integer i : key){
				if(aux == row){
					if(col == 0){
						return i;
					}
					else{
						return content.get(i);
					}
				}
				else aux++;
			}
			return null;
		}


	}
	//Aqui acaba la clase privada

	
	 /**
	 * Instantiates a new memory panel.
	 *
	 * @param ctrl the ctrl
	 * @param memory the memory
	 * @param cpu the cpu
	 */
	MemoryPanel(Controler ctrl,
			Observable<MemoryObserver<Integer>> memory,
			Observable<CPUObserver> cpu) {
		 
		 this.ctrl = ctrl;
		 		initGUI();
		cpu.addObserver(this);
		memory.addObserver(this);
	}

	 
	 
	/**
	 * Inits the gui.
	 */
	private void initGUI(){
		
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Memory"));
		
		model = new MVTableModel();
		JTable table = new JTable(model);
		this.add(new JScrollPane(table));
		table.setFillsViewportHeight(true);
		
		JPanel buttonsPanel = new JPanel();
		this.add(buttonsPanel, BorderLayout.PAGE_END);
		 memPos = new JTextField(5);
		 memValue = new JTextField(5);
		 
		 
		 set = new JButton("Set");
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ctrl.memorySet(memPos.getText(), memValue.getText());
			
			}
		});
		
		JLabel posName = new JLabel("Position:");
		JLabel valName = new JLabel("Value:");
		
		
	
		buttonsPanel.add(posName);	
		buttonsPanel.add(memPos);
		buttonsPanel.add(valName);
		buttonsPanel.add(memValue);
		buttonsPanel.add(set);
	
	}
	

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartInstrExecution(tp.pr2.mv.Instructions.Instruction)
	 */
	@Override
	public void onStartInstrExecution(Instruction instr) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndInstrExecution(int, tp.pr2.mv.VirtualMachine.OperandStack, tp.pr2.mv.VirtualMachine.Memory)
	 */
	@Override
	public void onEndInstrExecution(int pc, OperandStack<Integer> stack, Memory<Integer> memory) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartRun()
	 */
	@Override
	public void onStartRun() {
		set.setEnabled(false);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndRun()
	 */
	@Override
	public void onEndRun() {
		set.setEnabled(true);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onError(java.lang.String)
	 */
	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onHalt()
	 */
	@Override
	public void onHalt() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onReset(tp.pr2.mv.VirtualMachine.ProgramMv)
	 */
	@Override
	public void onReset(ProgramMv program) {
		
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.MemoryObserver#onWrite(int, java.lang.Object)
	 */
	@Override
	public void onWrite(int index, Integer value) {
		model.setValue(index, value);
		
	}



	@Override
	public void onMemReset() {
		model.reset();
		
	}
}

