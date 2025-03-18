package model;

import java.util.Objects;

/*** Author: Roman Romashko Date: 17.03.2025 ***/

public class Car {
    private final int id;
    private String model;
    private double price;
    private boolean isBusy; // занята?
    private final int year;

    public Car(int id, String model, double price, int year) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;
        return id == car.id && Double.compare(price, car.price) == 0 && isBusy == car.isBusy && year == car.year && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(model);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + Boolean.hashCode(isBusy);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", isBusy=" + isBusy +
                ", year=" + year +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public int getYear() {
        return year;
    }
}
