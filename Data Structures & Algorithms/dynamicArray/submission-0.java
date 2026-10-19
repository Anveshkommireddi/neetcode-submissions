class DynamicArray {

    int[] nums;
    int curr_idx;

    public DynamicArray(int capacity) {
        this.nums = new int[capacity];
        this.curr_idx = -1;
    }

    public int get(int i) {
        return nums[i];
    }

    public void set(int i, int n) {
        this.nums[i] = n;
    }

    public void pushback(int n) {
        if(curr_idx == nums.length - 1) {
            resize();
        }
        this.nums[++curr_idx] = n;
    }

    public int popback() {
        int curr_num = this.nums[curr_idx--];
        return curr_num;
    }

    private void resize() {
        int new_capacity = 2 * nums.length;
        int[] new_nums = new int[new_capacity];
        for(int idx = 0; idx <= curr_idx; idx++) {
            new_nums[idx] = nums[idx];
        }
        this.nums = new_nums;
    }

    public int getSize() {
        return this.curr_idx + 1;
    }

    public int getCapacity() {
        return this.nums.length;
    }
}
