class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // edge cases
        if (points.length == 0 || k == 0)
            return new int[k][];

        int[][] result = new int[k][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> {
            return b[1] * b[1] + b[0] * b[0] - a[1] * a[1] - a[0] * a[0];
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        while (k > 0) {
            result[--k] = maxHeap.poll();
        }

        return result;
    }
}