class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the starting position
        result[0] = findFirstPosition(nums, target);

        // If the starting position is not found, return immediately
        if (result[0] == -1) {
            return result;
        }

    
        result[1] = findLastPosition(nums, target);

        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (nums.length > 0 && nums[left] == target) ? left : -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }
}
