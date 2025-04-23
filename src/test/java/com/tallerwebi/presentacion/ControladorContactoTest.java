package com.tallerwebi.presentacion;

import com.tallerwebi.presentacion.entrenamiento2.ContactoDto;
import com.tallerwebi.presentacion.entrenamiento2.ContactoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ControladorContactoTest {

    public ContactoController contactoController;

    @BeforeEach
    public void init(){
        contactoController = new ContactoController();
    }

    @Test
    public void dadoQueExisteUnControladorDeContactoDeberiaPoderCrearUnNuevoContacto() {
        ContactoDto contacto = new ContactoDto("Carla", "car@gmail.com", "Este es el contacto de prueba");

        ModelAndView modelAndView = contactoController.registrarContacto(contacto);

        assertThat(modelAndView.getViewName(), equalTo("confirmacion"));
        assertThat(modelAndView.getModel().get("mensaje"), equalTo("Contacto registrado con exito"));
//        assertThat(modelAndView.getModel().get("contactoDto"), equalTo(contacto));
    }

    @Test
    public void dadoQueExisteUnControladorDeContactoDeberiaPoderMostrar() {
        ContactoDto contacto = new ContactoDto("Carla", "car@gmail.com", "Este es el contacto de prueba");

        ModelAndView modelAndView = contactoController.mostrarVistaFormulario();

        assertThat(modelAndView.getViewName(), equalTo("contacto"));
    }
}
