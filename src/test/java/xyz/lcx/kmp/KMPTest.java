package xyz.lcx.kmp;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-22
 */
class KMPTest {

    @Test
    void kmpTest() {
        String text = "BBC ABCDABABCDABD ABCDABCDABDEABCDABD";
        String search = "ABCDABD";
        char[] content = text.toCharArray();
        char[] keys = search.toCharArray();
        List<Integer> idxs = new LinkedList<>();
        for (int i = 0; i < content.length; i++) {
            int start = i;
            for (int idx = 0; idx < keys.length && start < content.length; idx++) {
                char c1 = content[start++];
                char c2 = keys[idx];
                if (c1 != c2) {
                    start = -1;
                    break;
                }
            }
            if (start >= 0) {
                idxs.add(start - keys.length);
            }
        }
        System.out.println(idxs);
    }
}
