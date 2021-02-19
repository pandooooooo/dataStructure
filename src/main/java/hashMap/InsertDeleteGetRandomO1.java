package hashMap;/**
 * @author liukx
 * @date 2021/2/19 11:54 AM
 * @version 1.0
 */

import java.util.*;

/**
 * @author liukx
 * @date 2021/2/19 11:54 AM
 * @version 1.0
 */
public class InsertDeleteGetRandomO1 {
    class RandomizedSet {
        private Map<Integer, Integer> map;
        private List<Integer> indexList;
        private Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            indexList = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val))
                return false;
            else{
                map.put(val, indexList.size());
                indexList.add(indexList.size(), val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            else{
                int lastEle = indexList.get(indexList.size() - 1);
                int idx = map.get(val);
                indexList.set(idx, lastEle);
                map.put(lastEle, idx);
                indexList.remove(indexList.size() - 1);
                map.remove(val);
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return indexList.get(rand.nextInt(indexList.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
