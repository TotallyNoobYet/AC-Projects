public class HandGun implements Gun {

    /*  Sometimes we want to add features to individual objects at runtime
    it's possible to nest decorators recursively, in order to add functionality and avoid class explosion*/


    @Override
    public String useAccessory() {
        return "Basic HandGun";
    }

}
