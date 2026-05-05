/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        
        int peak = findPeak(arr);

        int left = binarySearch(arr, target, 0, peak, true);
        if (left != -1) return left;

        return binarySearch(arr, target, peak + 1, arr.length() - 1, false);
    }

    private int findPeak(MountainArray arr) {
        int left = 0, right = arr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int binarySearch(MountainArray arr, int target, int left, int right, boolean isAsc) {
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (isAsc) {
                if (val < target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (val < target) right = mid - 1;
                else left = mid + 1;
            }
        }

        return -1;
    }
}