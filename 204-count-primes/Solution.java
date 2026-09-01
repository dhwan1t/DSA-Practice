class Solution {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        return PrimeSeive(n);
    }
    public static int PrimeSeive(int n ){
        int[] prime = new int[n];
        prime[0] = 1; // yeh prime number nahi hai
        prime[1] = 1; //yeh prime number nahi hai

        for(int i = 2; i*i<=prime.length; i++){
            if(prime[i]==0){
                for(int j=2; i*j<prime.length; j++){
                    prime[i*j] = 1;
                }
            }
        }
        int count = 0;
        for(int i = 2; i<prime.length; i++){
            if(prime[i] == 0){
                count++;
            }
        }
        return count ;
    }
}