import java.util.Optional;

class Booking implements Comparable<Booking> {

    private final Driver driver;
    private final Request req;
    private final Optional<Service> service;

    Booking(Driver driver, Request req) {
        this.driver = driver;
        this.req = req;
        this.service = Optional.empty();
    }

    Booking(Driver driver, Request req, Service service) {
        this.driver = driver;
        this.req = req;
        this.service = Optional.of(service);
    }
    
    protected Driver getDriver() {
        return this.driver;
    }

    protected Request getRequest() {
        return this.req;
    }

    public Optional<Service> getBestService() {
        return this.service
            .or(() -> 
                this.getDriver().getServices()
                .stream() 
                .reduce((s1, s2) -> 
                    this.getRequest().computeFare(s1) < this.getRequest().computeFare(s2) ? 
                    s1 : 
                    s2)
            );
    }
        

    protected Optional<Integer> getBestFare() {
        return this.service
        .map(s -> this.getRequest().computeFare(s))
        .or(() -> getBestService().map(s -> this.getRequest().computeFare(s)));
    }

    @Override
    public int compareTo(Booking other) {
        int compareFare = Integer.compare(this.getBestFare().map(f -> f).orElse(0), 
            other.getBestFare().map(f -> f).orElse(0));
        if (compareFare == 0) {
            return Integer.compare(this.getDriver().getWaitingTime(), 
                other.getDriver().getWaitingTime());
        } else {
            return compareFare;
        }
    }

    
    @Override
    public String toString() {
        return getBestFare()
            .map(fare -> String.format("$%.2f", fare / 100.0)) 
            .orElse("$0.00") + 
            " using " + 
            this.getDriver().toString() + 
            " (" + this.getBestService().map(s -> s.toString()).orElse("") + ")";
    }
}
