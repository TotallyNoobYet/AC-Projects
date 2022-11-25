public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        toDoList.add(Importance.MEDIUM, 2, "Kick-Ass in lol" );
        toDoList.add(Importance.HIGH, 1, "Kick-Ass in lol");
        toDoList.add(Importance.LOW, 3, "Kick-Ass in lol");
        toDoList.add(Importance.HIGH, 1, "Kick-Ass in lol");
        toDoList.add(Importance.MEDIUM, 2, "Kick-Ass in lol");

        while(!toDoList.isEmpty()){
            System.out.println(toDoList.remove());
        }


    }
}
