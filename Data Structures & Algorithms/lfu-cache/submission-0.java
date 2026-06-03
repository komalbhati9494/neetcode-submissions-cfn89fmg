class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {

        Node head;
        Node tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node last = tail.prev;
            remove(last);

            return last;
        }
    }

    private final int capacity;
    private int minFreq;

    private final Map<Integer, Node> cache;
    private final Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        cache = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            node.value = value;

            updateFreq(node);

            return;
        }

        if (cache.size() == capacity) {

            DLL minList = freqMap.get(minFreq);

            Node removed = minList.removeLast();

            cache.remove(removed.key);
        }

        Node node = new Node(key, value);

        cache.put(key, node);

        freqMap.computeIfAbsent(1, k -> new DLL())
               .add(node);

        minFreq = 1;
    }

    private void updateFreq(Node node) {

        int freq = node.freq;

        DLL list = freqMap.get(freq);

        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.computeIfAbsent(node.freq,
                k -> new DLL())
                .add(node);
    }
}