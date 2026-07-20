package com.health.fitness;


import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.health.fitness.HealthIndexScore.FitnessLevel;
/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#4.1 – Normal Boundary value testing
 * Instructor: Asst.Prof. Chitsutha Soomlek
 * 
 * 	    VO2 Max	    RHR	    HRR
 * min-	inv	        inv	    inv
 * min	0	        40	     0
 * min+	1	        41	     1
 * nom	45	        72	    15
 * max-	99	        219	    29
 * max	100	        220	    30
 * max+	inv	        inv	    inv
 */

class NormalTesting{

    @Test
    @DisplayName("TC001: all nom value -- total=9, STANDARD")
    void tc001(){
        HealthIndexScore h = new HealthIndexScore(45,70,15);
        assertEquals(9,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }
}


