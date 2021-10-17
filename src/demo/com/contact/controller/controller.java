package demo.com.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.com.contact.dao.contactDao;
import demo.com.contact.model.Contact;

@RequestMapping("/")
@Controller
public class controller {
	
	
	@Autowired
	private contactDao ContactDao;
	
	
	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView model)
	{
		List<Contact> listContact = ContactDao.list();
		model.addObject("listContact",listContact);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    Contact newContact = new Contact();
	    model.addObject("contact", newContact);
	    model.setViewName("contactForm");
	    return model;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact)
	{
		if(contact.getId() == null)
		{
			ContactDao.save(contact);
		}
		else
		{
			ContactDao.update(contact);
		}
		ContactDao.save(contact);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/Edit", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    Contact contact = ContactDao.get(contactId);
	    ModelAndView model = new ModelAndView("contactForm");
	    model.addObject("contact", contact);
	 
	    return model;
	}
	
	@RequestMapping(value = "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    ContactDao.delete(contactId);
	    return new ModelAndView("redirect:/");
	}
	
				
}
