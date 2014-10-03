package com.eidoscode.samples.builder;

public abstract class DefaultCar implements Car {

  // Required parameters
  private final String brand;
  private final String type;

  // Optional parameters
  private final int power;
  private final int torque;
  private final int gears;
  private final String color;

  public static abstract class Builder<C extends DefaultCar, B extends Builder<C, B>> {

    // Required parameters
    private final String brand;
    private final String type;

    // Optional parameters
    private int power;
    private int torque;
    private int gears;
    private String color;

    public Builder(String brand, String type) {
      this.brand = brand;
      this.type = type;
    }

    @SuppressWarnings("unchecked")
    public B power(int power) {
      this.power = power;
      return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B torque(int torque) {
      this.torque = torque;
      return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B gears(int gears) {
      this.gears = gears;
      return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B color(String color) {
      this.color = color;
      return (B) this;
    }

    public String getBrand() {
      return brand;
    }

    public String getType() {
      return type;
    }

    public int getPower() {
      return power;
    }

    public int getTorque() {
      return torque;
    }

    public int getGears() {
      return gears;
    }

    public String getColor() {
      return color;
    }

    protected abstract B newBuilder(C car);

    // protected B decorate(C car, B builder) {
    // return
    // builder.power(car.getPower()).torque(car.getTorque()).gears(car.getGears()).color(car.getColor());
    // }

    public abstract C build();

  }

  protected <C extends DefaultCar, B extends Builder<C, B>> DefaultCar(Builder<C, B> builder) {
    this.brand = builder.brand;
    this.type = builder.type;
    this.power = builder.power;
    this.torque = builder.torque;
    this.gears = builder.gears;
    this.color = builder.color;
  }

  public String getBrand() {
    return brand;
  }

  public String getType() {
    return type;
  }

  public int getPower() {
    return power;
  }

  public int getTorque() {
    return torque;
  }

  public int getGears() {
    return gears;
  }

  public String getColor() {
    return color;
  }

  protected <C extends DefaultCar, B extends Builder<C, B>> B decorate(B builder) {
    return builder.power(getPower()).torque(getTorque()).gears(getGears()).color(getColor());
  }

  protected abstract <C extends DefaultCar, B extends Builder<C, B>> B newBuilder();

  public abstract <C extends DefaultCar, B extends Builder<C, B>> B toBuilder();

}
