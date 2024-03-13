package xyz.lcx.domain.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 树节点
 *
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode<T extends Comparable<T>> {

    /**
     * 左子节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TreeNode<T> left;

    /**
     * 右子节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TreeNode<T> right;

    /**
     * 父亲节点
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TreeNode<T> parent;

    /**
     * 节点数据
     */
    private T data;
}
