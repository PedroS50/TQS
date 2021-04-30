package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;
import euromillions.EuromillionsDraw;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoMain {

    static Logger logger = Logger.getLogger( "my_logger" );

    public static void main(String[] args) {
        // played sheet
        CuponEuromillions thisWeek = new CuponEuromillions();
        logger.log(Level.INFO, "Betting with three random bets...");
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

        // simulate a random draw
        EuromillionsDraw draw = EuromillionsDraw.generateRandomDraw();

        //report results
        logger.log(Level.INFO, "You played:");
        String weekFormat = draw.getDrawResults().format();
        logger.log(Level.INFO, weekFormat);

        logger.log(Level.INFO, "Draw results:");
        String drawFormat = draw.getDrawResults().format();
        logger.log(Level.INFO, drawFormat);

        logger.log(Level.INFO, "Your score:");
        for (Dip dip : draw.findMatches(thisWeek)) {
            String dipFormat = dip.format();
            logger.log( Level.INFO, dipFormat );

        }
    }
}
