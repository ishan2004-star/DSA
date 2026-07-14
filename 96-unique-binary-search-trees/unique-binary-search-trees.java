class Solution {
    public int numTrees(int n) {
        return partition(1,n);
    }

    public int partition(int start, int end){

        if(start >= end) return 1;

        int ans = 0;

        for(int i = start; i <= end; i++){

            int left = partition(start, i - 1);
            int right = partition(i + 1, end);

            ans += left * right;
        }

        return ans;
    }
}