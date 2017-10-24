package exercise2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchingParenthesis{
    
    /*
    * You should change the code to work with any kind of
    * parenthesis {} () []
    */
    
    public static boolean balanced(String mystring){
        Stack<Character> stack = new Stack<Character>();
	    char c;
	    char fromStack;
	    
	    Map<Character, Character> matchingParenthesis = new HashMap<>();
	    matchingParenthesis.put('(', ')');
	    matchingParenthesis.put('{', '}');
	    matchingParenthesis.put('[', ']');
	    
	    for (int i=0; i < mystring.length();i++){
	        c = mystring.charAt(i);
	        if (matchingParenthesis.containsKey(c)){
		        stack.push(c);
	        }
	        else if (matchingParenthesis.containsValue(c)){
		        if (stack.isEmpty()){
    		        return false;
	    	    }
		        fromStack = stack.pop();
		        if (c != matchingParenthesis.get(fromStack)){
		            return false;
		        }
	        }
        }
	    return stack.isEmpty();
    }
    
    public static void main(String args[]){

	    System.out.println("(())"+" balanced? "+balanced("(())"));
	    System.out.println("((1,b,c))"+" balanced? "+balanced("((1,b,c))"));
	    System.out.println("((1),(b,c))"+" balanced? "+balanced("((1),(b,c))"));
	    System.out.println("((1)),(b,c))"+" balanced? "+balanced("((1)),(b,c))"));
	    System.out.println("((1,(b,c)))"+" balanced? "+balanced("((1,(b,c)))"));
	    System.out.println("((1),(b,c)))"+" balanced? "+balanced("((1),(b,c)))"));
	    System.out.println(""+" balanced? "+balanced(""));
	    /*Your code should work also with these strings:*/
	    /*For this one the condition is true*/
	    System.out.println("(([]{}))"+" balanced? "+balanced("(([]{}))"));
	    /*For this one the condition is false*/
	    System.out.println("(([]]{}}))"+" balanced? "+balanced("(([]]{}}))"));
    }
}

