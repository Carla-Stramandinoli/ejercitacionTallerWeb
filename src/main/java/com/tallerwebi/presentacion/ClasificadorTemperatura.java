package com.tallerwebi.presentacion;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class ClasificadorTemperatura {
    public ModelAndView clasificarTemperatura(Temperatura temperatura) {
        ModelMap modelMap = new ModelMap();
        String mensajeEsperado = "Temperatura invalida";

        if (temperatura.getGrados() <= 0) {
            mensajeEsperado = "Congelante";
        }
        if(temperatura.getGrados() > 0 && temperatura.getGrados() <= 15) {
            mensajeEsperado = "Fria";
        }
        if(temperatura.getGrados() > 15 && temperatura.getGrados() <= 25) {
            mensajeEsperado = "Templada";
        }
        if(temperatura.getGrados() > 25 && temperatura.getGrados() <= 35) {
            mensajeEsperado = "Calurosa";
        }
        if(temperatura.getGrados() > 35) {
            mensajeEsperado = "Peligrosa";
        }

        modelMap.put("mensaje", mensajeEsperado);
        modelMap.put("temperatura", temperatura);

        return new ModelAndView("clasificar-temperatura", modelMap);
    }
}
