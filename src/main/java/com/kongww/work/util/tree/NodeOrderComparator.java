package com.kongww.work.util.tree;

import java.util.Comparator;

public class NodeOrderComparator<T extends Node> implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return (o1.getGmtCreate().after(o2.getGmtCreate()) ? -1 : (o1.getGmtCreate().before(o2.getGmtCreate()) ? 1 : 0));
    }
}
