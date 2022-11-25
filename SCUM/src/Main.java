public class Main {
    public static void main(String[] args) {

        Machine<Integer> myMachine = new Machine<>();

        myMachine.mono(i1 -> i1 + i1, 100);
        myMachine.bio((i1, i2) -> i1 + i2, 666, 420);


    }
}
