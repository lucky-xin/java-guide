package xyz.lcx.domain.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 链表节点
 *
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedNode<T extends Serializable> implements Serializable {

    /**
     * 前驱节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LinkedNode<T> pre;

    /**
     * 下一个节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LinkedNode<T> next;

    /**
     * 节点数据
     */
    private T data;
}
