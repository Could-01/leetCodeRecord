package 栈;

import java.util.Arrays;
import java.util.Stack;

public class _735_行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int num = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            if (num > 0) {
                stack.push(num);
            } else {
                while (true) {
                    if (stack.peek() < 0) {
                        stack.push(num);
                        break;
                    } else {
                        if (stack.peek() < -num) {
                            stack.pop();
                            if (stack.isEmpty()) {
                                stack.push(num);
                                break;
                            }
                        } else if (stack.peek() == -num) {
                            stack.pop();
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        _735_行星碰撞 a = new _735_行星碰撞();
        int[] data = {-2, -1, 2, -2};
        System.out.println(Arrays.toString(a.asteroidCollision(data)));
    }

}
