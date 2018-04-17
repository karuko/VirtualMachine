package tp.pr2.mv.Instructions;

import tp.pr2.mv.Arithmetics.*;
import tp.pr2.mv.Jumps.*;
import tp.pr2.mv.RestSeq.*;
import tp.pr2.mv.NumericCond.*;
import tp.pr2.mv.BooleanCondition.*;


// TODO: Auto-generated Javadoc
/**
 * The Class ParseInstruction.
 */
public class ParseInstruction 
{
	
	/** The instruction. */
	static Instruction instruction;
	
	/** The instruction set. */
	private static Instruction instructionSet[] = {
	 new Push(), new Sub(), new Mul(), new Div(), new Neg(), new Dup(), new Flip(), new Load(),new LoadInd(), new Pop(), new Add(), new Store(), new StoreInd(),
	 new Jump(),new RJump(), new JumpInd(), new Bf(), new RBf(), new Bt(), new RBt(), new And(), new Not(), new Or(), new Out() , new In(), new Equal(),
	 new GreaterThan(), new LessOrEqual(), new LessThan(),new Halt()
	 };
	
	
	
	/**
	 * Parseo de la instruccion.
	 *
	 * @param line the line
	 * @return  instruction
	 */
	public static Instruction parser(String line)
	{
		Instruction inst = null;
		int i = 0;
		boolean stop = false;
	
		while (i < ParseInstruction.instructionSet.length && !stop)
		{
			String[] components = line.split(" ");
			inst = ParseInstruction.instructionSet[i].parse(components);
			
			if (inst != null) 
				stop = true;
			else 
				i++;
	 
		}
		return inst;
	}
}


