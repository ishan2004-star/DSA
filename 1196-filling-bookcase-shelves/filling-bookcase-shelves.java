class Solution {
    Integer dp[];
    public int minHeightShelves(int[][] books, int shelfWidth) {

        int n = books.length;

        dp = new Integer[n];
        
        return minHeight(books, shelfWidth, 0);
    }

    public int minHeight(int[][] books, int width, int index){

        if(index == books.length) return 0;

        if(dp[index] != null) return dp[index];

        int total_width = 0;
        int max_height = 0;
        int res = Integer.MAX_VALUE;

        for(int i = index; i < books.length; i++){

            total_width += books[i][0];

            if(total_width > width) break;

            max_height = Math.max(books[i][1], max_height);

            res = Math.min(res, max_height + minHeight(books, width, i + 1));
            
        }

        return dp[index] = res;
    }
}