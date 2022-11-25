public class Room {

    private int roomNumber;

    private boolean isAvailable = true;


    public Room(int roomNumber){
        this.roomNumber = roomNumber;

    }


    public boolean showIsAvailable(){
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

}