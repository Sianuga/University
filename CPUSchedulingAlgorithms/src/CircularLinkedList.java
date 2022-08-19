public class CircularLinkedList<E>
{
    private Node head = null;
    private Node tail = null;
    class Node {

        E value;
        Node nextNode;

        public Node(E value) {
            this.value = value;
        }
    }

    public void addNode(E value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    public boolean containsNode(E searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value.equals(searchValue)) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    public void deleteNode(E valueToDelete)
    {
        Node currentNode = head;
        if (head == null)
        {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value.equals(valueToDelete))
            {
                if (tail == head)
                {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode)
                    {
                        head = head.nextNode;
                    }
                    if (tail == nextNode)
                    {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }
}
