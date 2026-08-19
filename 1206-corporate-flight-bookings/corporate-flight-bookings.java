class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        // n + 2 so we can safely use last + 1
        int[] arr = new int[n + 2];

        // Create difference array
        for (int[] booking : bookings) {

            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            // Add seats from first flight
            arr[first] += seats;

            // Remove seats after last flight
            arr[last + 1] -= seats;
        }

        // Prefix sum
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        // Convert 1-based array to required 0-based answer
        int[] ans = new int[n];

        for (int i = 1; i <= n; i++) {
            ans[i - 1] = arr[i];
        }

        return ans;
    }
}