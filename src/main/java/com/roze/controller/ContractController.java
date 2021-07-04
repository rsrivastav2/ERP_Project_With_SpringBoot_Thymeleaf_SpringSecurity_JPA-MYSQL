package com.roze.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roze.domain.Contract;
import com.roze.repository.ContractRepository;
import com.roze.repository.CustomerRepository;
import com.roze.repository.ThirdPartyRepository;



@Controller
@RequestMapping("/contracts")
public class ContractController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String getContractList(Model model){
        model.addAttribute("contracts", contractRepository.findAll());
        return "contracts/contractList";
    }

    //@PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    @GetMapping("/new")
    public String getNewContract(Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("thirdParties", thirdPartyRepository.findAll());
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("contracts", contractRepository.findAll());
        return "contracts/createContract";
    }

    @PostMapping("/new")
    public String postNewContract(@ModelAttribute @Valid Contract contract, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "contracts/createContract";
        }
        contractRepository.save(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/{id}")
    public String showContractList(@PathVariable Long id, Model model){
        model.addAttribute("contract", contractRepository.findById(id).get());
        return "contracts/showContract";
    }

    @GetMapping("/{id}/update")
    public String getUpdateContract(@PathVariable Long id, Model model){
        model.addAttribute("contract", contractRepository.findById(id).get());
        return "supplier/updateContract";
    }

    @PostMapping("/{id}/update")
    public String postUpdateContract(@ModelAttribute Contract contract){
        contractRepository.save(contract);
        return "redirect:/contracts";
    }

    @PostMapping("/{id}/delete")
    public String deleteContract(@PathVariable Long id){
        Optional<Contract> contractOptional = contractRepository.findById(id);
        if(!contractOptional.isPresent()){
            log.warn("Contract with id: {} is not present", id);
        }
        else {
            Contract contract = contractOptional.get();
            contractRepository.delete(contract);
        }
        return "redirect:/contracts";
    }
}
