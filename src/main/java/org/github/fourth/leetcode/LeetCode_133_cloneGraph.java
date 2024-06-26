package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.graph.Node;

import java.util.*;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * 解题方法：
 * - 图的DFS
 * - 图的BFS
 */
public class LeetCode_133_cloneGraph {

    /**
     * 使用DFS
     */
    public Node cloneGraph01(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        return dfs(map, node);
    }

    private Node dfs(Map<Integer, Node> map, Node node) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            Node newNeighborNode = dfs(map, neighbor);
            newNode.neighbors.add(newNeighborNode);
        }
        return newNode;
    }

    /**
     * 图的BFS
     */
    public Node cloneGraph02(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraphExample01(node);
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public Node cloneGraphExample01(Node node) {
        if (node == null) {
            return null;
        }
        // key是原图节点，value是新图节点
        Map<Node, Node> map = new HashMap<>();

        // 1、创建队列
        Queue<Node> queue = new LinkedList<>();
        // 2、将初始节点放入队列
        queue.offer(node);
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        // 3、bfs遍历
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node neighborNode : curNode.neighbors) {
                if (!map.containsKey(neighborNode)) {
                    Node cloneNeighborNode = new Node(neighborNode.val);
                    map.put(neighborNode, cloneNeighborNode);
                    queue.offer(neighborNode);
                }
                // 边的关系都需要更新到curNode的克隆节点的邻接节点列表
                Node cloneCurNode = map.get(curNode);
                List<Node> neighborsOfcloneCurNode = cloneCurNode.neighbors;
                neighborsOfcloneCurNode.add(map.get(neighborNode));
            }
        }
        return copyNode;
    }

    /**
     * 使用DFS方法
     */
    public Node cloneGraphWithDfsExample02(Node node) {
        if (node == null) {
            return null;
        }

        // key是原图节点，value是新图节点
        Map<Node, Node> map = new HashMap<>();

        return dfsExample(map, node);
    }

    // 对 startNode 进行克隆
    private Node dfsExample(Map<Node, Node> map, Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        // 求 newNode 的连接表
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = dfsExample(map, neighbor);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }
}

