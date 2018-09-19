package com.kongww.work.util.tree;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MultipleTree {

    public Node parseTree(List<Map<String, Object>> dataList) {
        // 用于暂存节点信息的map
        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
        // 根节点
        Node root = null;
        // 根据结果集构造节点列表（存入map）
        for (Iterator<Map<String, Object>> it = dataList.iterator(); it.hasNext(); ) {
            Map<String, Object> dataRecord = (Map<String, Object>) it.next();
            // Node node = MapBeanUtil.map2Bean(dataRecord, Node.class);
            Node node = new Node();
            node.setId((Integer) dataRecord.get("id"));
            node.setName((String) dataRecord.get("name"));
            Node parent = new Node();
            parent.setId((Integer) dataRecord.get("parentId"));
            node.setParent(parent);
            node.setSort((Integer) dataRecord.get("sort"));
            node.setGmtCreate(((Timestamp) dataRecord.get("gmtCreate")));
            node.setLevel((Integer) dataRecord.get("lev"));
            nodeMap.put(node.getId(), node);
        }
        // 构造无序的多叉树
        for (Iterator<Map.Entry<Integer, Node>> it = nodeMap.entrySet().iterator(); it.hasNext(); ) {
            Node node = it.next().getValue();
            if (node.getParent().getId() == null || node.getParent().getId().equals(0)) {// 取得根节点，单独存放
                root = node;
            } else {// 所有子节点，找到自身父节点并加入父节点的child集合
                ((Node) nodeMap.get(node.getParent().getId())).addChild(node);
            }
        }
        // 递归横向排序
        root.sortChildren();
        return root;
    }
}
