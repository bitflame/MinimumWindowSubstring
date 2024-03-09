import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        if (t == null || s == null)
            return "";
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int index = 0, minLen = s.length(), tempValue = 0,
                startOfString = Integer.MAX_VALUE, sLength = s.length(), lowIndex = 0, highIndex = 0, haveCounter = 0,
                needCounter = t.length();
        char currentChar;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++) {
            currentChar = tChar[i];
            if (tMap.containsKey(currentChar)) {
                tempValue = tMap.get(currentChar);
                tMap.put(currentChar, ++tempValue);
            } else
                tMap.put(currentChar, 1);
            sMap.put(currentChar, 0);
        }
        while (index < sLength) {
            currentChar = sChar[index];
            if (tMap.containsKey(currentChar)) {
                tempValue = sMap.get(currentChar);
                if (tempValue < tMap.get(currentChar))
                    haveCounter++;
                sMap.put(currentChar, ++tempValue);
                if (startOfString == Integer.MAX_VALUE)
                    startOfString = index;
                // currentChar=sChar[index];
            }
            if (haveCounter == needCounter) {
                //
                currentChar = sChar[startOfString];
                while (tMap.containsKey(currentChar) && startOfString < sLength
                        && tMap.get(currentChar) < sMap.get(currentChar)) {
                    tempValue = sMap.get(currentChar);
                    startOfString++;
                    sMap.put(currentChar, --tempValue);
                    currentChar = sChar[startOfString];
                }
                if (minLen >= index - startOfString) {
                    minLen = index - startOfString;
                    lowIndex = startOfString;
                    highIndex = index + 1;
                }
                tempValue = sMap.get(sChar[startOfString]);
                tempValue--;
                sMap.put(sChar[startOfString], tempValue);
                startOfString++;
                haveCounter--;
                // move start of string to the next desired character
                while (startOfString < sLength && !tMap.containsKey(sChar[startOfString])) {
                    startOfString++;
                }
            }
            index++;
        }
        return s.substring(lowIndex, highIndex);
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

    public static String minWindowLeetCode(String s, String t) {
        if (t == null || s == null)
            return "";
        if (s.equals(t))
            return s;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int haveCounter = 0, needCounter = t.length(), index = 0, minLen = s.length(), tempValue = 0,
                startOfString = Integer.MAX_VALUE, sLength = s.length(), lowIndex = 0, highIndex = 0;
        char currentChar;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++) {
            currentChar = tChar[i];
            if (tMap.containsKey(currentChar)) {
                tempValue = tMap.get(currentChar);
                tMap.put(currentChar, ++tempValue);
            } else
                tMap.put(currentChar, 1);
            sMap.put(currentChar, 0);
        }
        while (index < sLength) {
            currentChar = sChar[index];
            if (tMap.containsKey(currentChar)) {
                tempValue = sMap.get(currentChar);
                if (tempValue < tMap.get(currentChar))
                    haveCounter++;
                sMap.put(currentChar, ++tempValue);
                if (startOfString == Integer.MAX_VALUE)
                    startOfString = index;
                // currentChar=sChar[index];
            }
            if (haveCounter == needCounter) {
                // move startOfString as long as sMap has more or equal of each item as tMap
                // remove from the beginning while the item is not in t or s has more than t
                while (startOfString < sLength - 2 && sChar[startOfString] == sChar[startOfString + 1]) {
                    startOfString++;
                }
                if (minLen >= index - startOfString) {
                    minLen = index - startOfString;
                    lowIndex = startOfString;
                    highIndex = index + 1;
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
                while (tMap.get(currentChar) == null && startOfString < sLength - 1) {
                    startOfString++;
                    currentChar = sChar[startOfString];
                }
            }
            index++;
        }
        return s.substring(lowIndex, highIndex);
    }

    public static String fouthTry(String s, String t) {
        if (t == null || s == null || s.length() < t.length())
            return "";
        if (s.equals(t))
            return s;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int index = 0, minLen = s.length(), tempValue = 0, startOfString = Integer.MAX_VALUE, sLength = s.length(),
                lowIndex = 0, startString = Integer.MAX_VALUE, endString = 0;
        char currentChar;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        List<Integer> needChar = new ArrayList<>();
        for (char c : tChar) {
            if (!tMap.containsKey(c))
                tMap.put(c, 1);
            else {
                tempValue = tMap.get(c);
                tMap.put(c, ++tempValue);
            }
        }
        // System.out.println("Here are all the items in T HashMap: ");
        // for (char c : tMap.keySet()) {
        // System.out.print(tMap.get(c) + " of: " + c + " ");
        // }
        // System.out.println();
        while (index < sLength) {
            currentChar = sChar[index];
            // add the key only if s does not have it or s has less
            if (tMap.containsKey(currentChar)) {
                if (!sMap.containsKey(currentChar)) {
                    sMap.put(currentChar, 1);
                } else if (sMap.get(currentChar) < tMap.get(currentChar)) {
                    tempValue = sMap.get(currentChar);
                    sMap.put(currentChar, ++tempValue);
                } else {
                    tempValue = sMap.get(currentChar);
                    sMap.put(currentChar, ++tempValue);
                }
                needChar.add(index);
                if (startOfString > index)
                    startOfString = index;
                else if (sChar[needChar.get(lowIndex)] == currentChar)
                    startOfString = index;
            }
            // might have to change the if statement to a while loop while(sMap.size() ==
            // tMap.size())
            // I do not think I deal with more than one of each key the way I should
            // if (sMap.size() == tMap.size()) {
            if (sMap.equals(tMap)) {
                if (index - startOfString > 0 || minLen > index - startOfString) {
                    minLen = index - startOfString;
                    startString = startOfString;
                    endString = index;
                }
                currentChar = sChar[startOfString];
                // lowIndex keeps track of the value startOfString was set to last
                if (lowIndex < needChar.size() - 1) {
                    lowIndex++;
                    startOfString = needChar.get(lowIndex);
                }
                tempValue = sMap.get(currentChar);
                if (tempValue == 1)
                    sMap.remove(currentChar);
                else {
                    sMap.put(currentChar, --tempValue);
                }
            }
            index++;
        }
        // System.out.println("Here are all the items in S HashMap: ");
        // for (char c : sMap.keySet()) {
        // System.out.print(sMap.get(c) + " of: " + c + " ");
        // }
        // System.out.println("Printing the contents of needed characters: ");
        // for (int i : neededChars) {
        // System.out.println(i);
        // }
        return (startString < Integer.MAX_VALUE) ? s.substring(startString, endString + 1) : "";
        // return s.substring(startString, endString + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Test 1 - Output of s = \"ADOBECODEBANC\" and t=\"ABC\" Expecting:\"BANC\" Getting:" + "\""
                + fouthTry(s, t) + "\"");
        s = "a";
        t = "a";
        System.out.println(
                "Test 2 - Output of s = \"a\" and t=\"a\" Expecting:\"a\" Getting:\"" + fouthTry(s, t) + "\"");
        s = "aa";
        System.out.println(
                "Test 3 - Output of s = \"aa\" and t=\"a\" Expecting:\"a\" Getting:\"" + fouthTry(s, t)
                        + "\"");
        t = "aa";
        s = "a";
        System.out.println(
                "Test 4 - Output of s = \"a\" and t=\"aa\" Expecting: \"\" Getting:" + "\"" + fouthTry(s, t) + "\"");
        t = "b";
        s = "a";
        System.out.println(
                "Test 5 - Output of s = \"a\" and t=\"b\" Expecting: \"\" Getting:" + "\"" + fouthTry(s, t) + "\"");
        t = "a";
        s = "ab";
        System.out
                .println("Test 6 - Output of s = \"ab\" and t=\"a\" Expecting \"a\" Getting:" + "\"" + fouthTry(s, t));
        t = "b";
        System.out
                .println("Test 7 - Output of s = \"ab\" and t=\"b\" Expecting \"b\" Getting:" + "\"" + fouthTry(s, t));
        t = "aa";
        s = "aa";
        System.out.println("Test 8 - Output of s = \"aa\" and t=\"aa\" Expecting \"aa\" Getting:" + fouthTry(s, t));
        s = "bdab";
        t = "ab";
        System.out.println(
                "Test 9 - Output of s = \"bdab\" and t=\"ab\" Expecting: \"ab\" Getting:" + "\"" + fouthTry(s, t)
                        + "\"");
        s = "bba";
        t = "ab";
        System.out.println(
                "Test 10 - Output of s = \"bba\" and t=\"ab\" Expecting: \"ba\" Getting:" + "\"" + fouthTry(s, t)
                        + "\"");
        s = "bbba";
        t = "abb";
        System.out.println(
                "Test 11 - Output of s = \"bbba\" and t=\"abb\" Expecting: \"ba\" Getting:" + "\"" + fouthTry(s, t)
                        + "\"");
        s = "bbaac";
        t = "aba";
        System.out.println(
                "Test 12 - Output of s = \"bbaac\" and t=\"aba\" Expecting: \"baa\" Getting:" + "\"" + fouthTry(s, t)
                        + "\"");
        s = "acbbaca";
        t = "aba";
        System.out.println(
                "Test 13 - s=\"acbbaca\" and t=\"aba\" Expecting: \"baca\" Getting: \"" + fouthTry(s, t) + "\"");
    }
}
