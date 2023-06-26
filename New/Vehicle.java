public class Vehicle implements IVehicle {
    private String modelName;
    private String ID;
    private int assignedSlot;
    private int modelYear;
    private float length;
    private float width;
    private float arrivalTime;

    //CONSTRUCTOR
    public Vehicle(String modelName, String ID, int modelYear, float length, float width) {
        this.modelName = modelName;
        this.ID = ID;
        this.modelYear = modelYear;
        this.length = length;
        this.width = width;
        this.assignedSlot = -1;
    }
    //SETTERS AND GETTERS FOR attributes
    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int getModelYear() {
        return modelYear;
    }

    @Override
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    
    @Override
    public float getLength() {
        return length;
    }

    @Override
    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }
    
    @Override
    public int getAssignedSlot() {
        return assignedSlot;
    }

    @Override
    public void setAssignedSlot(int assignedSlot) {
        this.assignedSlot = assignedSlot;
    }

    @Override
    public void setArrivalTime(float arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public float getArrivalTime() {
        return arrivalTime;
    }
}