package gaule.village.javanoramix.domain.barde;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssurancetourixTest {
    @Test
    public void chanterEnAccordantSaLyreEtEnFaisantDesVocalises() {
        // Arrange
        Assurancetourix sut = new Assurancetourix();

        // Act
        String chanson = sut.chanter("test");

        // Assert
        assertTrue(chanson.startsWith("*accorde sa lyre* PLING PLONG… *s'éclaircit la voix* Hum hum… MI-MI-MIIIIII..."));
    }

    @Test
    public void chanterEnFinissantDeFaçonLyrique() {
        // Arrange
        Assurancetourix sut = new Assurancetourix();

        // Act
        String chanson = sut.chanter("test");

        // Assert
        assertTrue(chanson.endsWith("... LAAAAAAA !!"));
    }

    @Test
    public void chanterLeTexteDemandé() {
        // Arrange
        Assurancetourix sut = new Assurancetourix();

        // Act
        String chanson = sut.chanter("une chanson douce");

        // Assert
        assertTrue(chanson.contains("une chanson douce"));
    }
}
