interface IGarageController{
    public void addGarageSlot(float l, float w);
    public Boolean isFull();
    public Boolean addVehicle(String name, String id, int year, float len, float wid);
    public Vehicle getVehicle(String id);
    public IGarage getGarage();
    public IGarageController getGarageController();
    public IAdminController getAdminController();
    public IParkinController getParkinController();
    public IParkoutController getParkoutController();
    public String getVehicleInLine();
    public GarageUI getUI();
    public void ShowSlot();
}