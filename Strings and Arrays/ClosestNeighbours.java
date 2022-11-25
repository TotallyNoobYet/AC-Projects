class ClosestNeighbours {
    public static void main(String[] args) {

        int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};

        int position = 0;
        int smallest = 0;

        for(int i = 0; i < myArray.length -1; i++){
            int calcDistance = Math.abs(myArray[i] - myArray[i +1]);
            if( smallest > calcDistance || i == 0){
                smallest = calcDistance;
                position = i;
            }
        }

        System.out.println(myArray[position]);
        System.out.println(myArray[position + 1]);
    }
}
