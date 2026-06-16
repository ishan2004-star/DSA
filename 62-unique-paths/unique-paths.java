class Solution {
    public int uniquePaths(int m, int n) {
        
        int arr1[] = new int[n];
        int arr2[] = new int[n];

        Arrays.fill(arr1, 1);

        arr2[0] = 1;

        for(int j = 1; j < m; j++){
            for(int i = 1; i < n; i++){
                arr2[i] = arr1[i] + arr2[i - 1];
            }

            int temp[] = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        return arr1[n - 1];

    }

}