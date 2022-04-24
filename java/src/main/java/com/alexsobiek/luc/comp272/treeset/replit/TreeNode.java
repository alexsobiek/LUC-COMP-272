package com.alexsobiek.luc.comp272.treeset.replit;

import java.util.ArrayList;

public class TreeNode {
    int data;
    ArrayList<TreeNode> children = new ArrayList<>();
    TreeNode parent = null;

    public TreeNode(int d) {
        data = d;
    }

    public TreeNode addChild(int d) {
        TreeNode n = new TreeNode(d);
        n.setParent(this);
        children.add(n);
        return n;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode p) {
        parent = p;
    }
}