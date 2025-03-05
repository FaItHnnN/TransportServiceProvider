class JustRide implements Service {

    private final int fare;
    private final int bookingFee;
    private final int surcharge;

    private static final int DEFAULT_FARE = 22;
    private static final int DEFAULT_BOOKINGFEE = 0;
    private static final int DEFAULT_SURCHARGE = 500;
    private static final int LOWER_TIME_LIMIT = 600;
    private static final int UPPER_TIME_LIMIT = 900;

    JustRide() {
        this.fare = DEFAULT_FARE;
        this.surcharge = DEFAULT_SURCHARGE;
        this.bookingFee = DEFAULT_BOOKINGFEE;
    }

    @Override
    public int getFare() {
        return this.fare;
    }

    @Override
    public int getSurcharge() {
        return this.surcharge;
    }

    @Override
    public int getBookingFee() {
        return this.bookingFee;
    }

    @Override
    public int computeFare(int distance, int pax, int time) {
        if (time >= LOWER_TIME_LIMIT && time <= UPPER_TIME_LIMIT) {
            return this.getFare() * distance +
                this.getBookingFee() +
                this.getSurcharge();
        } else {
            return this.getFare() * distance +
                this.getBookingFee();
        }

    }


    @Override
    public String toString() {
        return "JustRide";
    }





}
