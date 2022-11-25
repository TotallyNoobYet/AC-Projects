import java.util.Iterator;

public class Range implements Iterable<Integer> {
    protected int min;
    protected int max;

    Range(int min, int max){
        this.min = min;
        this.max = max;
    }
    

    @Override
    public Iterator iterator() {
        return new MyIterator(min);
    }

    public class MyIterator implements Iterator <Integer>  {

        private Integer current;


        MyIterator(Integer current){
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            if(current == max + 1){
                return false;
            } else{
                return true;
            }
        }

        @Override
        public Integer next() {
            if(!(hasNext())){
                return -1;
            }
           return current++;
        }




    }

}
