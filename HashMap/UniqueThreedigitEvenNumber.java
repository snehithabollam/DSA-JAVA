import java.util.HashMap;
public class UniqueThreedigitEvenNumber {
    public int totalNumbers(int[] digits) {

        // Store the frequency of each digit.
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int digit : digits) {
            frequency.put(digit, frequency.getOrDefault(digit, 0) + 1);
        }

        int count = 0;

        // First digit: 1-9 (cannot be 0)
        for (int first = 1; first <= 9; first++) {

            if (!frequency.containsKey(first)) {
                continue;
            }

            // Second digit: 0-9
            for (int second = 0; second <= 9; second++) {

                if (!frequency.containsKey(second)) {
                    continue;
                }

                // Last digit must be even: 0, 2, 4, 6, 8
                for (int last = 0; last <= 8; last += 2) {

                    if (!frequency.containsKey(last)) {
                        continue;
                    }

                    // Check whether enough copies of repeated digits exist.
                    if (first == second && second == last) {

                        // All three digits are the same.
                        if (frequency.get(first) >= 3) {
                            count++;
                        }

                    } else if (first == second) {

                        // First and second digits are the same.
                        if (frequency.get(first) >= 2) {
                            count++;
                        }

                    } else if (second == last) {

                        // Second and last digits are the same.
                        if (frequency.get(second) >= 2) {
                            count++;
                        }

                    } else if (first == last) {

                        // First and last digits are the same.
                        if (frequency.get(first) >= 2) {
                            count++;
                        }

                    } else {

                        // All three digits are different.
                        count++;
                    }
                }
            }
        }

        return count;
    }

/*
Time Complexity:
    Building frequency map = O(n)
    Three nested loops = O(9 * 10 * 5) = O(1)

    Overall = O(n)

Space Complexity:
    Frequency map stores at most 10 digits.
    Therefore = O(1)
*/
}