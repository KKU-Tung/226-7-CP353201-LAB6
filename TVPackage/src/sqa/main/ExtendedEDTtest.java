package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.TVPlan.TVPackage;

class ExtendedEDTtest {

    TVPlan Tvplan;

    @ParameterizedTest
    @CsvSource({
    	"P1, A3, true, 300",
    	"P1, A3, false, 350",
    	"P1, A1, true, 200",
    	"P1, A1, false, 250",
    	"P1, A2, true, 200",
    	"P1, A2, false, 250",
    	"P1, A0, true, 100",
    	"P1, A0, false, 150",
    	
    	"P2, A3, true, 500",
    	"P2, A3, false, 550",
    	"P2, A1, true, 400",
    	"P2, A1, false, 450",
    	"P2, A2, true, 400",
    	"P2, A2, false, 450",
    	"P2, A0, true, 300",
    	"P2, A0, false, 350",
    
    	"P3, A3, true, 600",
    	"P3, A3, false, 650",
    	"P3, A1, true, 500",
    	"P3, A1, false, 550",
    	"P3, A2, true, 500",
    	"P3, A2, false, 550",
    	"P3, A0, true, 400",
    	"P3, A0, false, 450",
    	
    	"P0, A0, false, 0",
    	"P4, A1, false, 0",
    	"P5, A2, false, 0"
    })
    void Extended_EDT_Test(String main, String addit, boolean discount,double ExpectedPrice) {

    	boolean offline_watching = false;
    	boolean live_service = false;
        TVPackage selected = null;

        if (main.equals("P1")) {
            selected = TVPackage.STANDARD;
        } else if (main.equals("P2")) {
            selected = TVPackage.PREMIUM;
        } else if (main.equals("P3")) {
            selected = TVPackage.FAMILY;
        }
        
       
        if(addit.equals("A1")) {
        	offline_watching  = true;
        } else if(addit.equals("A2")) {
            live_service  = true;
        } else if(addit.equals("A3")) {
        	offline_watching = true;
        	live_service  = true;
        }

        Tvplan = new TVPlan(offline_watching, live_service, discount);
        assertEquals(ExpectedPrice, Tvplan.pricePerMonth(selected));
    }
}
