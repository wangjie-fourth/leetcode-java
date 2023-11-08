package org.github.fourth.leetcode;

import java.util.*;

/**
 * @author jwang55
 */
public class LeetCode_133_cloneGraph {

    public Node cloneGraph(Node node) {
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
    public Node cloneGraphWithDfs(Node node) {
        if (node == null) {
            return null;
        }

        // key是原图节点，value是新图节点
        Map<Node, Node> map = new HashMap<>();

        return dfs(map, node);
    }

    // 对 startNode 进行克隆
    private Node dfs(Map<Node, Node> map, Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, node);
        // 求 newNode 的连接表
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = dfs(map, neighbor);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

}
