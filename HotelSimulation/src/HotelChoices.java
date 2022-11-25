public enum HotelChoices {
    PESTANA(0),
    VILAGALE(1),
    WINDSOR(2),
    THELODHI(3),
    SOFITEL(4);

    private int pickHotel;

    HotelChoices(int pickHotel){
        this.pickHotel = pickHotel;

    }

    public static HotelChoices hotelsClose2Me(int choiceOfHotel){
        HotelChoices[] hotelsClose2Me = HotelChoices.values();
        return hotelsClose2Me[choiceOfHotel];
    }

}