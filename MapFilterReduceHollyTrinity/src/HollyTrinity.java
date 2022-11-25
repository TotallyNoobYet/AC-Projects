import java.util.stream.Stream;

public class HollyTrinity {

    private String message;
    private Stream<String> messageStream;

    private String newMessage;


    public HollyTrinity(String message){
        this.message = message;
        this.messageStream = Stream.of(message.split(" "));
    }

    public void getNewMessageResolved(){
        newMessage = messageStream
                .filter(word -> !word.equals("garbage"))
                .map(word -> word.toUpperCase())
                .reduce(" ", (acc, word) -> acc + " " +  word);
        System.out.println(newMessage);
    }
}
