class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int[] nse = new int[arr.length];
        int[] pse = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];

            while (!s1.isEmpty() && arr[s1.peek()]>curr)
                s1.pop();
            if (s1.isEmpty())
                pse[i]=-1;
            else
                pse[i]=s1.peek();

            s1.push(i);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            int curr=arr[i];

            while (!s2.isEmpty() && arr[s2.peek()] >= curr)
                s2.pop();

            if (s2.isEmpty())
                nse[i]=arr.length;
            else
                nse[i] = s2.peek();

            s2.push(i);
        }

        long ans = 0;
        long mod = 1000000007L;

        for (int i=0; i<arr.length; i++) {
            long curr = 1L * (nse[i] - i) * (i - pse[i]) * arr[i];
            ans = (ans + curr) % mod;
        }

        return (int)ans;
    }
}