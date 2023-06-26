import java.util.Vector;
public class GarageController implements IGarageController{
    private IGarageController garageController;
    private IParkinController parkinController;
    private IParkoutController parkoutController;
    private IAdminController adminController;

    private String vehicleInLine = "";
    private GarageUI ginterface;
    private Vector<Vehicle> vehicles = new Vector<Vehicle>();
    private Garage garage = new Garage();

    public GarageController(){
        garageController = this;
        parkinController = new ParkinController();
        parkoutController = new ParkoutControler();
        adminController = new AdminController();
        ginterface = new GarageUI(this);
    }
    public void addGarageSlot(float l, float w) {
        if (adminController.isAuthorized()) {
            garage.addSlot(l, w);
        } else {
            ginterface.unauthorized();
        }
    }

    public Boolean isFull() {
        return garage.getOccupiedSlots() == garage.getNumSlots();
    }

    public Boolean addVehicle(String name, String id, int year, float len, float wid) {
        if (len < 0 || wid < 0) {
            return false;
        }
        vehicleInLine = id;
        if (getVehicle(id) != null) {
            return true;
        }
        Vehicle v = new Vehicle(name, id, year, len, wid);
        vehicles.add(v);
        garage.setTotalVehicles(garage.getTotalVehicles() + 1);
        return true;
    }

    public Vehicle getVehicle(String id) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.elementAt(i).getID().equals(id)) {
                return vehicles.elementAt(i);
            }
        }
        return null;
    }

    public void ShowSlot() {
        var numberofFreeSlots = 0;
        String SlotReport = "";
        for (int i = 0; i < getGarage().getNumSlots(); i++) {
            var s = getGarage().getSlots()[i];
            if (s.getOccupant() == null) {
                SlotReport += "Slot " + i + " is free\n" + " length : " + s.getLength() + " width :  " + s.getWidth() + "\n";
                numberofFreeSlots++;
            }
        }
        SlotReport += "\nNumber of Free Slots : " + numberofFreeSlots;
        getUI().showSlotsInfo(SlotReport);
    }

    public IGarage getGarage() {
        return garage;
    }

    //getters for the controllers
    public IGarageController getGarageController() {
        return garageController;
    }

    public void setGarageController(IGarageController garageController) {
        this.garageController = garageController;
    }

    public IParkinController getParkinController() {
        return parkinController;
    }

    public void setParkinController(IParkinController parkinController) {
        this.parkinController = parkinController;
    }

    public IParkoutController getParkoutController() {
        return parkoutController;
    }

    public void setParkoutController(IParkoutController parkoutController) {
        this.parkoutController = parkoutController;
    }

    public IAdminController getAdminController() {
        return adminController;
    }

    public void setAdminController(IAdminController adminController) {
        this.adminController = adminController;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }


    public void setVehicleInLine(String vehicleInLine) {
        this.vehicleInLine = vehicleInLine;
    }

    public String getVehicleInLine() {
        return vehicleInLine;
    }

    public GarageUI getUI(){
        return ginterface;
    }
}