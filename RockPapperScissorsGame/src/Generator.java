public class Generator {

    public static Gestures randomOption(){
        Gestures[] options = Gestures.values();
        return options[(int)Math.floor(Math.random() * options.length)];
    }
}