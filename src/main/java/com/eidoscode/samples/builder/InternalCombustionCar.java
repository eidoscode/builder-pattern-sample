package com.eidoscode.samples.builder;

public class InternalCombustionCar extends DefaultCar {

  protected InternalCombustionCar(Builder builder) {
    super(builder);
  }

  static class Hidden {

    private static final InternalCombustionCar TOYOTA_AVENSIS_WHITE = new InternalCombustionCar.Builder("Toyota", "Avensis").power(140).torque(250).gears(6)
        .color("White").forceBuildToyotaAvensis();

    private static class ToyotaAvensisCarImpl extends InternalCombustionCar {
      protected ToyotaAvensisCarImpl(Builder builder) {
        super(builder);
      }

      @Override
      public String getBrand() {
        return "Toyota";
      }

      @Override
      public String getType() {
        return "Avensis";
      }

      @Override
      public int getPower() {
        return 108;
      }

      @Override
      public int getTorque() {
        return 180;
      }

      @Override
      public int getGears() {
        return 6;
      }
    }
  }

  public static class Builder extends DefaultCar.Builder<InternalCombustionCar, Builder> {

    public Builder(String brand, String type) {
      super(brand, type);
    }

    @Override
    protected Builder newBuilder(InternalCombustionCar car) {
      return new Builder(car.getBrand(), car.getType());
    }

    private Hidden.ToyotaAvensisCarImpl forceBuildToyotaAvensis() {
      return new Hidden.ToyotaAvensisCarImpl(this);
    }

    @Override
    public InternalCombustionCar build() {
      if ("Toyota".equalsIgnoreCase(getBrand()) && "Avensis".equalsIgnoreCase(getType())) {
        if (Hidden.TOYOTA_AVENSIS_WHITE != null && "White".equalsIgnoreCase(getColor())) {
          return Hidden.TOYOTA_AVENSIS_WHITE;
        } else {
          return new Hidden.ToyotaAvensisCarImpl(newBuilder(Hidden.TOYOTA_AVENSIS_WHITE).color(getColor()));
        }
      } else {
        return new InternalCombustionCar(this);
      }
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  protected Builder newBuilder() {
    return null;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Builder toBuilder() {
    return null;
  }

  @Override
  public String toString() {
    return "InternalCombustionCar [brand=" + getBrand() + ", type=" + getType() + ", power=" + getPower() + ", torque=" + getTorque() + ", gears=" + getGears()
        + ", color=" + getColor() + "]";
  }

}
