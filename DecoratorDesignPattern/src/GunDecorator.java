public abstract class GunDecorator implements Gun{

    protected Gun decoratedGun;

    public GunDecorator(Gun DecoratedGun){
        this.decoratedGun = DecoratedGun;
    }

    @Override
    public String useAccessory() {
        return decoratedGun.useAccessory();
    }
}
