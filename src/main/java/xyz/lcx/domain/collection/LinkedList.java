package xyz.lcx.domain.collection;

import lombok.Data;

import java.io.Serializable;

/**
 * LinkedList
 *
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-13
 */
@Data
public class LinkedList<T extends Serializable> {

    private LinkedNode<T> head;

    private LinkedNode<T> tail;

    public void add(T t) {
        LinkedNode<T> node = new LinkedNode<>(null, null, t);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.setPre(tail);
        tail.setNext(node);
        tail = node;
    }

    public void println() {
        LinkedNode<T> next = head.getNext();
        do {
            System.out.print(next.getData() + "->");
            next = next.getNext();
        } while (next != null);
    }
}
