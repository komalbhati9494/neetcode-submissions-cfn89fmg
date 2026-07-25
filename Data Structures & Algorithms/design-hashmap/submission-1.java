class MyHashMap {
    private static final int SIZE = 1000;

    private class Node{
        int key, value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table;

    public MyHashMap() {
        table = new Node[SIZE];
        
    }
    private int hash(int key){
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        Node curr = table[index];

        if(curr == null){
            table[index] = new Node(key, value);
            return;
        }
        while(curr != null){
            if(curr.key == key){
                curr.value = value;
                return;
            }
            if(curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key,value);
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = table[index];

        while(curr != null){
            if(curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;

        while(curr != null){
            if(curr.key == key){
                if(prev == null){
                    table[index] = curr.next;
                } else{
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */