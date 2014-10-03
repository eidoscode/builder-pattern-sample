package com.eidoscode.samples.builder;

public class ElectricCar extends DefaultCar {

  private final int batteryCapacity;

  public static class Builder extends DefaultCar.Builder<ElectricCar, Builder> {

    private int batteryCapacity;

    public Builder(String brand, String type) {
      super(brand, type);
    }

    public int getBatteryCapacity() {
      return batteryCapacity;
    }

    public Builder batteryCapacity(int batteryCapacity) {
      this.batteryCapacity = batteryCapacity;
      return this;
    }

    // @Override
    // protected Builder decorate(ElectricCar car, Builder builder) {
    // Builder retBuilder = super.decorate(car, builder);
    // retBuilder.batteryCapacity(getBatteryCapacity());
    // return retBuilder;
    // }

    @Override
    protected Builder newBuilder(ElectricCar car) {
      return new Builder(car.getBrand(), car.getType());
    }

    @Override
    public ElectricCar build() {
      return new ElectricCar(this);
    }

  }

  protected ElectricCar(Builder builder) {
    super(builder);
    this.batteryCapacity = builder.getBatteryCapacity();
  }

  public int getBatteryCapacity() {
    return batteryCapacity;
  }

  @Override
  @SuppressWarnings("unchecked")
  protected Builder newBuilder() {
    return new Builder(getBrand(), getType());
  }

  @Override
  @SuppressWarnings("unchecked")
  public Builder toBuilder() {
    return decorate(newBuilder());
  }

  @Override
  public String toString() {
    return "ElectricCar [brand=" + getBrand() + ", type=" + getType() + ", batteryCapacity=" + batteryCapacity + ", power=" + getPower() + ", torque="
        + getTorque() + ", gears=" + getGears() + ", color=" + getColor() + "]";
  }

}
