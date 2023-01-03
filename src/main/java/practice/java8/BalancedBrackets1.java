package practice.java8;

public class BalancedBrackets1 {

    private boolean isBalanced(String brackets) {
        if (isValid(brackets)) {
            while (brackets.contains("()") || brackets.contains("[]") || brackets.contains("{}")) {
                brackets = brackets.replaceAll("\\(\\)", "")
                                   .replaceAll("\\[\\]", "")
                                   .replaceAll("\\{\\}", "");
            }
        }
        return brackets.length() == 0;
    }

    private boolean isValid(String brackets) {
        if (brackets == null || brackets.length() % 2 != 0) {
            return false;
        } else {
            for (char c : brackets.toCharArray()) {
                if (!(c == '{' || c == '[' || c == '(' || c == ')' || c == ']' || c == '}')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String brackets = "{[{(a)}]}";
        BalancedBrackets1 balancedBrackets1 = new BalancedBrackets1();
        System.out.println(balancedBrackets1.isBalanced(brackets));
    }
}
