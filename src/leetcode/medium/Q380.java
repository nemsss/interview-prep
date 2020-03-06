package leetcode.medium;

import java.util.*;

/**
 * Created by cenumah on 2020-01-12
 */
public class Q380 {

    public static void main(String[] args) {

    }

    class RandomizedSet_Ayo {

        //ArrayList

        //Hash key, use hashed value as mem addy
        //Since we don't know the size ahead of time, we can use an arraylist
        Random rand = new Random();
        ArrayList<Integer> array;
        HashMap<Integer,Integer> valueToIdx;

        /** Initialize your data structure here. */
        public RandomizedSet_Ayo() {
            array = new ArrayList<>();
            valueToIdx = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(valueToIdx.containsKey(val)) return false;

            array.add(val);
            valueToIdx.put(val, array.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!valueToIdx.containsKey(val)) return false;

            int idxToRemove = valueToIdx.get(val);
            int lastVal = array.get(array.size() - 1);

            array.set(idxToRemove, lastVal);
            array.remove(array.size() - 1);

            valueToIdx.put(lastVal, idxToRemove);
            valueToIdx.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = rand.nextInt(array.size());
            return array.get(idx);
        }
    }

    class RandomizedSet_Me {

        Map<Integer, Boolean> map;
        public RandomizedSet_Me() {
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean newlyAdded = map.containsKey(val);
            map.put(val, true);
            return newlyAdded;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            return map.remove(val) != null;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = new Random().nextInt(map.size());
            int count = 0;
            for(int num : map.keySet()) {
                if(count++ == idx) {
                    return num;
                }
            }
            return -1;
        }
    }
}
