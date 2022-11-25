public class Silencer extends GunDecorator{

    public Silencer(Gun DecoratedGun) {
        super(DecoratedGun);
    }

    @Override
    public String useAccessory(){
        return decoratedGun.useAccessory() + " using Silencer";
    }
}
