class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n]; // safe size
        build(nums, 0, 0, n - 1);
    }

    // Build Segment Tree
    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start]; // leaf node
        } else {
            int mid = (start + end) / 2;

            build(nums, 2 * node + 1, start, mid);       // left child
            build(nums, 2 * node + 2, mid + 1, end);     // right child

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Update value
    public void update(int index, int val) {
        updateHelper(0, 0, n - 1, index, val);
    }

    private void updateHelper(int node, int start, int end, int index, int val) {
        if (start == end) {
            tree[node] = val; // update leaf
        } else {
            int mid = (start + end) / 2;

            if (index <= mid) {
                updateHelper(2 * node + 1, start, mid, index, val);
            } else {
                updateHelper(2 * node + 2, mid + 1, end, index, val);
            }

            // Recalculate after update
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Range Sum Query
    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right) {

        // No overlap
        if (right < start || end < left) {
            return 0;
        }

        // Total overlap
        if (left <= start && end <= right) {
            return tree[node];
        }

        // Partial overlap
        int mid = (start + end) / 2;

        int leftSum = query(2 * node + 1, start, mid, left, right);
        int rightSum = query(2 * node + 2, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}