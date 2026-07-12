class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int a[]=new int[arr.length];
        HashMap<Integer,Integer> hs=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            a[i]=arr[i];
            hs.put(arr[i],-1);
        }
        Arrays.sort(a);
        int p=1;
        for(int j=0;j<a.length;j++){
            if(hs.get(a[j])==-1){
                hs.put(a[j],p++);
            }
            
        }

        for(int k=0;k<arr.length;k++){
            arr[k]=hs.get(arr[k]);
        }
        return arr;

    }
}