public class Main {
    public static void main(String[] args) {


        Gun gun = new Silencer(new ExtendedClip(new HandGun()));
        System.out.println(gun.useAccessory());

        Gun otherGun = new ExtendedClip(new Silencer(new HandGun()));
        System.out.println(otherGun.useAccessory());

        Gun anotherOne = new Silencer(new HandGun());
        System.out.println(anotherOne.useAccessory());

        Gun oneMore = new ExtendedClip(new HandGun());
        System.out.println(oneMore.useAccessory());
    }
}
