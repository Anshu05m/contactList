package demo.com.contact.dao;
import java.util.List;

import demo.com.contact.model.Contact;

public interface contactDao {
	
	public int save(Contact contact);
	
	public int update(Contact contact);
	
	public Contact get(Integer id);
	
	public int delete(Integer id);
	
	public List<Contact> list();

}
