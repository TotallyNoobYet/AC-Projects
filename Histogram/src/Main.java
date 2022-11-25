public class Main {
    public static String STRING = "test word words test 1 10 1";
    public static void main(String[] args) {

        WordHistogramInh wordHistogramInh = new WordHistogramInh(STRING);
        System.out.println("Map has " + wordHistogramInh.size() + " distinctive words");

        for(String word : wordHistogramInh){
            System.out.println(word + " : " + wordHistogramInh.get(word));
        }

        System.out.println("-------------------------");

        WordHistogramComp wordHistogramComp = new WordHistogramComp(STRING);
        System.out.println("Map has " + wordHistogramComp.getSize() + " distinctive words");


        for(String word : wordHistogramComp){
            System.out.println(word + " : " + wordHistogramComp.getWord(word));
        }
    }
}
