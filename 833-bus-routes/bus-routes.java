class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        for (int route = 0; route < routes.length; route++) {
            for (int stop : routes[route]) {
                stopToRoutes
                    .computeIfAbsent(stop, k -> new ArrayList<>())
                    .add(route);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();

        queue.offer(source);
        visitedStops.add(source);

        int busesTaken = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            busesTaken++;

            for (int i = 0; i < size; i++) {

                int currentStop = queue.poll();

                List<Integer> routesFromStop = stopToRoutes.get(currentStop);

                if (routesFromStop == null) {
                    continue;
                }

                for (int route : routesFromStop) {

                    if (visitedRoutes.contains(route)) {
                        continue;
                    }

                    visitedRoutes.add(route);

                    for (int nextStop : routes[route]) {

                        if (nextStop == target) {
                            return busesTaken;
                        }

                        if (visitedStops.add(nextStop)) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}