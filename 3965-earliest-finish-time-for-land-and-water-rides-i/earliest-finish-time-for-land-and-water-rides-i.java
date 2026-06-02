class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            
            int land = landStartTime[i] + landDuration[i];

            for(int j = 0; j < m; j++){

                if(waterStartTime[j] == land){
                    min = Math.min(min, waterDuration[j] + waterStartTime[j]);
                }

                if(waterStartTime[j] < land){
                    min = Math.min(min, land + waterDuration[j]);
                }

                
                if(waterStartTime[j] > land){
                    min = Math.min(min, waterStartTime[j] + waterDuration[j]);
                }
            }
        }



            for(int i = 0; i < m; i++){
            
            int land = waterStartTime[i] + waterDuration[i];

            for(int j = 0; j < n; j++){

                if(landStartTime[j] == land){
                    min = Math.min(min, landDuration[j] + landStartTime[j]);
                }

                if(landStartTime[j] < land){
                    min = Math.min(min, land + landDuration[j]);
                }

                if(landStartTime[j] > land){
                    min = Math.min(min, landStartTime[j] + landDuration[j]);
                }
            }
            }

        return min;
    }
}