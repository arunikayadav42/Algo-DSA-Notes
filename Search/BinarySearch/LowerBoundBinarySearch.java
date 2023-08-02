/**
 * smallest index such that arr[i] >= x
 * Array must be sorted in ascending order
 * O(logn) for binary search
 * https://www.youtube.com/watch?v=6zhGS79oQ4k&t=19s&ab_channel=takeUforward
 */
public class LowerBoundBinarySearch {
    private static int lowerBound(int[] arr, int target, int n) {
        int l = 0, r = n-1, ans = n;

        while(l <= r) {
            int mid = l + (r-l)/2;

            //smallest index such that arr[i] >= x
            if(arr[mid] >= target) {
                //store the ans as that might be a possibility
                ans = mid;
                //reduce the search space
                r = mid-1;
            } else {
                //we dont update the ans as arr[mid] is not greater than target
                l = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        System.out.println(lowerBound(arr, 9, arr.length));
    }
}
