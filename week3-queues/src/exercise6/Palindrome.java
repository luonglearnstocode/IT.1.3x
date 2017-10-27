package exercise6;

public class Palindrome{
    public static boolean isPalindrome(String s) {
    	boolean result = true;
    	LinkedQueue<Character> queue = new LinkedQueue<>();
    	LinkedStack<Character> stack = new LinkedStack<>();
    	
    	Character c;
    	for (int i = 0; i < s.length(); i++) {
    		c = s.charAt(i);
    		if (Character.isAlphabetic(c)) {
    			queue.enqueue(Character.toLowerCase(c));
    			stack.push(Character.toLowerCase(c));
    		}
    	}
    	
    	while (!queue.isEmpty()) {
    		if (!(queue.dequeue().equals(stack.pop()))) {
    			result = false;
    			break;
    		}
    	}

    	
    	System.out.println(s + " : " + result);
    	return result;
    }
    
    public static void main(String [] args)
    {
       // TODO
    	
    	String example = "aba";
    	isPalindrome(example);
    	
       example = "A man, a plan, a canal, Panama!";
       isPalindrome(example);
       example = "Aa man, a plan, a canal, Panama!";
       isPalindrome(example);
       
       
       example = "Was it a car or a cat I saw?";
       isPalindrome(example);
       example = "Was it a carr or a cat I saw?";
       isPalindrome(example);
       
       example = "No 'x' in Nixon";
       isPalindrome(example);
       example = "No 'xx' in Nixon";
       isPalindrome(example);
       
       
       
    }
}
