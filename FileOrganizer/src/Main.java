public class Main {

    public static void main(String[] args) {

        FileAnalyzer fileAnalyzer = new FileAnalyzer("src/FMLFile");
       // fileAnalyzer.print();
       // System.out.println(fileAnalyzer.firstWordBiggerThan(4).get());
       // System.out.println(fileAnalyzer.count().get());
        System.out.println(fileAnalyzer.nBiggestWords(2).get());

    }
}
