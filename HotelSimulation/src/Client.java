public class Client {

    private String name;

    private int roomKey = -1;
    private int choiceOfHotel;



    public Client(String name, int choiceOfHotel){
        this.name = name;
        this.choiceOfHotel = choiceOfHotel;
    }

    public int getChoiceOfHotel() {
        return choiceOfHotel;
    }

    public void chooseDiffHotel(int choiceOfHotel){
        this.choiceOfHotel = choiceOfHotel;
        Hotel diffHotel = new Hotel(HotelChoices.hotelsClose2Me(choiceOfHotel));
    }

    public int seeRoomKey(){
        return roomKey;
    }

    public void checkInHotel(Hotel hotel){
        if(roomKey == -1) {
            hotel.checkIn(this);
            roomKey = hotel.seeGivenRoom();
            // e se não conseguir fazer check in, porque está cheio o Hotel? Porque não se instancia logo outro hotel?
        } else {
            System.out.println("-------------------");
            System.out.println("Already Checked-In");
        }

    }

    public void checkOutHotel(Hotel hotel, int roomKey){
        this.roomKey = roomKey;
        if(roomKey == -1){
            System.out.println("-------------------");
            System.out.println("You haven't Checked-In\nBut we can do it now!");
            checkInHotel(hotel);

        }else if (roomKey >= 0) {
            hotel.checkOut(this, roomKey);
            roomKey = -1;
        }
    }


}


