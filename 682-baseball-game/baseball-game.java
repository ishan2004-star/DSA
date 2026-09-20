class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (String op : operations) {

            if (op.equals("+")) {
                int first = stack.pop();
                int second = stack.pop();

                int sum = first + second;

                stack.push(second);
                stack.push(first);
                stack.push(sum);

                result += sum;

            } else if (op.equals("D")) {
                int top = stack.peek();

                int doubled = top * 2;
                stack.push(doubled);

                result += doubled;

            } else if (op.equals("C")) {
                int removed = stack.pop();

                result -= removed;

            } else {
                int num = Integer.parseInt(op);

                stack.push(num);
                result += num;
            }
        }

        return result;
    }
}