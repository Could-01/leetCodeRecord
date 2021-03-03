package 贪心;

public class _1518_换酒问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles <= numExchange) return numBottles < numExchange ? numBottles : numBottles + +1;
        int Empty = numBottles;
        while (Empty >= numExchange) {
            numBottles = numBottles + Empty / numExchange;
            Empty = Empty / numExchange + Empty % numExchange;
        }
        return numBottles;
    }

    public static void main(String[] args) {
        _1518_换酒问题 a = new _1518_换酒问题();
        System.out.print(a.numWaterBottles(9, 3));
    }
}
