package xyz.lcx.collection;

import org.junit.jupiter.api.Test;
import xyz.lcx.domain.collection.LinkedList;
import xyz.lcx.domain.collection.LinkedNode;

/**
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-13
 */
class LinkedListTest {

    @Test
    void test() {
        int count = 64;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        list.println();
    }
}
