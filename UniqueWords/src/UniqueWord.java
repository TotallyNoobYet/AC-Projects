import java.util.*;

//use set
//Have to implement iterator

public class UniqueWord implements Iterable<String>{

    private String uniqueWords;

    private TreeSet<String> treeSet;

    public UniqueWord(String uniqueWords){
        this.uniqueWords = uniqueWords;
        String[] elements = uniqueWords.split(" ");
        this.treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList(elements));
    }


    @Override
    public String toString() {
        return "UniqueWord{" +
                "uniqueWords ='" + uniqueWords + '\'' +
                ", treeSet = " + treeSet +
                '}';
    }

    @Override
    public Iterator<String> iterator() {
        return treeSet.iterator();
    }

}
