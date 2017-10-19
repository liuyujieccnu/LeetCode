public class Main {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbakdsfaskjfcbvhfbbabbdsbbbbsdbfdabcdefgfed"));
    }

    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        double i = 0.5;
        int start = 0, end = 0, len = 0, maxStart = 0, maxEnd = 0;
        while (i < arr.length) {
            int flag = 0;
            if ((i * 10) % 10 == 0) {
                start = (int) (i - 1);
                end = (int) (i + 1);
            } else if ((i * 10) % 10 == 5) {
                start = (int) (i - 0.5);
                end = (int) (i + 0.5);
            }
            if (start < 0) {
                i += 0.5;
                continue;
            }
            if (end >= arr.length) {
                i += 0.5;
                continue;
            }
            while (arr[start] == arr[end] && start >= 0 && end < arr.length) {
                flag = 1;
                start--;
                end++;
                if (start <= 0) {
                    break;
                }
                if (end >= arr.length) {
                    break;
                }
            }
            if (end - start > len && flag == 1) {
                len = end - start;
                maxStart = start;
                maxEnd = end;
            }
            i += 0.5;
        }
        System.out.println(maxEnd);
        System.out.println(maxStart);
        if (maxStart + 1 < maxEnd ) {
            return s.substring(maxStart + 1, maxEnd);
        } else
            return s.substring(0, 1);

    }
}
