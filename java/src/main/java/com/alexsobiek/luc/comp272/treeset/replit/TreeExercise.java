package com.alexsobiek.luc.comp272.treeset.replit;

public class TreeExercise {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = root1.addChild(2);
        TreeNode node11 = node1.addChild(3);
        TreeNode node12 = node1.addChild(1);
        TreeNode node2 = root1.addChild(2);
        TreeNode node21 = node2.addChild(3);
        TreeNode node22 = node2.addChild(2);
        System.out.println(preorderTraversal2(root1));
        System.out.printf("Average: %f\n", average(root1));
        replace(root1, 2, 4);
        System.out.println(preorderTraversal2(root1));

    }

    //auxiliary method
    public static String preorderTraversal2(TreeNode node) {
        if (node == null)
            return "";
        String pre = "" + node.data;
        for (TreeNode child : node.getChildren())
            pre += (" " + preorderTraversal2(child));
        return pre;
    }

    //Add your code here...

    /**
     * Replaces all instances of a with b
     * @param node Parent node to search for a in
     * @param a Value to replace
     * @param b Value to replace a with
     */
    public static void replace(TreeNode node, int a, int b) {
        if (node != null) {
            if  (node.data == a) node.data = b;
            node.getChildren().forEach(child -> replace(child, a, b));
        }
    }

    /**
     * Returns the average value of all child nodes
     * @param node Parent node
     * @return double Average
     */
    public static double average(TreeNode node) {
        Pair<Integer, Double> pair = average(node, new Pair<>(0, 0.0D));
        return pair.getValue() / pair.getKey();
    }

    private static Pair<Integer, Double> average(TreeNode node, Pair<Integer, Double> prev) {
        Pair<Integer, Double> pair = new Pair<>();
        if (node != null) {
            pair.setKey(prev.getKey() + 1);
            pair.setValue(prev.getValue() + node.data);
            for (TreeNode child : node.getChildren()) {
                pair = average(child, pair);
            }
        }
        return pair;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair() {
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Pair{K=%s,V=%s}", key, value);
    }
}