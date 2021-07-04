package com.roze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roze.domain.Customer;
import com.roze.repository.CustomerRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String getCustomerList(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/customerList";
    }

    @GetMapping("/new")
    public String getNewCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customers/createCustomer";
    }

    @PostMapping("/new")
    public String postNewCustomer(@ModelAttribute Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}")
    public String showCustomerList(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerRepository.findById(id).get());
        return "customer/showCustomer";
    }

    @GetMapping("/{id}/update")
    public String getUpdateCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerRepository.findById(id).get());
        return "customers/updateCustomer";
    }

    @PostMapping("/{id}/update")
    public String postUpdateMusteri(@ModelAttribute Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }
}
