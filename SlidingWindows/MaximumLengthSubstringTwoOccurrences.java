import java.util.Scanner;

public class MaximumLengthSubstringTwoOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] freq = new int[26];
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;

            while (freq[ch - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Time Complexity: O(n)
        // Space Complexity: O(1)
        System.out.println(maxLen);

        sc.close();
    }
}