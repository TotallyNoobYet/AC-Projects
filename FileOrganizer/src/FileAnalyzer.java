import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class FileAnalyzer {

    private Stream<String> stream;
    private String filePath;
    private File file;
    private Supplier<Stream<String>> streamSupplier;


    public FileAnalyzer(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);

        this.streamSupplier = () -> {
            try {
                this.stream = Stream.of(Files.readString(file.toPath()).split(" "));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stream;
        };

    }

    @Override
    public String toString() {
        return "FileAnalyzer{" +
                "stream=" + stream +
                ", filePath='" + filePath + '\'' +
                ", file=" + file +
                ", streamSupplier=" + streamSupplier +
                '}';
    }

    public void print() {
        streamSupplier.get().forEach(System.out::println);
    }

    public Optional<String> firstWordBiggerThan(Integer n) {
        return Optional.ofNullable(streamSupplier.get()
                .filter(word -> word.length() > n)
                .findFirst()).get();
    }

    public Optional<String> nBiggestWords(Integer limit) {

        return Optional.ofNullable(streamSupplier.get()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(limit)
                .reduce(" ", (acc, word) -> acc + " " + word));
    }

    public Optional<Long> count() {
        return Optional.of(streamSupplier.get()
                .count());
    }

    public Optional<String> commonWords(String filePath) {
        return null;

    }


}
