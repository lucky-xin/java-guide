package xyz.lcx.domain.tree;

import lombok.Data;

/**
 * 红黑树
 *
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-13
 */
@Data
public class RBTree<T extends Comparable<T>> {

    /**
     * 根节点
     */
    private RBNode<T> root;

    void addNode(T t) {

    }

    /**
     * 左旋
     *
     * @param p
     */
    void rotateLeft(RBNode<T> p) {
        RBNode<T> pp = p.getParent();
        RBNode<T> pr = p.getRight();
        RBNode<T> prl = pr.getLeft();
        pr.setLeft(p);
        pr.setParent(pp);
        p.setRight(prl);
        p.setParent(pr);
        if (prl != null) {
            prl.setParent(p);
        }
        if (pp != null) {
            if (pp.getLeft() == p) {
                pp.setLeft(pr);
            } else {
                pp.setRight(pr);
            }
        }
    }

    /**
     * 右旋
     *
     * @param p
     */
    void rotateRight(RBNode<T> p) {
        RBNode<T> pl = p.getLeft();
        RBNode<T> pp = p.getParent();
        RBNode<T> plr = pl.getRight();
        p.setLeft(plr);
        p.setParent(pl);
        if (plr != null) {
            plr.setParent(p);
        }
        pl.setRight(p);
        pl.setParent(pp);
        if (pp != null) {
            if (pp.getRight() == p) {
                pp.setRight(pl);
            } else {
                pp.setLeft(pl);
            }
        }
    }
}
