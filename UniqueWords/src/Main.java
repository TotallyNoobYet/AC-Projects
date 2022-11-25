public class Main {

    public static final String STRING = "Code cadet Code cadet Bem Bem Podre Podre Podre";

    public static void main(String[] args) {
        UniqueWord myUniqueWord = new UniqueWord(STRING.toLowerCase());

        for(String word: myUniqueWord){
            System.out.println(word);
        }
    }
}
