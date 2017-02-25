package com.gf.nestedclasses;

/**
 * Created by pjajara on 2/20/17.
 */
public class OuterClass {

    int outer = -1;

    public class NestedClass {
        int inner = -2;

        public void bam(){

        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        NestedClass nc = outerClass.new NestedClass();


    }

    public void foo() {
        NestedClass o = new OuterClass.NestedClass();
        NestedClass o1 = new NestedClass();
    }
}
