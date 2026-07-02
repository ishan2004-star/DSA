class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        Arrays.sort(piles);
        
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);

        }

        return search(1, max, h, piles);
    }

    public int search(int left, int right, int hour, int[] piles){

        while(left <= right){

            int mid = left + (right - left)/2;

            if(canDo(mid, hour, piles)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canDo(int mid, int hour, int[] piles){

        long hours = 0;

        for(int i = piles.length - 1; i >= 0; i--){

            if(piles[i] > mid){
                hours += (int)Math.ceil((double)piles[i]/mid);
                if(hours > hour) return false;
            }
            else{
                hours += i + 1;
                break;
            }
        }

        return hours <= hour;
    }
}
