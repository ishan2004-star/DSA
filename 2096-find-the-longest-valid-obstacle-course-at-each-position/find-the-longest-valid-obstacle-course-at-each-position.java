class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        
        int n = obstacles.length;

        int[] dp = new int[n];
        int[] store = new int[n];
        int idx = 0;

        for(int i = 0; i < obstacles.length; i++){

            int obstacles_height = obstacles[i];

            int get_index = binary_search(0, idx, store, obstacles_height);

            if(get_index == idx) idx++;

            store[get_index] = obstacles_height;

            dp[i] = get_index + 1;

        }

        return dp;
    }

    public int binary_search(int left, int right, int[] store, int obstacles_height){

        while(left < right){

            int mid = left + (right - left)/2;

            if(store[mid] <= obstacles_height){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}