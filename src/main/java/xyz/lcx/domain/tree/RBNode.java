package xyz.lcx.domain.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 红黑树节点
 *
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RBNode<T extends Comparable<T>> {

    /**
     * 左子节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private RBNode<T> left;

    /**
     * 右子节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private RBNode<T> right;

    /**
     * 父亲节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private RBNode<T> parent;

    /**
     * 是否红色
     */
    private boolean red;

    /**
     * 节点数据
     */
    private T data;
}
