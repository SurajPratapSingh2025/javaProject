package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.BookingForm;
import com.app.model.ContactForm;
import com.app.service.BookingFormService;
import com.app.service.ContactFormService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {
	
	
	private ContactFormService contactFormService;
	private BookingFormService bookingFormService;
	
	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@GetMapping(path= {"/","home","welcome","index"})
	public String welcomeView(HttpServletRequest req,Model m) {
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		m.addAttribute("bookingForm",new BookingForm());
		return "index";
	}

	@GetMapping("about")
	public String aboutView(HttpServletRequest req,Model m) {
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		return "about";
	}

	@GetMapping("cars")
	public String carsView(HttpServletRequest req,Model m) {
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		return "cars";
	}
	
	@GetMapping("services")
	public String servicesView(HttpServletRequest req,Model m) {
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		return "services";
	}
	
	@GetMapping("contacts")
	public String contactsView(HttpServletRequest req,Model m) {
		String requestURI=req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		m.addAttribute("contactForm",new ContactForm());
		return "contacts";
	}
	
	@PostMapping("contactform")
	public String contactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult",bindingResult);
			return "contacts";
		}
//		System.out.println(contactForm);
		ContactForm saveContactFormService = contactFormService.saveContactFormService(contactForm);
		if(saveContactFormService != null) {
			redirectAttributes.addFlashAttribute("message","Message Sent Successfully");
		}else {
			redirectAttributes.addFlashAttribute("message","Something went Wrong");
		}
		return "redirect:/contacts";
	}

	@PostMapping("bookingform")
	public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm, BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult",bindingResult);
			return "index";
		}else if(bookingForm.getAdult()+bookingForm.getChildren()>4) {
			m.addAttribute("message","The total no. of adult & children can't exceed 4.");
			return "index";
		}
//		System.out.println(bookingForm);
		BookingForm saveBookingFormService = bookingFormService.saveBookingFormService(bookingForm);
		if(saveBookingFormService != null) {
			redirectAttributes.addFlashAttribute("message","Booking Successfully");
		}else {
			redirectAttributes.addFlashAttribute("message","Something went Wrong");
		}
		return "redirect:/index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
