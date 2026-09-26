package pt.upt.quality.campusride;

public class RentalService {
    private final Fleet fleet;

    public RentalService(Fleet fleet) {
        this.fleet = fleet;
    }

    public void rentVehicle(String id) {
        findVehicle(id).rent();
    }

    public void returnVehicle(String id) {
        findVehicle(id).returnVehicle();
    }

    public double estimatePrice(String id, int minutes) {
        return findVehicle(id).calculatePrice(minutes);
    }

    private Vehicle findVehicle(String id) {
        Vehicle vehicle = fleet.findById(id);
        if (vehicle == null) {
            throw new IllegalArgumentException("Unknown vehicle id: " + id);
        }
        return vehicle;
    }
}
