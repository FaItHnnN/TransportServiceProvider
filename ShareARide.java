class ShareARide implements Service {

    private final int fare;
    private final int bookingFee;
    private final int surcharge;

    private static final int DEFAULT_FARE = 50;
    private static final int DEFAULT_BOOKINGFEE = 0;
    private static final int DEFAULT_SURCHARGE = 500;
    private static final int LOWER_TIME_LIMIT = 600;
    private static final int UPPER_TIME_LIMIT = 900;
    
    ShareARide() {
        this.fare = DEFAULT_FARE;
        this.bookingFee = DEFAULT_BOOKINGFEE;
        this.surcharge = DEFAULT_SURCHARGE;
    }

    @Override
    public int getFare() {
        return this.fare;
    }

    @Override
    public int getBookingFee() {
        return this.bookingFee;
    }

    @Override
    public int getSurcharge() {
        return this.surcharge;
    }

    @Override
    public int computeFare(int distance, int pax, int time) {
        if (time >= LOWER_TIME_LIMIT && time <= UPPER_TIME_LIMIT) {
            int total = this.getFare() * distance +
                this.getSurcharge() +
                this.getBookingFee();
            return total / pax;
        } else {
            int total = this.getFare() * distance + this.getBookingFee();
            return total / pax;
        }
    }

    @Override
    public String toString() {
        return "ShareARide";
    }
}
