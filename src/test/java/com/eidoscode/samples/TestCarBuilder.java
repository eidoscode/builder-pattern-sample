package com.eidoscode.samples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.eidoscode.samples.builder.Car;
import com.eidoscode.samples.builder.ElectricCar;
import com.eidoscode.samples.builder.InternalCombustionCar;
import static org.junit.Assert.assertNotSame;

/**
 * Test the Car builder.
 * 
 * @author antonini
 * @since 1.0
 * @version 1.0
 * 
 */
public class TestCarBuilder {

  private static final Logger logger = Logger.getLogger(TestCarBuilder.class);

  @Test
  public void testInternalCombustionCar() {
    logger.info("Checking If the white Toyota Avensis returns the same object to avoid memory consumption.");
    Car toyotaAvensis1 = new InternalCombustionCar.Builder("Toyota", "Avensis").color("white").build();
    Car toyotaAvensis2 = new InternalCombustionCar.Builder("toyota", "avensis").color("White").build();
    assertSame(toyotaAvensis1, toyotaAvensis2);
    assertEquals("Toyota", toyotaAvensis2.getBrand());
    assertEquals("Avensis", toyotaAvensis2.getType());
    assertEquals("White", toyotaAvensis2.getColor());
    logger.debug(toyotaAvensis1);
    logger.info("ok.");

    logger.info("Checking If a not white Toyota Avensis returns new object instances.");
    Car toyotaCorolla1 = new InternalCombustionCar.Builder("Toyota", "Corolla").color("Black").build();
    Car toyotaCorolla2 = new InternalCombustionCar.Builder("Toyota", "Corolla").color("Black").build();
    assertNotSame(toyotaCorolla1, toyotaCorolla2);
    assertEquals(toyotaCorolla1.getBrand(), toyotaCorolla2.getBrand());
    assertEquals(toyotaCorolla1.getType(), toyotaCorolla2.getType());
    assertEquals(toyotaCorolla1.getColor(), toyotaCorolla2.getColor());
    logger.debug(toyotaCorolla1);

    logger.info("Check If any other Car with same properties return a different object.");
    Car toyotaHillux1 = new InternalCombustionCar.Builder("Toyota", "Hillux").color("grey").build();
    Car toyotaHillux2 = new InternalCombustionCar.Builder("Toyota", "Hillux").color("grey").build();
    assertNotSame(toyotaHillux1, toyotaHillux2);
    assertEquals(toyotaHillux1.getBrand(), toyotaHillux2.getBrand());
    assertEquals(toyotaHillux1.getType(), toyotaHillux2.getType());
    assertEquals(toyotaHillux1.getColor(), toyotaHillux2.getColor());
    logger.debug(toyotaHillux1);
  }

  @Test
  public void testeElectricCar() {
    final ElectricCar tesla = new ElectricCar.Builder("Tesla", "S").power(310).torque(600).gears(1).batteryCapacity(60).build();
    final ElectricCar regularTesla = tesla.toBuilder().color("Grey").build();
    final ElectricCar customTesla = tesla.toBuilder().color("White").batteryCapacity(85).build();
    assertNotSame(tesla, regularTesla);
    assertNotSame(tesla, customTesla);

    assertEquals(tesla.getBrand(), regularTesla.getBrand());
    assertEquals(tesla.getBrand(), customTesla.getBrand());

    assertEquals(tesla.getType(), regularTesla.getType());
    assertEquals(tesla.getType(), customTesla.getType());

    logger.debug(tesla);
    logger.debug(regularTesla);
    logger.debug(customTesla);
  }
}
