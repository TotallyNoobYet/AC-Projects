public class Demon extends Genie {

    private boolean isRecycled = false;

    public Demon(int maxWishes){
        super(maxWishes);
    }

    @Override
    public void grantWish(){
        if(isRecycled){
            System.out.println("Cannot grant wish");
        } else{
            super.grantWish();
            System.out.println("Your wish has been granted");
        }
    }

    public void recycle(){
        isRecycled = true;
    }
}
