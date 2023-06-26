interface IAdminController{
        public void shutdown(IGarageController garageController);
    
        public Boolean setupGarage(int nSlot, int configType, Slot[] s, IGarageController garageController);
    
        public void calcTotalRevenue(IGarageController garageController);
    
        public void calcTotalRegistered(IGarageController garageController);
    
        public boolean isAuthorized();
    
        public void adminLogout();
    
        public boolean authorize(String pw, IGarageController garageController);
    
    }