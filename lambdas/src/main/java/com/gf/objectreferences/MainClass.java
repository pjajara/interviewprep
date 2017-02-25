package com.gf.objectreferences;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by pjajara on 2/20/17.
 */
public class MainClass {

    public static void main(String[] args) {
        String str = "dang you!";
        System.out.println(str);
        SoftReference reference = null;

        PhantomReference phantomReference = null;
        WeakReference weakReference = new WeakReference(str);

        str = (String) weakReference.get();
        System.out.println(str);
    }
}
