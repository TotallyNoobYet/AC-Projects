class NotString {
    public static void main(String[] args) {

        String word = "nota"; // what if the word is "nothing"?

        //receive command line argument if available
        if(args.length > 0){
            word = args[0];
        }

        String negation = "not";


        String first3CharWord = word.substring(0,4);

        if (first3CharWord.equals("not ")) {
            System.out.println(word);
        } else {
            System.out.print(negation + " " + word);
        }

    }
}