package demo;

import java.util.*;


class SchoolAdmission{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        System.out.println(schoolAdmission(s));
    }

    static String schoolAdmission(String s){

           Map<Integer, String> indexWordMap = new HashMap<>();

    // Split each word based on space
    for (String word : s.split(" ")) {
      int lastIndex = word.length() - 1;

      // get the word and index separately
      int index = word.charAt(lastIndex) -'0';
      String actualWord = word.substring(0, lastIndex);

      indexWordMap.put(index, actualWord);
    }

    // Build the actual string
    StringBuilder actualString = new StringBuilder();
    for (Map.Entry<Integer, String> indexWord : indexWordMap.entrySet()) {
      actualString.append(indexWord.getValue());
      actualString.append(" ");
    }

    return actualString.toString();
}
}
