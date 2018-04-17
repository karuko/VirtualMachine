package tp.pr2.mv.BooleanCondition;

import tp.pr2.mv.Instructions.Instruction;


// TODO: Auto-generated Javadoc
/**
 * The Class And.
 */
public class And extends BooleanCond
{
   
   /* (non-Javadoc)
    * @see tp.pr2.mv.BooleanCondition.BooleanCond#ExecuteAux(int, int)
    */
   protected boolean ExecuteAux(int cima,int subcima) 
   {
       int a = cima & subcima;
       
       if(a == 1)
           return true;
       
       else
    	   return false;
   }
   
   /* (non-Javadoc)
    * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
    */
   public Instruction parse(String[] s) {
       
       if (s.length == 1 && s[0].equalsIgnoreCase("AND")) 
           return new And();
       
       else return null;
   }
  
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString(){
       return "AND";
   }
}
