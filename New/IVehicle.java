interface IVehicle{
    //SETTERS AND GETTERS FOR attributes
    public String getModelName();
    public void setModelName(String modelName);
    public String getID();
    public void setID(String ID);
    public int getModelYear();
    public void setModelYear(int modelYear);
    public float getLength();
    public void setLength(float length);
    public float getWidth();
    public void setWidth(float width);
    public int getAssignedSlot();
    public void setAssignedSlot(int assignedSlot);
    public void setArrivalTime(float arrivalTime);
    public float getArrivalTime();
}