package com.tinoba.domain.repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Nesto {

    public int nesto(int A[]){

        Set<Integer> set = new HashSet<Integer>();

        for (final int i : A) {
            set.add(i);
        }
        int min = 1;

        for (final Integer integer : set) {
            if (set.contains(integer) && integer >1){
                min = integer;
            }else {
                return integer;
            }
        }
        return min;
    }
}
