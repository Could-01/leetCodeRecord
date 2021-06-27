package 数组;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _212_单词搜索II {
    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        WordTrie myTrie = new WordTrie();
        TrieNode root = myTrie.root;
        //插入数据
        for (String word : words) {
            myTrie.insert(word);
        }

        //构建结果集容器
        List<String> result = new LinkedList<>();
        //矩阵行数
        int m = board.length;
        //矩阵列数
        int n = board[0].length;
        //存储该节点是否访问
        boolean[][] visited = new boolean[n][m];
        //遍历整个二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        return result;
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, List<String> result, TrieNode cur) {
        //边界判断以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[j][i])
            return;
        //获取子节点状态，判断其是否有子节点
        cur = cur.child[board[i][j] - 'a'];
        if (cur == null) {
            return;
        }
        //修改节点状态，防止重复访问
        visited[j][i] = true;
        //找到单词加入
        if (cur.isEnd) {
            result.add(cur.val);
            //找到单词后，修改字典树内叶子节点状态为false，防止出现重复单词
            cur.isEnd = false;
        }
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        //最后修改节点状态为未访问状态
        visited[j][i] = false;
    }


    /**
     * 字典树
     */
    class WordTrie {
        //创建根节点
        TrieNode root = new TrieNode();

        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                //判断是否存在该字符的节点，不存在则创建
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                    cur = cur.child[c - 'a'];
                } else
                    cur = cur.child[c - 'a'];
            }
            //遍历结束后，修改叶子节点的状态，并存储字符串
            cur.isEnd = true;
            cur.val = s;
        }
    }

    /**
     * 字典树节点
     */
    class TrieNode {
        /**
         * 存储最后节点的字符串
         */
        String val;
        /**
         * 根据字符排序，[a,b,c,……,z]
         */
        TrieNode[] child = new TrieNode[26];
        /**
         * 是否是最后叶子节点
         */
        boolean isEnd = false;
    }

    public static void main(String[] args) {
        _212_单词搜索II a = new _212_单词搜索II();
        char[][] data = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(a.findWords(data, words));
    }
}

class DictTreeTest {
    private final TreeNode root;

    public DictTreeTest() {
        root = new TreeNode();
    }

    class TreeNode {
        private int path;//该字母被使用次数
        private int end;//结束字母为0 表示该单词没有记录或者已经被删除
        private final HashMap<Character, TreeNode> map;//子节点

        public TreeNode() {
            this.path = 0;
            this.end = 0;
            this.map = new HashMap<>();
        }
    }

    //search
    public boolean search(String word) {
        if (word == null)
            return false;

        char[] chars = word.toCharArray();
        TreeNode node = root;
        for (int i = 0; i < chars.length; i++) {//循环遍历字符串所有字符 全部存在才可以
            if (node.map.get(chars[i]) == null) {
                return false;
            }
            node = node.map.get(chars[i]);
        }
        return node.end != 0;//判断结束字符是否为0
    }

    //add
    public void add(String word) {
        if (word == null)
            return;
        char[] chars = word.toCharArray();
        TreeNode node = root;
        for (int i = 0; i < chars.length; i++) {//循环遍历字符串所有字符 若某字符不存在 则新建子节点
            if (node.map.get(chars[i]) == null) {
                node.map.put(chars[i], new TreeNode());
            }
            node = node.map.get(chars[i]);
            node.path++;//该字符的使用次数加一
        }
        node.end++;//该字符串的结尾字符数加一
    }

    //delete
    public void delete(String word) {
        if (search(word)) {//判断字符是否存在 存在继续！
            char[] chars = word.toCharArray();
            TreeNode node = root;
            for (int i = 0; i < chars.length; i++) {//循环遍历字符串所有字符 一次删除
                if (node.map.get(chars[i]).path-- == 1) {//单词的使用次数减一 若该单词只有一次使用记录 则直接置空该单词的子节点并返回
                    node.map.put(chars[i], new TreeNode());
                    return;
                }
                node = node.map.get(chars[i]);
            }
            node.end--;//单词的结尾字符数减一
        }
    }
}