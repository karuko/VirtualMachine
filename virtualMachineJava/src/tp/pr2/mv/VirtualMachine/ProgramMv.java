package tp.pr2.mv.VirtualMachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


import tp.pr2.mv.Exceptions.CmdLineException;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.Instructions.ParseInstruction;

// TODO: Auto-generated Javadoc
/**
 * The Class ProgramMv.
 */
public class ProgramMv 
{

	/** La constante MAX_PROGRAM. */
	static private final int MAX_PROGRAM = 100;
	
	/** El programa principal. */
	private Instruction[] program;
	
	/** El numero de  instrucciones. */
	private int numberInstructions;
	
	/** Tamaño del programa. */
	private int sizeProgram;


	/**
	 * Constructora .
	 */
	public ProgramMv() 
	{
		numberInstructions = 0;
		sizeProgram = 10;
		program = new Instruction[sizeProgram];
	}

	/**
	 * Redimensionar.
	 *
	 * @return true, si se realiza correctamente
	 */
	private boolean resize() 
	{
		boolean cierto = false;
		if (sizeProgram < MAX_PROGRAM) {
			Instruction[] p2 = new Instruction[sizeProgram * 2];
			
			for (int i = 0; i < sizeProgram; i++) 
				p2[i] = program[i];
			
			sizeProgram = sizeProgram * 2;
			program = p2;
			cierto = true;
		}
    return cierto;
	}
	
	/**
	 * Push.
	 *
	 * @param instr the instruction
	 */
	public void push(Instruction instr) 
	{
        boolean cierto = true;
        if (numberInstructions >= sizeProgram)
            cierto = resize();
        
        if (cierto) 
        {
            program[numberInstructions] = instr;
            numberInstructions++;
        } 
        else 
            System.out.println("Tamaño del programa excedido. TAM: " + sizeProgram);
        
    }
	
	/**
	 * Gets the instruction.
	 *
	 * @param i the i
	 * @return instruction
	 */
	public Instruction get(int i) {
        
        if (i < numberInstructions) 
            return program[i];
        
        else
        	return null;
    }
	
	/**
	 * Coge el tamaño del programa.
	 *
	 * @return size program
	 */
	public int getSizeProgram() 
	{ 
		return this.numberInstructions;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = "";
        if (this.sizeProgram > 0) 
        {
            for (int i = 0; i < this.numberInstructions; i++) 
            {
                String line = i + ": " + program[i].toString() + "\n";
                s += line;
            }
        }
        return s;
	}
	
	/**
	 * Lee el programa escrito antes de ejecutarlo.
	 *
	 * @return the program mv
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static ProgramMv readProgram() throws IOException 
			{
					
				InputStreamReader isr = new InputStreamReader(System.in);
			    BufferedReader br = new BufferedReader(isr);
			    
			    String orden;
			    ProgramMv program = new ProgramMv();
			    Instruction inst = null;
			    boolean start = true;
			    System.out.println("Introduce el programa fuente");
			    
			   
				while (start) 
			    {
			        System.out.print("> ");
			        orden = br.readLine();
			        inst = ParseInstruction.parser(orden);
			        
			        if (inst != null) 
			            program.push(inst);
			        
			         else if (orden.equalsIgnoreCase("end")) 
			            start = false;
			        
			         else 
			            System.out.println("Instrucción incorrecta");
			        
			    }
		
			    return program;
			}
		/**
		 * Read program file.
		 *
		 * @param fname the fname
		 * @return the program mv
		 */
		
	@SuppressWarnings("resource")
	public static ProgramMv readProgramFile(String fname)
		{ 
			        ProgramMv program = new ProgramMv();
			        String line = "";
			        int aux=0;
			        if(fname != null) { 
			            BufferedReader reader;
			            try 
			            {
			                reader = new BufferedReader(new FileReader(fname));
			                while(reader.ready()) 
			                {//mientras no se llegue al final del fichero
			                    line = reader.readLine().trim();//guardamos la linea leida
			                    if (line.length()!=0 && line.charAt(0) != ';')
			                    {
			                        if (line.indexOf(';') > 0)
			                        {
			                            aux =line.indexOf(';');
			                            line = line.substring(0, aux);
			                        
			                        }
			                       
			                        if(ParseInstruction.parser(line) == null) throw new CmdLineException("Error en linea: " + line);
			                        else if( ParseInstruction.parser(line) != null)
		                            program.push(ParseInstruction.parser(line));
			                    }
			                }
			            } catch (FileNotFoundException e) { 
			                System.err.println(e + "\nFichero no encontrado." + " Indique una ruta valida."); //si la ruta no es correcta
			            } catch (IOException e) { 
			                System.err.println (e + "\nError de hardware. " + " Consulte la documentacion.");// otro tipo de problemas
			            }
			        }
			        return program;
		}
}


