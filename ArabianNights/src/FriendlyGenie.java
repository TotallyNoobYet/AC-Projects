public class FriendlyGenie extends Genie {

    FriendlyGenie(int maxWishes){
        super(maxWishes);

    }
    @Override
    public void grantWish(){
        super.grantWish();
        if(getMaxWishes() > 0){
            System.out.println("Your wish has been granted mf!");
            setMaxWishes();
        }else{
            System.out.println("You have no more wishes mf!");
        }
    }
}
