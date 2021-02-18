package 二叉树;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    public TreeNode maxTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int bond = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[bond]);
        root.left = maxTree(nums, l, bond - 1);
        root.right = maxTree(nums, bond + 1, r);
        return root;
    }

    //找最大值的索引
    public int findMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE, maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        _654_最大二叉树 a = new _654_最大二叉树();
        System.out.println(a.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }

}