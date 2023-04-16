public class MyLinkedList<E> implements MyList<E>{
    private class Node {
        E element;
        Node next;
        Node prev;

        public Node(E element){
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(E item) {
        Node newNode = new Node(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(E item, int index) {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(item);
        if (index == 0)
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (index == size)
        {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        else
        {
            Node temp = head;
            for (int i=0; i<index;i++){
                temp = temp.next;
            }

            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.next.prev = newNode;
        }

        size++;
    }


    @Override
    public boolean remove(E item) {
        Node current = head;
        int index = 0;
        while (current.next != null) {
            if (current.element == item) {
                remove(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (head == null) {
            return null;
        }
        Node current = head;
        if (index == 0) {
            E elementRemoved = current.element;
            head = current.next;
            size--;
            return elementRemoved;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E removed = current.element;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        size--;
        return removed;
    }


    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.element;
    }


    @Override
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.element == o) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element == o) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        Node current = head;
        while (current.next != null) {
            if (((Comparable<E>) current.element).compareTo(current.next.element) > 0) {
                E temp = current.element;
                current.element = current.next.element;
                current.next.element = temp;
            }
            current = current.next;
        }
    }
}


