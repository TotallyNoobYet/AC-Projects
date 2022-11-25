class MissingChar {
    public static void main(String[] args) {

  String word = "Robocop";
  int characterIndex = 3;

  //receive command line argument if available
  if(args.length >= 2){
    word = args[0];
    characterIndex = Integer.parseInt(args[1]);
  }

  String firstHalfWord = word.substring(0,characterIndex);
  String secondHalfWord = word.substring(characterIndex +1);
  String missingCharWord = firstHalfWord + secondHalfWord;

  System.out.println(missingCharWord);

}
}