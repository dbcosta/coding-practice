package practice.java8;

/**
 * Given an expression string exp, write a program to examine whether the pairs
 * and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.
 */
public class BalancedBrackets {

    private boolean isValid(String bracketString){
        if(null == bracketString || bracketString.length()%2!=0){
            return false;
        }else{
            for(char c:bracketString.toCharArray()){
                if(!(c=='{'|| c=='[' || c=='(' || c==')' || c==']' || c=='}')){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBalanced(String bracketString){
        if(isValid(bracketString)){
            while(bracketString.contains("()") || bracketString.contains("{}") || bracketString.contains("[]")){
                bracketString = bracketString.replaceAll("\\(\\)","")
                        .replaceAll("\\{\\}","")
                        .replaceAll("\\[\\]","");
            }
        }
        return bracketString.length()==0;
    }

    public static void main(String[] args) {
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        String bracketString = "([{{[(())]}}])";
        System.out.println(balancedBrackets.isBalanced(bracketString));
    }
}


