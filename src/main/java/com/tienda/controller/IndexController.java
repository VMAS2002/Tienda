package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Estamos usando una arquitectura mvc");

        Cliente cliente = new Cliente("Pedro", "Gomez Contreras", "pgomez@gmail.com", "5555-7878");
        //Cliente cliente2=new Cliente ("Rebeca", "Arguedas Molina", "rarguedas@gmail.com", "7855-5578");

        //var clientes=Arrays.asList(cliente1, cliente2);
        var clientes = clienteDao.findAll();
                
        model.addAttribute("cliente", cliente);

        model.addAttribute("clientes", clientes);

        return "index";
        //commit
    }

}
