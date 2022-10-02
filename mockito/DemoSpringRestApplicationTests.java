package com.infy;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.CustomerDTO;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerRepository;
import com.infy.service.CustomerService;
import com.infy.service.CustomerServiceImpl;

@SpringBootTest
class DemoSpringRestApplicationTests {
@Mock
CustomerRepository customerRepository;

@InjectMocks
CustomerService customerService=new CustomerServiceImpl();

	@Test
	public void getCustomerTest() throws InfyBankException {
		Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setName("Ram");
		customer.setEmailId("ram@gmail.com");
		customer.setDateOfBirth(LocalDate.now());
		Optional<Customer> optional=Optional.of(customer);
		Mockito.when(customerRepository.findById(1)).thenReturn(optional);
		
		 CustomerDTO customerDTO=customerService.getCustomer(1);
		 Assertions.assertEquals(customerDTO.getName(), customer.getName());
		
	
	}
	
	
	@Test
	public void getCustomerTestCustomerNotFound() throws InfyBankException {
		Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setName("Ram");
		customer.setEmailId("ram@gmail.com");
		customer.setDateOfBirth(LocalDate.now());
		Optional<Customer> optional=Optional.of(customer);
		Mockito.when(customerRepository.findById(1)).thenReturn(optional);
		InfyBankException exception=Assertions.assertThrows(InfyBankException.class,()->customerService.getCustomer(2));
		Assertions.assertEquals("Service.CUSTOMER_NOT_FOUND", exception.getMessage());
		
		
	}
	
	 
	 @Test
	 public void addCustomerTest() throws
	InfyBankException 
	 {
		 Customer customer=new Customer();
			customer.setCustomerId(1);
			customer.setName("Ram");
			customer.setEmailId("ram@gmail.com");
			customer.setDateOfBirth(LocalDate.now());
			Mockito.when(customerRepository.save(any())).thenReturn(customer);
			 CustomerDTO customerDTO=new CustomerDTO();
				customerDTO.setCustomerId(1);
				customerDTO.setName("Ram");
				customerDTO.setEmailId("ram@gmail.com");
				customerDTO.setDateOfBirth(LocalDate.now());
	            int id=customerService.addCustomer(customerDTO);
	           Assertions.assertEquals(1,id);
	 }
	
	
	
	       @Test
		   public void getAllCustomers() throws InfyBankException
		 { 
	    	  
	    	   ArrayList<Customer> customerList=new ArrayList<>(); 
		       Customer cust1=new Customer();
		       cust1.setCustomerId(1);
		       cust1.setName("Ravi");
		       cust1.setEmailId("ravi@gmail.com");
		       cust1.setDateOfBirth(LocalDate.of(2010, 12, 1));
		       Customer cust2=new Customer();
		       cust2.setCustomerId(2);
		       cust2.setName("Geeta");
		       cust2.setEmailId("geeta@gmail.com");
		       cust2.setDateOfBirth(LocalDate.of(2011, 12, 12));
		       customerList.add(cust1);
		       customerList.add(cust2);
		       Mockito.when(customerRepository.findAll()).thenReturn(customerList);
		       List<CustomerDTO> customerDTOs=customerService.getAllCustomers();
	    	   Assertions.assertEquals(customerDTOs.get(0).getCustomerId(),customerList.get(0).getCustomerId());
		 }
	       
	       @Test
		   public void getAllCustomersNoData() throws InfyBankException
		   {
	    	   ArrayList<Customer> customerList=new ArrayList<>(); 
	    	   Mockito.when(customerRepository.findAll()).thenReturn(customerList);
	    	   InfyBankException exception=Assertions.assertThrows(InfyBankException.class,()->customerService.getAllCustomers());
	    		Assertions.assertEquals("Service.CUSTOMERS_NOT_FOUND", exception.getMessage());
	    		
		   }
	 
	       @Test
		   public void updateTestRecordNotFound() throws InfyBankException
		   {
	    	   
	    	    Customer customer=new Customer();
				customer.setCustomerId(1);
				customer.setName("Ram");
				customer.setEmailId("ram@gmail.com");
				customer.setDateOfBirth(LocalDate.now());
				Mockito.when(customerRepository.save(any())).thenReturn(customer);
				InfyBankException exception=Assertions.assertThrows(InfyBankException.class,()->customerService.updateCustomer(2, "sita@gmail.com"));
	    	      	   
				Assertions.assertEquals("Service.CUSTOMER_NOT_FOUND", exception.getMessage());
				
		
		   }
	 
    @Test
public void deleteTestRecordNotFound() throws InfyBankException
{
	   
	    Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setName("Ram");
		customer.setEmailId("ram@gmail.com");
		customer.setDateOfBirth(LocalDate.now());
		Mockito.when(customerRepository.save(any())).thenReturn(customer);
		InfyBankException exception=Assertions.assertThrows(InfyBankException.class,()->customerService.deleteCustomer(2));
	      	   
		Assertions.assertEquals("Service.CUSTOMER_NOT_FOUND", exception.getMessage());
		

}
}
	
		

