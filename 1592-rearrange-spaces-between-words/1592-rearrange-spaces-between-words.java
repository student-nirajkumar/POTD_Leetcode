class Solution {
    public String reorderSpaces(String text) {

        int spaceCount = 0;

        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                spaceCount++;
            }
        }

        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        if (wordCount == 1) {
            StringBuilder sb = new StringBuilder(words[0]);
            for (int i = 0; i < spaceCount; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        int spaceBetween = spaceCount / (wordCount - 1);
        int extraSpace = spaceCount % (wordCount - 1);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < wordCount; i++) {
            result.append(words[i]);
            if (i < wordCount - 1) {
                for (int j = 0; j < spaceBetween; j++) {
                    result.append(" ");
                }
            }
        }

        for (int i = 0; i < extraSpace; i++) {
            result.append(" ");
        }

        return result.toString();
    }
}
