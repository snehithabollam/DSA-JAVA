class Solution {

    public boolean checkDivisibility(int n) {
        int originalNumber = n;
        int digitSum = 0;
        int digitProduct = 1;

        // Calculate the sum and product of all digits
        while (n > 0) {
            int digit = n % 10;

            digitSum += digit;
            digitProduct *= digit;

            n /= 10;
        }

        // The required divisor is the sum of digit sum and digit product
        int divisor = digitSum + digitProduct;

        // Check if the original number is divisible by the divisor
        return originalNumber % divisor == 0;
    }
}

/*
Time Complexity: O(log10(n))
    - We process each digit of n once.

Space Complexity: O(1)
    - Only a constant number of variables are used.
*/