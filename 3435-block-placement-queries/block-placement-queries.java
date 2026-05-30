class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int rmax = 500001;

        SegmentTree st = new SegmentTree(rmax);
        TreeSet<Integer> tset = new TreeSet<>();
        List<Boolean> ans = new ArrayList<>();

        tset.add(0);
        tset.add(rmax);

        st.insert(rmax, rmax);

        for (int[] q : queries) {

            if (q[0] == 1) {
                int x = q[1];

                int left = tset.lower(x);
                int right = tset.higher(x);

                tset.add(x);

                st.insert(x, x - left);
                st.insert(right, right - x);

            } else {

                int x = q[1];
                int size = q[2];

                int prev = tset.lower(x);

                int maxGap = st.query(0, prev);

                int max = Math.max(maxGap, x - prev);

                ans.add(size <= max);
            }
        }

        return ans;
    }
}

class SegmentTree {
    int[] seg;
    int size;

    SegmentTree(int size) {
        this.size = size;
        this.seg = new int[4 * (size + 1)];
    }

    private void insert(int idx, int val, int curr, int l, int r) {
        if (l == r) {
            seg[curr] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            insert(idx, val, curr * 2, l, mid);
        } else {
            insert(idx, val, curr * 2 + 1, mid + 1, r);
        }

        seg[curr] = Math.max(seg[curr * 2], seg[curr * 2 + 1]);
    }

    private int query(int ql, int qr, int curr, int l, int r) {

        if (ql <= l && r <= qr) {
            return seg[curr];
        }

        int mid = l + (r - l) / 2;
        int ans = 0;

        if (ql <= mid) {
            ans = Math.max(ans, query(ql, qr, curr * 2, l, mid));
        }

        if (qr > mid) {
            ans = Math.max(ans, query(ql, qr, curr * 2 + 1, mid + 1, r));
        }

        return ans;
    }

    void insert(int idx, int val) {
        insert(idx, val, 1, 0, size);
    }

    int query(int left, int right) {
        return query(left, right, 1, 0, size);
    }
}