package services.Impl;

import Entity.Customer;
import repository.impl.CustomerImpl;
import repository.inter.CustomerInter;
import services.Inter.CustomerServicesInter;

public class CustomerServicesImpl implements CustomerServicesInter {
    private CustomerInter customerInter = new CustomerImpl();
    @Override
    public void registration(Customer customer) {
        customerInter.insert(customer);
    }

}
