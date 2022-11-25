import java.util.*;
 

public class ToDoList {

    private PriorityQueue<ToDoItem> queue;

    public ToDoList() {
        this.queue = new PriorityQueue<>();
    }

    public void add(Importance importance, int priority, String itemDiscription) {
        queue.offer(new ToDoItem(importance, priority, itemDiscription));
    }

    public ToDoItem remove() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public class ToDoItem implements Comparable<ToDoItem> {

        private Importance importance;
        private int priority;
        private String item;

        ToDoItem(Importance importance, int priority, String item) {
            this.priority = priority;
            this.importance = importance;
            this.item = item;
        }

        @Override
        public String toString() {
            return "ToDoItem{" +
                    "importance =" + importance +
                    ", priority =" + priority +
                    ", item ='" + item + '\'' +
                    '}';
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (this.importance == o.importance) {
                return this.priority - o.priority;
            }
            return this.importance.compareTo(o.importance);
        }
    }
}
