public class Main {

    public static void main(String[] args) {
        MagicLamp lamp1 = new MagicLamp(3);
        MagicLamp lamp2 = new MagicLamp(5);
        Genie genie, genie1, genie2, genie3, genie4, genie5;

        lamp1.isEqual(lamp2);
        genie = lamp1.rub(4);
        genie.grantWish();
        genie1 = lamp1.rub(3);
        genie1.grantWish();
        genie2 = lamp1.rub(5);
        genie2.grantWish();
        genie3 = lamp1.rub(3);
        genie3.grantWish();
        genie4 = lamp1.rub(2);
        genie4.grantWish();
        genie5 = lamp1.rub(7);
        genie5.grantWish();
        lamp1.recharge(genie);
        lamp1.recharge(genie4);
        lamp1.recharge(genie4);
        genie4.grantWish();

    }
}
