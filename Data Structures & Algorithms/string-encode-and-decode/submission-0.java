class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(String string : strs) {
            encodedString += string.length() + "#" + string;
        }

        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();

        int index = 0;
        while(index < str.length()) {
            String num = str.substring(index, str.indexOf("#", index));
            int length = Integer.parseInt(num);
            String word = str.substring(index + num.length() + 1, index + num.length() + 1 + length);

            decodedStrings.add(word);

            System.out.println(word);

            index += num.length() + word.length() + 1;
        }

        return decodedStrings;
    }
}
