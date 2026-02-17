import java.util.*;

class Solution {

    // max heap → chhote elements (left half)
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());

    // min heap → bade elements (right half)
    PriorityQueue<Integer> large = new PriorityQueue<>();

    // lazy deletion map
    HashMap<Integer, Integer> delayed = new HashMap<>();

    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] res = new double[n - k + 1];

        for (int i = 0; i < n; i++) {

            // ✅ new element add karo
            addNum(nums[i]);

            // ✅ window se bahar wala remove karo
            if (i >= k) {
                removeNum(nums[i - k]);
            }

            // ✅ jab window ready ho jaye
            if (i >= k - 1) {
                res[i - k + 1] = getMedian(k);
            }
        }

        return res;
    }

    // 🔹 add number
    private void addNum(int num) {

        // decide kis heap me jayega
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        balance();
    }

    // 🔹 remove number (lazy deletion)
    private void removeNum(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek()) prune(small);
        } else {
            largeSize--;
            if (num == large.peek()) prune(large);
        }

        balance();
    }

    // 🔹 heaps balance karo
    private void balance() {

        // small jyada bada ho gaya
        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        }

        // large jyada bada ho gaya
        else if (smallSize < largeSize) {
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }

    // 🔹 delayed elements hatao top se
    private void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {
            int num = heap.peek();

            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);

                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }

                heap.poll();
            } else {
                break;
            }
        }
    }

    // 🔹 median nikalo
    private double getMedian(int k) {

        if (k % 2 == 1) {
            return small.peek(); // odd case
        }

        return ((double) small.peek() + large.peek()) / 2.0; // even case
    }
}
