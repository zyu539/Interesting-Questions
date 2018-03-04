/**
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".



Answer: Use bits to represent the words, therefore, when comparing the words, we don't need to go through all
chars every time.
*/
class MaxProductOfWordLength {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] tmp = new int[words.length];
        for (int i = 0; i < tmp.length; i++) {
            for (char c : words[i].toCharArray()) {
                tmp[i] |= 1 << (c - 'a');
            }
        }
        
        for (int i = 0; i < tmp.length; i++) {
            for (int j = i+1; j < tmp.length; j++) {
                if ((tmp[i] & tmp[j]) == 0 && words[i].length() * words[j].length() > max) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}
