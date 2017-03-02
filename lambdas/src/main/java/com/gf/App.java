package com.gf;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        float amount = 0.1f;

        System.out.println(amount);

        StringBuilder sb = new StringBuilder("abcd");
        sb.toString();
        String reversed = sb.reverse().toString();
        System.out.println(reversed);
        System.out.println(sb.toString());
    }
}
