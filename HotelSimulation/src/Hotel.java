public class Hotel {

    private  Room[] rooms2Choose = new Room[5];

    private HotelChoices hotel;

    private int roomNumber;
    private int givenRoom;

    private Client client;

    public int seeGivenRoom() {
        return this.givenRoom;
    }

    public Hotel(HotelChoices hotel) {
        this.hotel = hotel;
        for (int i = 0; i < rooms2Choose.length; i++) {
            Room room = new Room(i);
            rooms2Choose[i] = room;
        }
    }

    public void checkIn(Client client) {
        this.client = client;
        for (int i = 0; i < rooms2Choose.length; i++) {
            if (rooms2Choose[i].showIsAvailable() == true) {
                System.out.println(this.client.toString() + " you have Checked-In! Your room is room " + i);
                rooms2Choose[i].setIsAvailable(false);
                givenRoom = i;
                System.out.println("-------------------");
                break;
            }else if((rooms2Choose[rooms2Choose.length - 1].showIsAvailable()) == false){
                System.out.println("Oh no, " + this.client + "! All rooms are occupied!\n You'll have to look someplace else...");
                System.out.println("-------------------");
                break;
            } else if (rooms2Choose[i].showIsAvailable() == false) {
                System.out.println("Room " + i + " is occupied...\n Let's see more...");
                System.out.println("-------------------");
                if ((rooms2Choose[rooms2Choose.length - 1].showIsAvailable()) == false) {
                    System.out.println("Oh no," + this.client + "! All rooms are occupied!\n You'll have to look someplace else...");
                    System.out.println("-------------------");
                    break;
                }
            }
        }
    }

    public void checkOut(Client client , int roomKey) {
        rooms2Choose[roomKey].setIsAvailable(true);
        System.out.println(this.client + " you have Checked-Out!");
    }

}


