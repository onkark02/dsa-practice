package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private final List<Integer> list;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList == null){
            throw new IllegalArgumentException("Null input is not allowed");
        }
        list = new ArrayList<>();
        this.flatten(nestedList);
        this.index = 0;
    }

    private void flatten(List<NestedInteger> nestedList) {
        for(NestedInteger nestedInteger: nestedList){
            if(nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else{
                flatten(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    public static void main(String[] args) {
        NestedInteger input3 = new NestedInteger(3);
        List<NestedInteger> empty = new ArrayList<>();

        NestedIterator iterator = new NestedIterator(Arrays.asList(new NestedInteger(empty),input3));
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        //System.out.println("----------");
    }
}


  class NestedInteger {
            Integer val;
            List<NestedInteger> list;

            public NestedInteger(int val){
                this.val = val;
                this.list = null;
            }

            public NestedInteger(List<NestedInteger> list){
                this.list = list;
                this.val = null;
            }
               // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger(){
                 return val != null;
             }


             // @return the single integer that this NestedInteger holds, if it holds a single integer
             // Return null if this NestedInteger holds a nested list
            public Integer getInteger(){
                return val;
            }

             // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return empty list if this NestedInteger holds a single integer
             public List<NestedInteger> getList(){
                return list;
             }
  }


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */