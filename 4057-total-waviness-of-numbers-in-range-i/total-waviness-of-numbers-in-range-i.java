class Solution {
    public int totalWaviness(int num1, int num2) {
        
        if(num1 <= 100){
            num1 = 101;
        }

        int count = 0;

        for(int i = num1; i <= num2; i++){

            String s = Integer.toString(i);

            for(int j = 1; j < s.length() - 1; j++){

                if(s.charAt(j) < s.charAt(j - 1) && s.charAt(j) < s.charAt(j + 1)) count++;

                if(s.charAt(j) > s.charAt(j - 1) && s.charAt(j) > s.charAt(j + 1)) count++;
            }
        }

        return count;
    }
}