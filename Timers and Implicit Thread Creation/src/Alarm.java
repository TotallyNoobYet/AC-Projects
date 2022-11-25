import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {

    private Timer timer =  new Timer();


    public void start(int interval, int numOfRings){

        //the one invoking run from Ring
        timer.scheduleAtFixedRate(new Ring(numOfRings), interval * 1000, interval * 1000);
    }


    public void stop(){
        timer.cancel();
    }

    public static void main(String[] args) {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        try {
            System.out.println("How many times do you want your alarm to ring?\n");
            int numOfRings = Integer.parseInt(input.readLine());

            System.out.println("How long between each ring?\n");
            int interval  = Integer.parseInt(input.readLine());

            Alarm alarm = new Alarm();
            alarm.start(interval, numOfRings);

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public class Ring extends TimerTask{

        private int numOfRings;

        public Ring(int numOfRings){
            this.numOfRings = numOfRings;
        }

        @Override
        public void run() {

            System.out.println("\nRing, Ring!");
            System.out.println("Wake up!");
            System.out.println("It's time to get up!");
            System.out.println("----------------------");
            numOfRings--;

            if(numOfRings == 0){

                System.out.println("The alarm was canceled");
                stop();
            }
        }
    }
    
}
