package scripts;

import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.DynamicMouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSNPC;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;

import java.awt.*;
//baitas@lillemap.net
//lochnesas@gafy.net
//kamikadze@gafy.net

/**
 * Created by xeon on 17.3.7.
 */
@ScriptManifest(authors = {"Ghandi"}, category = "Misc", name = "Tutorial", description = "Testine klase naujiems metodams testuoti.")

public class Tutorial extends Script implements Painting {

   // Timer time = new Timer(3000);

   // private final int[] names = {5455, 7486, 7485, 7487, 7488, 7489};// 5455 bankininkas
    private String names = "RuneScape Guide";


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
    public void Test() {

    }


    private boolean talkToOponent() {
        RSNPC[] oponent = NPCs.findNearest(names);
        if (oponent.length != 0) {
            RSNPC name = oponent[0];
            if (name == null)
                return false;
            if (name.isOnScreen()) {

                DynamicClicking.clickRSNPC(name, "Talk");

               for (int i = 0;i<8; i++) {
                   NPCChat.clickContinue(true);
                   sleep(1000);
                   println(i);

               }

                NPCChat.selectOption("I've played in the past, but not recently.", true);
                for (int i = 0;i<4; i++) {
                    NPCChat.clickContinue(true);
                    sleep(1000);
                    println(i);
                }
                Options.TABS.CONTROLS.open();

//                return NPCChat.selectOption("Bank", true);

            }
        } else {
            return false;
        }
    return true;
    }
//        if(bankers != null && bankers.length > 0 && bankers[0].isOnScreen() && DynamicClicking.clickRSNPC(bankers[0], "Bank")){
//            long t = System.currentTimeMillis();
//            while(Timing.timeFromMark(t) < General.random(1500, 2500)){
//                if(Banking.isBankScreenOpen()){
//                    return true;
//                }
//                sleep(50, 150);
//                if(Player.isMoving()){
//                    t = System.currentTimeMillis();
//                }
//            }
//        }
//        return false;
//    }


    private int loop() {
        while (true) {
          //  nearBanker();
                talkToOponent();
                sleep(3000, 7000);


              return 42;
        }
    }
    @Override
    public void onPaint(Graphics g) {
  //      g.getColor(Color.GREEN);
        g.drawString("Script is running", 380, 330);
    }
}
