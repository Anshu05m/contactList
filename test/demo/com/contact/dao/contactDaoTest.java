package demo.com.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import demo.com.contact.model.Contact;

class contactDaoTest {
	
	private DriverManagerDataSource dataSource;
	private contactDao dao;
	
	
	@BeforeEach
	void setupBeforeEach()
	{
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb?autoReconnect=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new contactImpl(dataSource);
		
	}

	@Test
	void testSave() {
		
		
		Contact contact = new Contact("P V Sindhu","sindhu@badmontion.com","Tamil","12223456");
		int result = dao.save(contact);
		assertTrue(result > 0);
		
	}
	
	@Test
	void testUpdate() {
		Contact contact = new Contact(1,"P V Sindhu","pv.sindhu@badmontion.com","Tamil","12223456");
		int result = dao.update(contact);
		assertTrue(result > 0);
	}
	
	@Test
	void testGet() {
	
		Integer id = 1;
		Contact contact = dao.get(id);
		
		if(contact != null)
		{
			System.out.println(contact);
		}
		assertNotNull(contact);
	}
	
	@Test
	void testDelete() {
		Integer id = 1 ;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}
	
	@Test
	void testList() {
		List<Contact> listContacts = dao.list();
		
		for(Contact aContact :listContacts)
		{
			System.out.println(aContact);
		}
		
		assertTrue(!listContacts.isEmpty());
		
	}

}
