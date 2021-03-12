package 二叉树;

public class _331_验证二叉树的前序序列化 {
    public boolean isValidSerialization(String preorder) {
        // 一个序列什么时候一定合法
        // 首先 节点数量关系要满足 其次 遍历过程中 叶子节点不能分布不均
        // ① 记录叶子节点 和 总结节点数
        int leafCount = 0, nodeCount = 1;
        // 左右孩子只能同时出现的二叉树必然 叶子节点数 = 非叶子节点数 + 1
        for (char ch : preorder.toCharArray()) {
            // ② 遍历过程中 叶子节点 和 非叶子节点的关系
            // 这步有点难理解 这样想 我们最后遍历到的必然是 # 叶子节点
            // 叶子节点显然会出现在序列最后
            // 所以在树的先序遍历过程中 (在最后一个节点前) 叶子节点最多和非叶子节点相等
            // 如果叶子节点超过了非叶子 说明至少有一个叶子节点#上接了其他节点
            if (leafCount > nodeCount - leafCount) return false;
            if (ch == ',') nodeCount++;
            if (ch == '#') leafCount++;
        }
        return (nodeCount - leafCount) + 1 == leafCount;
    }


    public static void main(String[] args) {
        _331_验证二叉树的前序序列化 a = new _331_验证二叉树的前序序列化();
        System.out.println(a.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
