import java.util.List;

class PrivateCar implements Driver {
    
    private final String licensePlate;
    private final int passengerWaitingTime;
    private final List<Service> services;

    PrivateCar(String licensePlate, int passengerWaitingTime) {
        this.licensePlate = licensePlate;
        this.passengerWaitingTime = passengerWaitingTime;
        this.services = List.of(new JustRide(), new ShareARide());
    }

    @Override
    public String getLicense() {
        return this.licensePlate;
    }

    @Override
    public int getWaitingTime() {
        return this.passengerWaitingTime;
    }

    @Override
    public List<Service> getServices() {
        return this.services;
    }

    @Override
    public String toString() {
        return this.getLicense() + " (" + this.getWaitingTime() + " mins away) PrivateCar";
    }
}
