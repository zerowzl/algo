package linkedList;

/**
 * @author Dave Wang
 */
public class SimpleLinkedList<E> {

    /**
     * 头结点
     */
    Node<E> head;
    /**
     * 尾结点
     */
    Node<E> tail;
    /**
     * 元素个数
     */
    int size;

    public SimpleLinkedList() {
    }

    /**
     * 添加元素
     *
     * @param e 元素
     */
    public void add(E e) {
        // 之前的尾结点
        final Node<E> t = tail;
        final Node<E> newNode = new Node<>(e, null);
        // 现在的尾结点 = 新建的节点
        tail = newNode;
        if (t == null) {
            // 之前的尾结点为空说明是第一次添加元素，将新建节点赋值给头结点
            head = newNode;
        } else {
            // 不是第一次添加元素，将之前的尾结点的 next 节点设置为新建节点，也就是将节点连起来
            t.next = newNode;
        }
        size++;
    }

    /**
     * 根据元素删除
     *
     * @param e 元素
     */
    public E remove(E e) {
        if (size == 0) {
            return null;
        }

        // 找元素
        Node<E> prev = null;
        Node<E> removeNode = null;
        Node<E> cur = head;
        while (cur != null) {
            if (cur.element.equals(e)) {
                removeNode = cur;
                break;
            }
            prev = cur;
            cur = head.next;
        }

        // 未找到删除的元素
        if (removeNode == null) {
            return null;
        }

        // prev 为空，说明删除的元素是第一个
        if (prev == null) {
            head = removeNode.next;
        } else {
            prev.next = removeNode.next;
        }

        // 删除的是最后一个元素
        if (removeNode.next == null) {
            tail = prev;
        }

        size--;
        return removeNode.element;
    }


    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.remove(2));
        System.out.println(list.remove(1));
        System.out.println(list.remove(3));
    }


}
