import java.util.HashMap;

public class App {
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

    public static String minimumWindow(String s, String t) {
        // create two hashmaps called haveMap and tMap.
        HashMap<Character, Integer> haveMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        // initialize two integer variables called haveCounter and
        // needCounter=t.lenght()
        int haveCounter = 0, needCounter = t.length(), index = 0, minLen = s.length();
        // minLen holds on the minimum lenght at any given interval
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        // you can not just put 1 in tMap since t may contain more than one character and the problem wants it that way
        for (char c : tChar) {
            tMap.put(c, 1);
            haveMap.put(c, 0);
        }

        // loop through s character array and if that character is in t char increase
        for (int i = 0; i < sChar.length; i++) {
            if (tMap.containsKey(sChar[i])) {
                haveMap.put(sChar[i], haveMap.get(sChar[i]) + 1);// If there is a match update haveMap
                haveCounter++;  
            }

        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        minimumWindow(s, t);
    }
}
