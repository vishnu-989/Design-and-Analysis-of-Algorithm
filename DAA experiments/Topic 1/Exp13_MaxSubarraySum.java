public class Exp13_MaxSubarraySum {

    static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    static int maxCrossingSum(int[] arr, int left, int mid, int right) {
        int sum = 0, leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }

    static int maxSubArrayDivideConquer(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        int mid = (left + right) / 2;
        int leftMax = maxSubArrayDivideConquer(arr, left, mid);
        int rightMax = maxSubArrayDivideConquer(arr, mid + 1, right);
        int crossMax = maxCrossingSum(arr, left, mid, right);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Kadane's: " + kadane(arr));
        System.out.println("Divide and Conquer: " + maxSubArrayDivideConquer(arr, 0, arr.length - 1));
    }
}
