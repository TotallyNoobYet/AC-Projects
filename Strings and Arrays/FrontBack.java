class FrontBack {
    public static void main(String[] args) {

        String word = "heisenberg";

        //receive command line argument if available
        if(args.length > 0){
            word = args[0];
        }

        String middleLettersWord = word.substring(1, word.length());
        char firstLetter = word.charAt(word.length() -1);
        char lastLetter = word.charAt(0);

        String switchedCharsWord = firstLetter + middleLettersWord + lastLetter;

        System.out.println(switchedCharsWord);
    }