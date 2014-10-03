package com.eidoscode.samples.builder;

/**
 * Declares Car interface.
 * 
 * @author antonini
 * @since 1.0
 * @version 1.0
 */
public interface Car {

  String getBrand();

  String getType();

  int getPower();

  int getTorque();

  int getGears();

  String getColor();

  /*
  Builder<? extends Car, ?> toBuilder();
  static class Hidden {

    protected static class DefaultCar implements Car {

      // Required parameters
      private final String brand;
      private final String type;

      // Optional parameters
      protected int power;
      protected int torque;
      protected int gears;
      protected String color;

      private DefaultCar(String brand, String type) {
        this.brand = brand;
        this.type = type;
      }

      protected <CAR extends Car> DefaultCar(Builder<CAR, ?> builder) {
        this(builder.getBrand(), builder.getType());
        this.power = builder.power;
        this.torque = builder.torque;
        this.gears = builder.gears;
        this.color = builder.color;
      }

      @Override
      public String getBrand() {
        return brand;
      }

      @Override
      public String getType() {
        return type;
      }

      @Override
      public int getPower() {
        return power;
      }

      @Override
      public int getTorque() {
        return torque;
      }

      @Override
      public int getGears() {
        return gears;
      }

      @Override
      public String getColor() {
        return color;
      }

      @Override
      public String toString() {
        return "DefaultCar [brand=" + brand + ", type=" + type + ", power=" + power + ", torque=" + torque + ", gears=" + gears + ", color=" + color + "]";
      }

      protected Builder<Car, Builder<?, ?>> newBuilder() {
        return new Builder(getBrand(), getType());
      }

      protected Builder decorate(Builder builder) {
        super.decorate(builder);
        return builder.batteryCapacity(getBatteryCapacity());
      }

      @Override
      public Builder toBuilder() {
        return (Builder) super.toBuilder();
      }

    }
  }

  public static abstract class Builder<CAR extends Car, BUILDER extends Builder<CAR, ?>> extends Hidden.DefaultCar {

    public Builder(String brand, String type) {
      super(brand, type);
    }

    @SuppressWarnings("unchecked")
    public BUILDER power(int power) {
      this.power = power;
      return (BUILDER) this;
    }

    @SuppressWarnings("unchecked")
    public BUILDER torque(int torque) {
      this.torque = torque;
      return (BUILDER) this;
    }

    @SuppressWarnings("unchecked")
    public BUILDER gears(int gears) {
      this.gears = gears;
      return (BUILDER) this;
    }

    @SuppressWarnings("unchecked")
    public BUILDER color(String color) {
      this.color = color;
      return (BUILDER) this;
    }

    public abstract CAR build();
  }
  */
}
