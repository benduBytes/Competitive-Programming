package DailyQuestion;
import java.util.*;

//Time Complexity: O(Log(N))
//Space Complexity: O(N)

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
class Pair1<K, V> {
    private K key;
    private V value;

    public Pair1(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair1<?, ?> pair = (Pair1<?, ?>) o;
        return key.equals(pair.key) && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return key.hashCode() * 31 + value.hashCode();
    }
}


class AllOoneDataStructure_462 {
	private Map<String, Integer> count;
    private TreeSet<Pair1<Integer, String>> set;

    public AllOoneDataStructure_462() {
        count = new HashMap<>();
        set = new TreeSet<>((a, b) -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue()) : a.getKey() - b.getKey());
    }

    public void inc(String key) {
        int n = count.getOrDefault(key, 0);
        count.put(key, n + 1);
        set.remove(new Pair1<>(n, key));
        set.add(new Pair1<>(n + 1, key));
    }

    public void dec(String key) {
        int n = count.get(key);
        set.remove(new Pair1<>(n, key));
        if (n == 1) count.remove(key);
        else {
            count.put(key, n - 1);
            set.add(new Pair1<>(n - 1, key));
        }
    }

    public String getMaxKey() {
        return set.isEmpty() ? "" : set.last().getValue();
    }

    public String getMinKey() {
        return set.isEmpty() ? "" : set.first().getValue();
    }
}

/*
Example 1:
Input
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output
[null, null, null, "hello", "hello", null, "hello", "leet"]

Explanation
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"
*/
