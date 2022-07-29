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

        if (nextNode != null) {
            nextNode.prev = newNode;
        }

        head = newNode;

        if (newNode.next == null) {
            tail = head;
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
        newNode.prev = prevNode;

        tail = newNode;
    }

    public void addNode2Num(int data, int num) {
        if (num == 1) {
            addNode2Head(data);
            return;
        }

        int count = 1;
        Node pointNode = head;
        Node prevNode = null;
        Node nextNode = null;

        while (pointNode != null) {
            if (count == num - 1) {
                prevNode = pointNode;
                nextNode = pointNode.next;
                break;
            }
            count++;
            pointNode = pointNode.next;
        }

        if (pointNode == null) {
            return;
        }

        Node newNode = getNode(data);

        if (nextNode != null) {
            nextNode.prev = newNode;
        }

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;

        if (nextNode == null) {
            tail = newNode;
        }
    }

    public int findNode(int data) {
        int order = 1;

        Node pointNode = head;

        while (pointNode != null) {
            if (pointNode.data == data) {
                return order;
            }
            order++;
            pointNode = pointNode.next;
        }

        return -1;
    }

    public void removeNode(int data) {
        Node pointNode = head;
        Node prevNode;
        Node nextNode;

        while (pointNode != null) {
            if (pointNode.data == data) {
                break;
            }
            pointNode = pointNode.next;
        }

        if (pointNode == null) {
            return;
        }

        if (pointNode == head) {
            head = pointNode.next;
            pointNode.next = null;
            pointNode.prev = null;
            nodeCnt--;
            return;
        }

        nextNode = pointNode.next;
        prevNode = pointNode.prev;

        prevNode.next = nextNode;

        if (nextNode != null) {
            nextNode.prev = prevNode;
        }

        if (prevNode.next == null) {
            tail = prevNode;
        }

        pointNode.prev = null;
        pointNode.next = null;
        nodeCnt--;
    }

    public int getList(int[] output) {
        int idx = 0;

        Node pointNode = head;

        while (pointNode != null) {
            output[idx++] = pointNode.data;
            pointNode = pointNode.next;
        }

        return idx;
    }

    public int getReversedList(int[] output) {
        int idx = 0;

        Node pointNode = tail;

        while (pointNode != null) {
            output[idx++] = pointNode.data;
            pointNode = pointNode.prev;
        }

        return idx;
    }
}