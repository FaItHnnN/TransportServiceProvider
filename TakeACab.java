class TakeACab implements Service {

    private final int fare;
    private final int bookingFee;
    private final int surcharge;

    private static final int DEFAULT_FARE = 33;
    private static final int DEFAULT_BOOKINGFEE = 200;
    private static final int DEFAULT_SURCHARGE = 0;

    TakeACab() {
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
        return this.getFare() * distance +
            this.getBookingFee() +
            this.getSurcharge();
    }

    @Override
    public String toString() {
        return "TakeACab";
    }

    
    
}
