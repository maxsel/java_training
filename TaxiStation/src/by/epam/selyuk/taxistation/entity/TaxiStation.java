package by.epam.selyuk.taxistation.entity;

import by.epam.selyuk.taxistation.utility.IdGenerator;

import java.util.*;

public class TaxiStation implements Iterable<Car> {
    public final int TAXISTATION_ID = IdGenerator.generate();
    private List<Car> carList;

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public TaxiStation() {
        carList = new ArrayList<>();
    }

    public void addCar(Car c) {
        carList.add(c);
    }

    public void addCars(Collection<? extends Car> cars) {
        carList.addAll(cars);
    }

    public void addCars(Car... cars) {
        for (Car c : cars) {
            addCar(c);
        }
    }

    public void removeCar(Car p) {
        carList.remove(p);
    }

    public void removeCar(int i) {
        carList.remove(i);
    }

    public void sort(Comparator<Car> carComparator) {
        Collections.sort(carList, carComparator);
    }

    @Override
    public Iterator<Car> iterator() {
        return carList.iterator();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TaxiStation {\n");
        sb.append("\tID = ").append(TAXISTATION_ID).append(",\n");
        sb.append("\tcarList : [\n");
        for(Car c : carList) {
            sb.append("\t\t").append(c).append("\n");
        }
        sb.append("\t]\n}");
        return sb.toString();
    }
}
