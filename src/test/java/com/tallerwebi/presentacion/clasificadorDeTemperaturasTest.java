package com.tallerwebi.presentacion;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class clasificadorDeTemperaturasTest {

    @Test
    public void deberiaDevolverCongelanteSiEsMenorOIgualACero(){
        Temperatura temperatura = new Temperatura(-1);
        ClasificadorTemperatura clasificador = new ClasificadorTemperatura();

        ModelAndView modelAndView = clasificador.clasificarTemperatura(temperatura);

        String vistaEsperada = "clasificar-temperatura";
        String mensajeEsperado = "Congelante";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));
    }

    @Test
    public void deberiaDevolverFriaSiEsMayorACeroYMenorOIgualAQuince(){
        Temperatura temperatura = new Temperatura(12);
        ClasificadorTemperatura clasificador = new ClasificadorTemperatura();

        ModelAndView modelAndView = clasificador.clasificarTemperatura(temperatura);

        String vistaEsperada = "clasificar-temperatura";
        String mensajeEsperado = "Fria";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));
    }

    @Test
    public void deberiaDevolverTempladaSiEsMayorAQuinceYMenorOIgualAVeinticinco(){
        Temperatura temperatura = new Temperatura(20);
        ClasificadorTemperatura clasificador = new ClasificadorTemperatura();

        ModelAndView modelAndView = clasificador.clasificarTemperatura(temperatura);

        String vistaEsperada = "clasificar-temperatura";
        String mensajeEsperado = "Templada";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));
    }

    @Test
    public void deberiaDevolverCalurosaSiEsMayorAVeinticincoYMenorOIgualATreinticinco(){
        Temperatura temperatura = new Temperatura(28);
        ClasificadorTemperatura clasificador = new ClasificadorTemperatura();

        ModelAndView modelAndView = clasificador.clasificarTemperatura(temperatura);

        String vistaEsperada = "clasificar-temperatura";
        String mensajeEsperado = "Calurosa";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));
    }

    @Test
    public void deberiaDevolverPeligrosaSiEsMayorATreinticinco(){
        Temperatura temperatura = new Temperatura(42);
        ClasificadorTemperatura clasificador = new ClasificadorTemperatura();

        ModelAndView modelAndView = clasificador.clasificarTemperatura(temperatura);

        String vistaEsperada = "clasificar-temperatura";
        String mensajeEsperado = "Peligrosa";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));
    }
}
