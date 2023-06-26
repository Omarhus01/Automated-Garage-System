interface IGarage {
    public boolean setConfig(int config);
    public void addSlot(float len, float wid);
    //getters and setters for attributes
    public int getNumSlots();
    public int getOccupiedSlots();
    public Slot[] getSlots();
    public ISlotAssigner getConfig();
    public void setNumSlots(int n);
    public void setUpGarage(int n,int c ,Slot [] s);
    public void setTotalRevenue(int r);
    public void setTotalVehicles(int v);
    public int getTotalRevenue();
    public int getTotalVehicles();
}