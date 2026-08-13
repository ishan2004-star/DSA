class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int maximum;
        int length;

        Node(char leftChar, char rightChar,
                int prefix, int suffix, int maximum, int length) {

            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.maximum = maximum;
            this.length = length;
        }
    }

    Node[] tree;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        tree = new Node[4 * n];

        build(0, 0, n - 1, s);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(0, 0, n - 1, index, ch);

            ans[i] = tree[0].maximum;
        }

        return ans;
    }

    void build(int node, int start, int end, String s) {

        if (start == end) {

            char ch = s.charAt(start);

            tree[node] = new Node(
                    ch,
                    ch,
                    1,
                    1,
                    1,
                    1);

            return;
        }

        int mid = start + (end - start) / 2;

        build(2 * node + 1, start, mid, s);
        build(2 * node + 2, mid + 1, end, s);

        tree[node] = merge(
                tree[2 * node + 1],
                tree[2 * node + 2]);
    }

    Node merge(Node left, Node right) {

        char leftChar = left.leftChar;
        char rightChar = right.rightChar;

        int prefix;
        int suffix;

        if (left.rightChar == right.leftChar) {

            if (left.prefix == left.length) {
                prefix = left.length + right.prefix;
            } else {
                prefix = left.prefix;
            }

            if (right.suffix == right.length) {
                suffix = right.length + left.suffix;
            } else {
                suffix = right.suffix;
            }

        } else {

            prefix = left.prefix;
            suffix = right.suffix;
        }

        int maximum = Math.max(left.maximum, right.maximum);

        if (left.rightChar == right.leftChar) {

            maximum = Math.max(
                    maximum,
                    left.suffix + right.prefix);
        }

        return new Node(
                leftChar,
                rightChar,
                prefix,
                suffix,
                maximum,
                left.length + right.length);
    }

    void update(
            int node,
            int start,
            int end,
            int index,
            char ch) {

        if (start == end) {

            tree[node] = new Node(
                    ch,
                    ch,
                    1,
                    1,
                    1,
                    1);

            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {

            update(
                    2 * node + 1,
                    start,
                    mid,
                    index,
                    ch);

        } else {

            update(
                    2 * node + 2,
                    mid + 1,
                    end,
                    index,
                    ch);
        }

        tree[node] = merge(
                tree[2 * node + 1],
                tree[2 * node + 2]);
    }
}