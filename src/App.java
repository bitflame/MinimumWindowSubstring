import java.util.HashMap;

public class App {
    // from the youtube link https://www.youtube.com/watch?v=U1q16AFcjKs&t=686s
    public static String fifthTry(String s, String t) {
        if (s.equals(t))
            return t;
        int i = 0, j = 0, count = 0, left = 0, right = 0, minLenth = s.length(), tempValue = 0;
        boolean foundIt = false;
        HashMap<Character, Integer> neededCharsMap = new HashMap<>();
        for (Character character : t.toCharArray()) {
            if (neededCharsMap.containsKey(character)) {
                tempValue = neededCharsMap.get(character);
                neededCharsMap.put(character, tempValue + 1);
            } else
                neededCharsMap.put(character, 1);
        }

        // count is the number of unique characters in t
        count = neededCharsMap.size();
        while (j < s.length()) {
            if (neededCharsMap.containsKey(s.charAt(j))) {
                tempValue = neededCharsMap.get(s.charAt(j));
                tempValue = tempValue - 1;
                neededCharsMap.put(s.charAt(j), tempValue);
                if (tempValue == 0)
                    count = count - 1;
            }
            // We are supposed to increment j before we check to see if we found a minimum
            // substring
            j++;

            while (count <= 0) {
                // found a candidate for minimum window substring, move i forward until count is
                // greater than 0
                while (!neededCharsMap.containsKey(s.charAt(i))) {
                    i++;
                }
                tempValue = neededCharsMap.get(s.charAt(i));
                neededCharsMap.put(s.charAt(i), ++tempValue);
                if (tempValue > 0)
                    count = count + 1;
                if (minLenth >= j - i) {
                    minLenth = j - i;
                    left = i;
                    right = j;
                    foundIt = true;
                }
                i++;
            }
        }
        return s.substring(left, right);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Test 1 - Output of s = \"ADOBECODEBANC\" and t=\"ABC\" Expecting:\"BANC\" Getting:" + "\""
                + fifthTry(s, t) + "\"");
        s = "a";
        t = "a";
        System.out.println(
                "Test 2 - Output of s = \"a\" and t=\"a\" Expecting:\"a\" Getting:\"" + fifthTry(s, t) + "\"");
        s = "aa";
        System.out.println(
                "Test 3 - Output of s = \"aa\" and t=\"a\" Expecting:\"a\" Getting:\"" + fifthTry(s, t)
                        + "\"");
        t = "aa";
        s = "a";
        System.out.println(
                "Test 4 - Output of s = \"a\" and t=\"aa\" Expecting: \"\" Getting:" + "\"" + fifthTry(s, t)
                        + "\"");
        t = "b";
        s = "a";
        System.out.println(
                "Test 5 - Output of s = \"a\" and t=\"b\" Expecting: \"\" Getting:" + "\"" + fifthTry(s, t)
                        + "\"");
        t = "a";
        s = "ab";
        System.out
                .println("Test 6 - Output of s = \"ab\" and t=\"a\" Expecting \"a\" Getting:" + "\""
                        + fifthTry(s, t)
                        + "\"");
        t = "b";
        System.out
                .println("Test 7 - Output of s = \"ab\" and t=\"b\" Expecting \"b\" Getting:" + "\""
                        + fifthTry(s, t)
                        + "\"");
        t = "aa";
        s = "aa";
        System.out.println(
                "Test 8 - Output of s = \"aa\" and t=\"aa\" Expecting \"aa\" Getting:" + fifthTry(s, t));
        s = "bdab";
        t = "ab";
        System.out.println(
                "Test 9 - Output of s = \"bdab\" and t=\"ab\" Expecting: \"ab\" Getting:" + "\""
                        + fifthTry(s, t)
                        + "\"");
        s = "bba";
        t = "ab";
        System.out.println(
                "Test 10 - Output of s = \"bba\" and t=\"ab\" Expecting: \"ba\" Getting:" + "\""
                        + fifthTry(s, t)
                        + "\"");
        s = "bbba";
        t = "abb";
        System.out.println(
                "Test 11 - Output of s = \"bbba\" and t=\"abb\" Expecting: \"bba\" Getting:" + "\""
                        + fifthTry(s, t)
                        + "\"");
        s = "bbaac";
        t = "aba";
        System.out.println("Test 12 - Output of s = \"bbaac\" and t=\"aba\" Expecting: \"baa\" Getting:" + "\""
                + fifthTry(s, t) + "\"");
        s = "acbbaca";
        t = "aba";
        System.out.println(
                "Test 13 - s=\"acbbaca\" and t=\"aba\" Expecting: \"baca\" Getting: \"" + fifthTry(s, t)
                        + "\"");
        s = "aaaaaaaaaaaabbbbbcdd";
        t = "abcdd";
        System.out.println(
                "Test 14 - s=\"aaaaaaaaaaaabbbbbcdd\" and t=\"abcdd\" Expecting: \"abbbbbcdd\" Getting: \""
                        + fifthTry(s, t)
                        + "\"");
        s = "ab";
        t = "A";
        System.out.println("Test 15 - s=\"ab\" and t=\"A\" Expecting: \"\" Getting: \"" + fifthTry(s, t)
                + "\"");
        s = "abc";
        t = "ac";
        System.out.println("Test 16 - s=\"abc\" and t=\"ac\" Expecting: \"abc\" Getting: \"" + fifthTry(s, t)
                + "\"");
    }
}
