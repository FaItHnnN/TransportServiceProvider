import java.util.List;

void main() {
}

public static List<Booking> findBestBooking(Request req, List<Driver> drivers) {
    List<Booking> unsorted = drivers.stream()
        .flatMap(d -> d.getServices().stream()
        .map(s -> new Booking(d, req, s)))
        .toList();
    return unsorted.stream().sorted((x, y) -> x.compareTo(y)).toList();
}

