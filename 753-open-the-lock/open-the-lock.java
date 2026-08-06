class Solution {
    public int openLock(String[] deadends, String target) {
        
        String str = "0000";

        int steps = 0;

        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < deadends.length; i++){
            hs.add(deadends[i]);
        }

        q.add(str);

        while(!q.isEmpty()){

            int size = q.size();

            for(int j = 0; j < size; j++){


            String lock = q.poll();

            if(hs.contains(lock)) continue;

            if(lock.equals(target)) return steps;

            hs.add(lock);

            int next = -1;
            int prev = -1;

            for(int i = 0; i < 4; i++){
                
                next = (lock.charAt(i) - '0') + 1;
                prev = (lock.charAt(i) - '0') - 1;

                if(next == 10) next = 0;
                if(prev == -1) prev = 9;

                String s1 = lock.substring(0, i) + Integer.toString(next) + lock.substring(i + 1);

                String s2 = lock.substring(0, i) + Integer.toString(prev) + lock.substring(i + 1);

                q.add(s1);
                q.add(s2);

            }
            }

            steps++;
        }

        return -1;

    }
}