class Solution {
    public boolean asteroidsDestroyed(long mass, int[] asteroids) {
        
        TreeMap<Long, Long> map = new TreeMap<>();

        for(int i = 0; i < asteroids.length; i++){

            int asteroid = asteroids[i];
            
            map.put((long)asteroid, map.getOrDefault((long)asteroid, 0L) + 1);
        }

        boolean flag = true;

        while(flag){

            Long asteroid = map.floorKey(mass);

            if(asteroid == null){
                return map.size() == 0;
            }

            if(map.get(asteroid) == 1)
                map.remove(asteroid);
            else
                map.put(asteroid, map.get(asteroid) - 1);

            mass += asteroid;

        }

        return true || false;

    }
}