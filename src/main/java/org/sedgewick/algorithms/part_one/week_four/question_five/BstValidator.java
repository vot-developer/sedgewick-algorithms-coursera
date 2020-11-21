package org.sedgewick.algorithms.part_one.week_four.question_five;

public class BstValidator {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return validate(root.left, Long.MIN_VALUE, root.val) && validate(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max){
        if (root == null) return true;

        if (root.val >= max) return false;
        if (root.val <= min) return false;

        return validate(root.right, root.val, max) && validate(root.left, min, root.val);
    }
}
