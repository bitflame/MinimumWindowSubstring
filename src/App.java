import java.util.HashMap;

public class App {
    // from solutions in leetcode
    public static String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }

    // From solutions in leetcode
    public String mWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }

    public static String minimumWindow(String s, String t) {
        if (t.length() > s.length() || t == null || s == null)
            return " ";
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int haveCounter = 0, needCounter = t.length(), index = 0, minLen = s.length(), tempValue = 0, startOfString = 0,
                sLength = s.length();
        int[] res = new int[2];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++) {
            if (tMap.get(i) == null) {
                tMap.put(tChar[i], 1);
                sMap.put(tChar[i], 0);
            } else {
                tempValue = tMap.get(i);
                tMap.put(tChar[i], tempValue++);
            }
        }
        char currentChar = ' ';
        while (index < sLength) {
            currentChar = sChar[index];
            if (tMap.get(currentChar) != null) {
                tempValue = sMap.get(currentChar);
                if (tempValue < tMap.get(currentChar))
                    haveCounter++;
                sMap.put(currentChar, ++tempValue);
            }

            if (haveCounter == needCounter) {
                if (minLen > index - startOfString) {
                    minLen = index - startOfString;
                    res[0] = startOfString;
                    res[1] = index;
                }
                currentChar = sChar[startOfString];
                tempValue = sMap.get(currentChar);
                sMap.put(currentChar, --tempValue);
                if (tempValue < tMap.get(currentChar))
                    haveCounter--;
                startOfString++;
                if (startOfString < sLength) {
                    currentChar = sChar[startOfString];
                }
                // try {
                // currentChar = sChar[startOfString];
                // } catch (Exception e) {
                // System.out.println(e.getMessage() + "Tried to access the end of String t");
                // }
                while (tMap.get(currentChar) == null) {
                    startOfString++;
                    currentChar = sChar[startOfString];
                }
            }
            index++;
        }
        return s.substring(res[0], ++res[1]);
    }

    public static String miniWindow(String s, String t) {
        int index = 0;
        int[] needArray = new int[t.length()];
        int[] haveArray = new int[t.length()];
        for (int i = 0; i < haveArray.length; i++) {

        }
        while (index < s.length()) {
            // if (t.contains(s.charAt(index))) {

            // }
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindow(s, t));
        s = "a";
        t = "a";
        System.out.println(minimumWindow(s, t));
        s = "aa";
        System.out.println(minimumWindow(s, t));
        t = "aa";
        System.out.println(minWindow(s, t));
    }
}
