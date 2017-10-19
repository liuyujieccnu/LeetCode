import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("bab");
        System.out.println("\n" + ans);
    }

    /**
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * @param s
     * @return
     */

//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        int[] index = new int[128];
//        for (int j = 0, i = 0; j < n; j++) {
//            i = Math.max(index[s.charAt(j)], i);
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        return ans;

//        int len=0;
//        String ans="";
//        for(int i=0;i<s.length();i++){
//            if(ans.indexOf(s.charAt(i))==-1){
//                ans=ans+Character.toString(s.charAt(i));
//                if(ans.length()>len)
//                    len = ans.length();
//            }else{
//                if(ans.length()>len)
//                    len = ans.length();
//                ans=ans.substring(ans.indexOf(s.charAt(i))+1)+Character.toString(s.charAt(i));
//            }
//        }
//        return len;
//    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
