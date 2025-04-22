package com.tallerwebi.presentacion.entrenamiento2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactoController {

    @PostMapping(path = "/contacto")
    public ModelAndView registrarContacto(ContactoDto contacto) {
        ModelMap model = new ModelMap();

        model.put("mensaje", "Contacto registrado con exito");
        model.put("contactoDto", new ContactoDto(contacto.getNombre(), contacto.getEmail(), contacto.getMensajeContacto()));
        return new ModelAndView("contacto", model);
    }

}
