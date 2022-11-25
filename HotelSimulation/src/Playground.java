public class Playground {
    public static void main(String[] args) {

        Client client1 = new Client("Zé",3);
        Client client2 = new Client("Coutinho",3);
        Client client3 = new Client("Joana",3);
        Client client4 = new Client("Maria",3);
        Client client5 = new Client("Tony",3);
        Client client6 = new Client("Alberto",3);


        Hotel hotel = new Hotel(HotelChoices.hotelsClose2Me(client1.getChoiceOfHotel()));





        client2.checkInHotel(hotel);
        client1.checkInHotel(hotel);
        client3.checkInHotel(hotel);
        client4.checkInHotel(hotel);
        client5.checkInHotel(hotel);
        client6.checkInHotel(hotel);
        client6.chooseDiffHotel(4);













    }
}
