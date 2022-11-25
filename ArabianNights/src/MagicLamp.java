public class MagicLamp {

    private int capacity;

    private int remainingGenies;
    private int timesRecharged;

    MagicLamp(int capacity){
        this.capacity = capacity;
        this.remainingGenies = capacity;
    }

    public Genie rub(int maxWishes){
        int random = (int) Math.ceil(Math.random() * capacity);

        if(remainingGenies > 0){
            remainingGenies--;
            if(random % 2 == 0){
                return new FriendlyGenie(maxWishes);

            } else {
                return new GrumpyGenie(maxWishes);
            }

        }

        return new Demon(maxWishes);
    }

    public void recharge(Genie genie){

        if(!(genie instanceof Demon)){
            System.out.println("You don't have a Demon, tho");
            System.out.println("Can't recharge");
           return;
        }
        System.out.println("MagicLamp recharged");
        Demon myDemon = (Demon) genie;
        myDemon.recycle();
        remainingGenies = capacity;
        timesRecharged++;
    }

    public boolean isEqual(MagicLamp lamp){
        if(this.capacity == lamp.capacity && this.remainingGenies == lamp.remainingGenies && this.timesRecharged == lamp.timesRecharged) {
            return true;
        }
        return false;
    }


}
