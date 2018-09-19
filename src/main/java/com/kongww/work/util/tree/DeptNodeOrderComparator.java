package com.kongww.work.util.tree;

import java.util.Comparator;

public class DeptNodeOrderComparator<T extends DeptNode> implements Comparator<DeptNode> {

    public int compare(DeptNode o1, DeptNode o2) {
        return (o1.getGmtCreate().after(o2.getGmtCreate()) ? -1 : (o1.getGmtCreate().before(o2.getGmtCreate()) ? 1 : 0));
    }
}
