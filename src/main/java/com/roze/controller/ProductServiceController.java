package com.roze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roze.domain.ProductService;
import com.roze.enumeration.PurchaseStatus;
import com.roze.enumeration.SaleStatus;
import com.roze.repository.ProductServiceRepository;
import com.roze.repository.TagRepository;

@Controller
@RequestMapping("/services")
public class ProductServiceController {

    @Autowired
    private ProductServiceRepository serviceRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String getServiceList(Model model, @RequestParam(value = "sale_status", required = false) SaleStatus saleStatus){

        if(saleStatus == null){
            model.addAttribute("services", serviceRepository.findAll());
        }

        else {
            model.addAttribute("services", serviceRepository.findBySaleStatus(saleStatus));
        }

        model.addAttribute("notSaleAndNotPurchaseCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.NOT_FOR_SALE, PurchaseStatus.NOT_FOR_PURCHASE));
        model.addAttribute("forSaleCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.FOR_SALE, PurchaseStatus.NOT_FOR_PURCHASE));
        model.addAttribute("forPurchaseCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.NOT_FOR_SALE, PurchaseStatus.FOR_PURCHASE));
        model.addAttribute("forSaleAndForPurchaseCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.FOR_SALE, PurchaseStatus.FOR_PURCHASE));
        return "services/serviceList";
    }

    @GetMapping("/new")
    public String getNewService(Model model){
        model.addAttribute("service", new ProductService());
        model.addAttribute("tags", tagRepository.findAll());
        return "services/newService";
    }

    @PostMapping("/new")
    public String postNewTag(@ModelAttribute ProductService service){
        serviceRepository.save(service);
        return "redirect:/services";
    }

    @GetMapping("/{id}")
    public String getShowTag(@PathVariable Long id, Model model){
        model.addAttribute("service",serviceRepository.findById(id).get());
        return "services/showService";
    }

    @GetMapping("/{id}/update")
    public String getUpdateTag(@PathVariable Long id, Model model){
        model.addAttribute("service", serviceRepository.findById(id).get());
        return "service/updateService";
    }

    @PostMapping("/{id}/update")
    public String postUpdateTag(@ModelAttribute ProductService service){
        serviceRepository.save(service);
        return "redirect:/services";
    }
}
