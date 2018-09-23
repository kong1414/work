package com.kongww.work.util.tree;

import java.util.*;

public class TreeUtil {
    public static DeptNode parseDeptTree(List<Map<String, Object>> dataList) {
        // 用于暂存节点信息的map
        Map<Integer, DeptNode> deptNodeMap = new HashMap<>();
        // 根节点
        DeptNode root = null;

        // 根据结果集构造节点列表（存入map）

        for (Iterator<Map<String, Object>> it = dataList.iterator(); it.hasNext(); ) {
            Map<String, Object> dataRecord = it.next();

            // 创建节点
            DeptNode deptNode = new DeptNode();
            deptNode.setId((Integer) dataRecord.get("id"));
            deptNode.setName((String) dataRecord.get("name"));

            // 创建父节点的信息
            DeptNode parent = new DeptNode();
            parent.setId((Integer) dataRecord.get("parentId"));
            deptNode.setParent(parent);

            deptNode.setSort((Integer) dataRecord.get("sort"));
            deptNode.setLevel((Integer) dataRecord.get("level"));
            deptNode.setGmtCreate((Date) dataRecord.get("gmtCreate"));

            // 把节点放入map中
            deptNodeMap.put(deptNode.getId(), deptNode);
        }

        // 构造无序的多叉树
        for (Iterator<Map.Entry<Integer, DeptNode>> it = deptNodeMap.entrySet().iterator(); ((Iterator) it).hasNext(); ) {
            DeptNode deptNode = it.next().getValue();

            if (deptNode.getParent().getId() == null || deptNode.getParent().getId().equals(0)) {// 取得根节点，单独存放
                root = deptNode;
            } else {
                // 所有子节点，找到自身父节点并加入父节点的child集合
                (deptNodeMap.get(deptNode.getParent().getId())).addChild(deptNode);
            }

        }
        root.sortChildren();

        return root;
    }
}
