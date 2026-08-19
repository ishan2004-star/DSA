class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int families = 0;

        int length = reservedSeats.length;

        int left_block = 1;
        int mid_block = 1;
        int right_block = 1;

        
        Arrays.sort(reservedSeats, (a,b) -> {
            return a[0] - b[0];
        });

        if(reservedSeats[0][0] - 1 > 0){
            families += (reservedSeats[0][0] - 1) * 2;
        }

        for(int i = 0; i < length; i++){

            int row = reservedSeats[i][0];

            if(i != 0 && reservedSeats[i - 1][0] != row){

                int gap = row - reservedSeats[i - 1][0] - 1;

                if(gap > 0){
                    families += gap * 2;
                }

                families += Math.max(mid_block, left_block + right_block);

                left_block = 1;
                mid_block = 1;
                right_block = 1;
            }
            
            int seat = reservedSeats[i][1];

            if(seat >= 2 && seat <= 5){
                left_block = 0;
            }
            if(seat >= 4 && seat <= 7){
                mid_block = 0;
            }
            if(seat >= 6 && seat <= 9){
                right_block = 0;
            }
        }

        families += Math.max(mid_block, left_block + right_block);

        int gap = n - reservedSeats[length - 1][0];

        if(gap > 0){
            families += gap * 2;
        }

        return families;
    }
}