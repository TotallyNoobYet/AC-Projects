import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PerfectNumbers {


    public static void main(String[] args) {

        PerfectNumbers myPerfectNumbers = new PerfectNumbers();
        myPerfectNumbers.checkPerfect(6);
    }


    public int sumDivisors(int target){
        int root = (int) Math.sqrt(target);
        int sum = IntStream.range(2, root + 1)
                .filter(x -> target % x == 0)
                .map(x -> x + target / x)
                .sum();

        if(target == 0){
            return -1;
        }
        return sum + 1;
    }

    public void checkPerfect(int limit){
        Stream.iterate(1, number -> number +1)
                .unordered()
                .filter(number -> number == sumDivisors(number))
                .parallel()
                .limit(limit)
                .forEach(System.out::println);
    }
}
