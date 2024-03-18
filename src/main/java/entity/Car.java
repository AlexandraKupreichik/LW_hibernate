package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "distance")
    private int distance;

    @Column(name = "fuel")
    private String fuel;

    @Column(name = "fuel_consumption")
    private String fuelConsumption;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


// отношение One-to-One для Insurance

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cars", fetch = FetchType.LAZY, orphanRemoval = true)
    private Insurance insurance;


    public Car() {
    }

    public Car(String name, int year, int distance, String fuel, String fuelConsumption, int price) {
        this.name = name;
        this.year = year;
        this.distance = distance;
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        orders = new ArrayList<>();
        insurance = new Insurance();

    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", distance=" + distance +
                ", fuel='" + fuel + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                ", price=" + price +
                ", company=" + company +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        order.setCar(this);
        this.orders.add(order);
    }
    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public void addInsurance(Insurance newInsurance) {
        newInsurance.setCar(this);
        insurance=newInsurance;
    }

}
