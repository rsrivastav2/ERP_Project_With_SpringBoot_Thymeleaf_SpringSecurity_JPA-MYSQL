package com.roze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roze.domain.Supplier;
import com.roze.repository.SupplierRepository;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

        @Autowired
        private SupplierRepository supplierRepository;

        @GetMapping("")
        public String getSupplierList(Model model){
            model.addAttribute("suppliers", supplierRepository.findAll());
            return "suppliers/supplierList";
        }

        @GetMapping("/new")
        public String getNewSupplier(Model model){
            model.addAttribute("supplier", new Supplier());
            return "suppliers/createSupplier";
        }

        @PostMapping("/new")
        public String postNewSupplier(@ModelAttribute Supplier supplier){
            supplierRepository.save(supplier);
            return "redirect:/suppliers";
        }

        @GetMapping("/{id}")
        public String showSupplierList(@PathVariable Long id, Model model){
            model.addAttribute("supplier", supplierRepository.findById(id).get());
            return "suppliers/showSupplier";
        }

        @GetMapping("/{id}/update")
        public String getUpdateSupplier(@PathVariable Long id, Model model){
            model.addAttribute("supplier", supplierRepository.findById(id).get());
            return "suppliers/updateSupplier";
        }

        @PostMapping("/{id}/update")
        public String postUpdateSupplier(@ModelAttribute Supplier supplier){
            supplierRepository.save(supplier);
            return "redirect:/suppliers";
        }
}
