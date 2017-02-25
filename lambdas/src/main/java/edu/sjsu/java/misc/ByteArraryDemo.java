package edu.sjsu.java.misc;

public class ByteArraryDemo {

    public static void main(String[] args) {

        byte[] byteArr = {'a', 'b', 'c', 'd', '&'};

		/*for (int i=0; i<10;i++){
			byteArr[i]=(byte) i;
		}*/

        for (byte b : byteArr) {
            System.out.println(b);
        }

    }

}
