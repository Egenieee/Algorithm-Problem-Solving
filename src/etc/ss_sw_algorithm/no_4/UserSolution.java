package etc.ss_sw_algorithm.no_4;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
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
        head = null;
        tail = null;
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);
        Node nextNode = head;
        newNode.setNext(nextNode);
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
        tail.next = newNode;
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

        prevNode.next = newNode;
        newNode.next = nextNode;

    }

    public void removeNode(int data) {
        Node pointNode = head;
        Node prevNode = null;
        Node nextNode;

        while (pointNode != null) {
            if (pointNode.data == data) {
                break;
            }
            prevNode = pointNode;
            pointNode = pointNode.next;
        }

        if (pointNode == null) {
            return;
        }

        if (pointNode == head) {
            head = pointNode.next;
            pointNode.next = null;
            nodeCnt--;
            return;
        }

        // 지울 노드의 다음 노드를 저장
        nextNode = pointNode.next;

        // 지울 노드 앞의 노드의 다음 노드를 위에서 저장한 nextNode 로 설정해서 연결
        prevNode.next = nextNode;

        // 삭제한 노드가 마지막 노드였다면 tail을 갱신
        if (prevNode.next == null) {
            tail = prevNode;
        }

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

        return ++idx;
    }
}
