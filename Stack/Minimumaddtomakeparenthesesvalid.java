class Minimumaddtomakeparenthesesvalid {
    public int minAddToMakeValid(String s) {

        int open = 0;
        int additions = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    additions++;
                }
            }
        }

        return additions + open;
    }
}

/*
 * Time Complexity: O(n)
 * We traverse the string once, processing each character in O(1) time.
 *
 * Space Complexity: O(1)
 * We use only two integer variables, regardless of the input size.
 */
