class Solution {
    
    int perform(int x, int y, char op) {
        if (op == '+') return x + y;
        if (op == '-') return x - y;
        if (op == '*') return x * y;

        return 0;
    }

    public List<Integer> diffWaysToCompute(String exp) {

        List<Integer> results = new ArrayList<>();
        boolean isNumber = true;

        for (int i = 0; i < exp.length(); i++) {

            if (!Character.isDigit(exp.charAt(i))) {

                isNumber = false;

                List<Integer> left =
                    diffWaysToCompute(exp.substring(0, i));

                List<Integer> right =
                    diffWaysToCompute(exp.substring(i + 1));

                for (int x : left) {
                    for (int y : right) {

                        int val = perform(x, y, exp.charAt(i));

                        results.add(val);
                    }
                }
            }
        }

        if (isNumber) {
            results.add(Integer.parseInt(exp));
        }

        return results;
    }
}