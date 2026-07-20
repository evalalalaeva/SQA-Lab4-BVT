package com.health.fitness;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
 
import com.health.fitness.HealthIndexScore.FitnessLevel;
/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#4.1 – Normal Boundary value testing
 * Instructor: Asst.Prof. Chitsutha Soomlek
 * 
 * 	VO2 Max	    RHR	    HRR
 * min-	-1	    39	    -1
 * min	0	    40	    0
 * min+	1	    41	    1
 * nom	45	    72	    15
 * max-	99	    219	    29
 * max	100	    220	    30
 * max+	101	    221	    31
 */

class RobustnessTesting{

    @Test
    @DisplayName("TC001: all nom value -- total=9, STANDARD")
    void tc001(){
        HealthIndexScore h = new HealthIndexScore(45,72,15);
        assertEquals(9,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC002: VO2Max=-1 , RHR=72 , HRR=15 -- throws IllegalArgumentException")
    void tc002(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> new HealthIndexScore(-1, 72, 15));
        assertEquals("VO2 Max cannot be negative.", ex.getMessage());
    }
   
    @Test
    @DisplayName("TC003: VO2Max=0 , RHR=72 , HRR=15 -- total=6, STANDARD")
    void tc003(){
        HealthIndexScore h = new HealthIndexScore(0,72,15);
        assertEquals(6,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC004: VO2Max=1 , RHR=72 , HRR=15 -- total=6, STANDARD")
    void tc004(){
        HealthIndexScore h = new HealthIndexScore(1,72,15);
        assertEquals(6,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC005: VO2Max=99 , RHR=72 , HRR=15 -- total=11, STANDARD")
    void tc005(){
        HealthIndexScore h = new HealthIndexScore(99,72,15);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC006: VO2Max=100 , RHR=72 , HRR=15 -- total=11, STANDARD")
    void tc006(){
        HealthIndexScore h = new HealthIndexScore(100,72,15);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC007: VO2Max=101 , RHR=72 , HRR=15 -- total=11, STANDARD")
    void tc007(){
        HealthIndexScore h = new HealthIndexScore(101,72,15);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC008: VO2Max=45 , RHR=39 , HRR=15 -- throws IllegalArgumentException")
    void tc008(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> new HealthIndexScore(45, 39, 15));
        assertEquals("Resting Heart Rate (RHR) must be between 40 and 220 bpm.", ex.getMessage());
    }

    @Test
    @DisplayName("TC009: VO2Max=45, RHR=40 , HRR=15 -- total=11, STANDARD")
    void tc009(){
        HealthIndexScore h = new HealthIndexScore(45,40,15);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0010: VO2Max=45, RHR=41 , HRR=15 -- total=11, STANDARD")
    void tc0010(){
        HealthIndexScore h = new HealthIndexScore(45,41,15);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0011: VO2Max=45, RHR=219 , HRR=15 -- total=7, STANDARD")
    void tc0011(){
        HealthIndexScore h = new HealthIndexScore(45,219,15);
        assertEquals(7,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0012: VO2Max=45, RHR=220 , HRR=15 -- total=7, STANDARD")
    void tc0012(){
        HealthIndexScore h = new HealthIndexScore(45,220,15);
        assertEquals(7,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0013: VO2Max=45, RHR=221 , HRR=15 -- throws IllegalArgumentException")
    void tc0013(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> new HealthIndexScore(45, 221, 15));
        assertEquals("Resting Heart Rate (RHR) must be between 40 and 220 bpm.", ex.getMessage());
    }

    @Test
    @DisplayName("TC0014: VO2Max=45, RHR=72 , HRR=-1 -- throws IllegalArgumentException")
    void tc0014(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> new HealthIndexScore(45, 72, -1));
        assertEquals("Heart Rate Recovery (HRR) cannot be negative.", ex.getMessage());
    }

    @Test
    @DisplayName("TC0015: VO2Max=45, RHR=72 , HRR=0 -- total=7, STANDARD")
    void tc0015(){
        HealthIndexScore h = new HealthIndexScore(45,72,0);
        assertEquals(7,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0016: VO2Max=45, RHR=72 , HRR=1 -- total=7, STANDARD")
    void tc0016(){
        HealthIndexScore h = new HealthIndexScore(45,72,1);
        assertEquals(7,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0017: VO2Max=45, RHR=72 , HRR=29 -- total=11, STANDARD")
    void tc0017(){
        HealthIndexScore h = new HealthIndexScore(45,72,29);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0018: VO2Max=45, RHR=72 , HRR=30 -- total=11, STANDARD")
    void tc0018(){
        HealthIndexScore h = new HealthIndexScore(45,72,30);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC0019: VO2Max=45, RHR=72 , HRR=31 -- total=11, STANDARD")
    void tc0019(){
        HealthIndexScore h = new HealthIndexScore(45,72,31);
        assertEquals(11,h.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, h.getFitnessLevel());
    }

}
