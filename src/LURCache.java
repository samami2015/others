import java.util.HashMap;

public class LURCache {
    class Node {
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node pre;
        public Node next;
        public String key;
        public String value;
    }

    private Node head;
    private Node end;
    private int limit;
    private HashMap<String, Node> hashMap;

    public LURCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if(hashMap.size()>limit){
                String oldKey = removeNode(node);
                hashMap.remove(oldKey);
            }
            node = new Node(key,value);
            addNode(node);
            hashMap.put(key,node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    private void refreshNode(Node node) {
        if (node == end) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    private String removeNode(Node node) {
        if (node == head && node == end) {
            head = null;
            end = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }
}
