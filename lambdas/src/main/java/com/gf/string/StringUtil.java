package com.gf.string;

/**
 * Created by pjajara on 2/28/17.
 */
public class StringUtil {

    public static void main(String... strings){
        System.out.println(withoutString("THIS is a FISH", "is"));
    }

    public static String withoutString(String base, String remove) {

        String[] tokens = base.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String token: tokens){
            sb.append(token.toLowerCase().replace("(?i)" +remove, "")).append(" ");
        }

        // return base.toLowerCase().replaceAll(remove, "");
        return sb.toString().trim();
    }

    public boolean catDog(String str) {
        int catCount=0;
        int dogCount=0;

        int index = str.indexOf("cat");

        while(index >= 0) {
            catCount++;
            index = str.indexOf("cat", index+1);
        }

        index= -1;

        index = str.indexOf("dog");

        while(index >= 0) {
            dogCount++;
            index = str.indexOf("dog", index+1);
        }
        return catCount == dogCount;
    }


}
