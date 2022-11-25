public class GrumpyGenie extends Genie {

    private boolean hasGrantedWish = false;

    public GrumpyGenie(int maxWishes){
        super(maxWishes);
    }

    @Override
    public void grantWish(){
        if(!hasGrantedWish){
            super.grantWish();
            System.out.println("Your wish has been granted mf!");
            setMaxWishes();
            hasGrantedWish = true;
        }else{
            System.out.println("You have no more wishes mf!");
        }
    }
}
