import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramComp implements Iterable<String> {

    private String STR;
    private HashMap<String, Integer> myHasMap;


    public WordHistogramComp(String STR){
        this.STR = Main.STRING;
        String[] words = STR.split(" ");
        this.myHasMap = new HashMap<>();
        for(String word : words){
            int repeatedWords = 1;
            if(myHasMap.containsKey(word)){
                repeatedWords++;
                myHasMap.put(word, repeatedWords);
            } else{
                myHasMap.put(word, repeatedWords);
            }
        }
    }


    @Override
    public Iterator iterator() {
        return myHasMap.keySet().iterator();
    }

    public int getSize(){
        return myHasMap.size();
    }

    public int getWord(String word){
        return myHasMap.get(word);

    }
}