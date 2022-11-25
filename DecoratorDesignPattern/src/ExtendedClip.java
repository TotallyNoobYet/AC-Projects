public class ExtendedClip extends GunDecorator{


    public ExtendedClip(Gun DecoratedGun) {
        super(DecoratedGun);
    }

    @Override
    public String useAccessory(){
        return decoratedGun.useAccessory() + " using extended clip";
    }
}
