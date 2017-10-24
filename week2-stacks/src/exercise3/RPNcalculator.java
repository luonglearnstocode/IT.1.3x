package exercise3;

import java.util.Stack;

public class RPNcalculator{

    /*
     * Implement a simple RPN calculator
     * with an Stack
     * this is a possible solution, others are
     * also possible
     */
    public static int calculate(String ops[]){
	    int result = 0;
	    int x,y;
	    String operators = new String("+-/*");
	    // Define a Stack 
	    Stack<Integer> stack = new Stack<>();
	    
	    for (String op: ops){
            // Implement here your algorithm
	    	if (operators.contains(op)) {
	    		if (stack.size() < 2)
	    			return 0;
	    		
	    		x = stack.pop();
	    		y = stack.pop();
	    		
	    		if (op.equals("+"))
	    			stack.push(y + x);
	    		else if (op.equals("-"))
	    			stack.push(y - x);
	    		else if (op.equals("*"))
	    			stack.push(y * x);
	    		else if (op.equals("/"))
	    			stack.push(y / x);
	    		
	    	} else { // number
	    		stack.push(Integer.parseInt(op));
	    	}
	    }

        // if the stack is not empty, result= stack.pop()
        // else result = 0
	    result = (stack.isEmpty() ? 0 : stack.pop());
	    return result;
    }
    public static void main(String args[]){
        /*
	     * The main program should print
	        5 3 + =8
            5 3 - = 2
            2 1 12 3 / - + = -1
            3 2 * 11 - = -5
	    */
	    
	    String[] argu= new String[]{"5","3","+"};
	    int result = calculate(argu);
	    System.out.println("5"+" 3"+" +"+" ="+ result);
	    result = calculate(new String[]{"5","3","-"});
	    System.out.println("5"+" 3"+" -"+" = "+ result);
    	result = calculate(new String[]{"2","1","12","3","/", "-", "+"});
	    System.out.println("2"+" 1"+" 12"+" 3"+" /"+ " -"+ " +"+" = "+ result);
	    result = calculate(new String[]{"3", "2", "*", "11", "-"});
	    System.out.println("3"+" 2"+" *"+" 11"+" -"+" = "+ result);
	     
    }
}

