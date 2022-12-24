class Solution {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        //Handle edge cases.
        if (size == 0) {
            return new int[]{-1, -1};
        }
        if (size == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        // init binary search
        int low = 0;
        int high = size - 1;
        // Holds first, and last seen target index.
        int first = -1;
        int last = -1;
        //Iterative Binary Search
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (target == nums[middle]) {
                first = middle; // first, last set to where we saw the element.
                last = middle;
                break;
            } else if (target > nums[middle]) { 
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        
        if (first == -1) { // If the element never showed
            return new int[]{-1, -1};
        }

        //Otherwise, the element did show up.
        //We check all left most neighbors to find the first 
        //instance of our target
        int i = first - 1;
        while (i >= 0 && nums[i] == target) {
            first = i;
            i--;
        }
        //We check all right most neighbors to find the last 
        //instance of our target
        i = last + 1;
        while (i < size && nums[i] == target) {
            last = i;
            i++;
        }
        // Finally, we return :)
        return new int[]{first, last};
    }
}
