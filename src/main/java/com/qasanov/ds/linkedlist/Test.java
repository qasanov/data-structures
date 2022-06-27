package com.qasanov.ds.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow =  Arrays.asList(1);
        result.add(firstRow);
        if(numRows == 1) return result;

        List<Integer> secondRow = Arrays.asList(1,1);
        result.add(secondRow);
        if(numRows == 2) return result;

        for(int i =3; i <= numRows; i++){

            List<Integer> newRow = Arrays.asList(new Integer[i]);
            newRow.set(0,Integer.valueOf(1));

            for(int j = 1; j< i; j++){
                newRow.add(prefRowSum(result.get(i-1),j));
            }

            newRow.add(i-1,Integer.valueOf(1));
            result.add(newRow);
        }

        return result;
    }

    private static int prefRowSum(List<Integer> prevList,int  currentPos){
        int firstPos = currentPos -1, secondPos = currentPos;
        int firstVal = 0, secondVal = 0 , current = 1 ;

        for(Integer val : prevList){

            if(firstPos == current )
                firstVal = val;

            if(secondPos == current){

                return firstVal + val;
            }


            current++;

        }

        return 0;
    }
}
