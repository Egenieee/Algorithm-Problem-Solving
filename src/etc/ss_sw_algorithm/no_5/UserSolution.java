package etc.ss_sw_algorithm.no_5;

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class UserSolution {
    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;
    private Node tail;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        nodeCnt = 0;
        node = new Node[MAX_NODE];
        head = null;
        tail = null;
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);

        Node nextNode = head;

        newNode.next = nextNode;
        newNode.prev = head;

        nextNode.prev = newNode;

        head = newNode;

        if (newNode.next == null) {
            tail = head;
            newNode.next = tail;
        }
    }

    public void addNode2Tail(int data) {
        if (nodeCnt == 0) {
            addNode2Head(data);
            return;
        }

        Node newNode = getNode(data);

        Node prevNode = tail;
        prevNode.next = newNode;

        newNode.next = tail;
        tail = newNode;
    }

    public void addNode2Num(int data, int num) {
        if (num == 1) {
            addNode2Head(data);
            return;
        }

        if (num == nodeCnt) {
            addNode2Tail(data);
            return;
        }

        int count = 0;
        Node pointNode = head;
        Node prevNode = null;

        while (pointNode != null) {
            if (count == num - 1) {
                prevNode = pointNode.prev;
                break;
            }
            count++;
            pointNode = pointNode.next;
        }

        if (pointNode == null) {
            return;
        }

        Node newNode = getNode(data);

        pointNode.prev = newNode;
        prevNode.next = newNode;

        newNode.prev = prevNode;
        newNode.next = pointNode;

//        if (pointNode.next == null) {
//            tail = pointNode;
//        }

    }

    public int findNode(int data) {
        int order = 0;

        Node pointNode = null;

        while (pointNode != null) {
            if (pointNode.data == data) {
                break;
            }
            order++;
            pointNode = pointNode.next;
        }

        return order;
    }

    public void removeNode(int data) {

    }

    public int getList(int[] output) {
        return 0;
    }

    public int getReversedList(int[] output) {
        return 0;
    }
}