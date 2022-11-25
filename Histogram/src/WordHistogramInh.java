
import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramInh extends HashMap<String, Integer> implements Iterable<String> {



    public WordHistogramInh(String str){
        String[] words = str.split(" ");
        for (String word : words){

            if(this.containsKey(word)){
                this.put(word, this.get(word) + 1);

            }
            else{
                this.put(word,1);
            }
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public Iterator iterator() {
        return super.keySet().iterator();
    }
}
