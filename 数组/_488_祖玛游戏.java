package 数组;

public class _488_祖玛游戏 {
    public int findMinStep(String board, String hand) {
        int[] species = new int[5];
        // R Y B G W
        //计数
        for (int i = 0; i < board.length(); i++) {
            switch (board.charAt(i)) {
                case 'R':
                    species[0]++;
                    break;
                case 'Y':
                    species[1]++;
                    break;
                case 'B':
                    species[2]++;
                    break;
                case 'G':
                    species[3]++;
                    break;
                default:
                    species[4]++;
                    break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _488_祖玛游戏 a = new _488_祖玛游戏();

    }
}
