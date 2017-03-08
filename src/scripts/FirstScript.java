package scripts;

import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;

import java.awt.*;


/**
 * Created by xeon on 17.3.7.
 */
@ScriptManifest(authors = {"Ghandi"}, category = "Misc", name = "Testai", description = "Testine klase naujiems metodams testuoti.")

public class FirstScript extends Script implements Painting {

    Timer time = new Timer(3000);

    private final int[] ROCK_ID = {2095, 7486, 7485, 7487, 7488, 7489};
    private final int[] dontDrop = {1351, 1265, 555, 559, 590, 556};

    private boolean onStart() {
        println("Testas paleistas");
        return true;

    }
    @Override
    public void run() {
        if (onStart()) {
            while (true) {
                sleep(loop());
            }
        }
    }
//        while(true){
//            System.out.println("Darius galejo ir pats taip pasileisti.");
//            General.sleep(5000);
//        }
    public RSObject findNearest(int distance, int...ids){
        RSObject[] objects = Objects.findNearest(distance, ids);
            for (RSObject object : objects){
                if (object != null){
                    return object;
                }
            }
        return null;

    }

    private int loop()
     {
         if (Inventory.isFull()) {
             Inventory.dropAllExcept(dontDrop);
         } else {
             if (Player.getRSPlayer().getAnimation() == -1){
                 RSObject rock = findNearest(15,ROCK_ID);
              if (rock != null){
                  if (rock.isOnScreen()){
                      rock.click("Mine");
                      time.reset();
                      while (Player.getRSPlayer().getAnimation() == -1 && time.isRunning()) {
                          sleep(10);
                      }
                  }
              }
             }
         }
             return 42;
    }

    @Override
    public void onPaint(Graphics g) {
  //      g.getColor(Color.GREEN);
        g.drawString("Script is running", 380, 330);
    }
}
