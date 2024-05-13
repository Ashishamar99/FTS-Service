package com.hcltech.fts;

import com.hcltech.fts.dao.CustomerRepository;
import com.hcltech.fts.model.Customer;
import com.hcltech.fts.service.FTSService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class FtsApplicationTests {
	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	FTSService ftsService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetCustomerFromId(){
		Customer customer = new Customer();
		customer.setCustomerId("1");
		when(customerRepository.findById(Mockito.anyString())).thenReturn(Optional.of(customer));
		Customer res = ftsService.getCustomerFromId("1");
		assertEquals(res.getCustomerId(), "1");
	}

	@Test
	void testGetCustomerFromId_CustomerNotFound() {
		String customerId = "2";
		when(customerRepository.findById(customerId)).thenReturn(Optional.empty());
		ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
			ftsService.getCustomerFromId(customerId);
		});
		assertEquals("Customer Not Found With Id:: " + customerId, exception.getReason());
	}

	@Test
	void testSaveCustomer(){
		Customer customerToSave = new Customer();
		customerToSave.setCustomerId("123");
		when(customerRepository.save(customerToSave)).thenReturn(customerToSave);
		Customer res = ftsService.addCustomer(customerToSave);
		assertEquals(res.getCustomerId(), "123");
	}
}
