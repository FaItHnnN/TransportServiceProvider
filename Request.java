class Request {
    
    private final int distance;
    private final int pax;
    private final int time;

    Request(int distance, int pax, int time) {
        this.distance = distance;
        this.pax = pax;
        this.time = time;
    }
 
    public int getDistance() {
        return this.distance;
    }

    public int getNumOfPassengers() {
        return this.pax;
    }

    public int getTime() {
        return this.time;
    }

    public int computeFare(Service service) {
        return service.computeFare(distance, pax, time);
    }

    public String toString() {
        return this.getDistance() +
            "km for " + 
            this.getNumOfPassengers() +
            "pax @ " +
            this.getTime() +
            "hrs";
    }
}
