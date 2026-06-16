class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        
        int arr1[] = new int[n + 1];
        int arr2[] = new int[n + 1];
 
        Arrays.fill(arr1, 0);
        arr2[0] = 0;

        for(int i = n; i > 0; i--){
            for(int j = 1; j < n + 1; j++){
                 
                if(s.charAt(i - 1) == s.charAt(j - 1)){
                    arr2[j] = 1 + arr1[j - 1];
                }
                else{
                    arr2[j] = Math.max(arr2[j - 1], arr1[j]);
                }
            }

            int temp[] = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        return arr1[n];
    }
}