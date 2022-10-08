package org.olaoye.com.storeServicesImpl;


import org.olaoye.com.domian.Staff;
import org.olaoye.com.domian.Store;
import org.olaoye.com.domian.enums.POSITION;
import org.olaoye.com.storeServicesImpl.storeService.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    @Override
    public String hireACashier(Staff manager, Staff cashier) {
        if(manager.getPosition() == POSITION.MANAGER){
            var cashierList = Store.getCashiers();
            cashierList.add(cashier);
            return "Congrats "+cashier.getName()+" you are welcome to our store";
        } else {
            return "oops!!, Only managers are allowed to hire";
        }

    }
}

