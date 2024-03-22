package xyz.lcx.juc;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-21
 */
class ThreadPoolExecutorTest {
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;


    @Test
    void test() {
        List<Pair<String, Integer>> values = List.of(
                Pair.of("ctl", ctl.get()),
                Pair.of("ctl+1", ctl.incrementAndGet()),
                Pair.of("COUNT_MASK", COUNT_MASK),
                Pair.of("RUNNING", RUNNING),
                Pair.of("SHUTDOWN", SHUTDOWN),
                Pair.of("STOP", STOP),
                Pair.of("TIDYING", TIDYING),
                Pair.of("TERMINATED", TERMINATED)
        );
        for (Pair<String, Integer> pair : values) {
            System.out.println(
                    toStr(pair.getKey(), " ", 10)
                            + " -> " + toStr(pair.getValue().toString(), " ", 10)
                            + " -> " + toStr(Integer.toBinaryString(pair.getValue()), "0", 32)
            );
        }
    }

    private String toStr(String source, String repeat, int len) {
        int diff = Math.abs(source.length() - len);
        if (diff > 0) {
            return StrUtil.repeat(repeat, diff) + source;
        }
        return source;
    }

    // Packing and unpacking ctl
    private static int runStateOf(int c) {
        return c & ~COUNT_MASK;
    }

    private static int workerCountOf(int c) {
        return c & COUNT_MASK;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    /*
     * Bit field accessors that don't require unpacking ctl.
     * These depend on the bit layout and on workerCount being never negative.
     */

    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    /**
     * Attempts to CAS-increment the workerCount field of ctl.
     */
    private boolean compareAndIncrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect + 1);
    }

    /**
     * Attempts to CAS-decrement the workerCount field of ctl.
     */
    private boolean compareAndDecrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect - 1);
    }

    /**
     * Decrements the workerCount field of ctl. This is called only on
     * abrupt termination of a thread (see processWorkerExit). Other
     * decrements are performed within getTask.
     */
    private void decrementWorkerCount() {
        ctl.addAndGet(-1);
    }

}
