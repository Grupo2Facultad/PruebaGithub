/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.reversearray.reversearray;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author juanc
 */
public class ReverseArray {
    
    public static void reverseArray(Object[] o) {
        Collections.reverse(Arrays.asList(o));
        for (Object object : o) {
            System.out.println(object);
        }
    }
}
