package tests;

import com.tngtech.java.junit.dataprovider.UseDataProvider;
import model.Customer;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class ProductsInCartTests extends TestBase {

    @Test
    @UseDataProvider(value = "validCustomers", location = DataProviders.class)
    public void canRegisterCustomer(Customer customer) {

    }
}
