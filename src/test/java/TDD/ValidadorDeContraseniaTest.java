package TDD;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ValidadorDeContraseniaTest {

    @Test
    public void deveriaDevolverInvalidoCuandoLaContraseniaTieneUnSoloCaracter() {
        ValidadorDeContrasenia validador = new ValidadorDeContrasenia("1");
        String fortaleza = validador.evaluarFortaleza();

        assertThat(fortaleza, equalToIgnoringCase("invalido"));
    }

    @Test
    public void deberiaDevolverDebilCuandoLaContraseniaTiene8Caracteres() {
        ValidadorDeContrasenia validador = new ValidadorDeContrasenia("damian12");
        String fortaleza = validador.evaluarFortaleza();

        assertThat(fortaleza, equalToIgnoringCase("debil"));
    }

    @Test
    public void deberiaDevolverMedianaCuandoLaContraseniaEsDam33n12(){
        ValidadorDeContrasenia validador = new ValidadorDeContrasenia("dam33n12");
        String fortaleza = validador.evaluarFortaleza();

        assertThat(fortaleza, equalToIgnoringCase("mediana"));

    }

    @Test
    public void deberiaDevolverDebilCuandoLaContraseniaEsDami3n12(){
        ValidadorDeContrasenia validador = new ValidadorDeContrasenia("dami3n12");
        String fortaleza = validador.evaluarFortaleza();

        assertThat(fortaleza, equalToIgnoringCase("debil"));

    }

    @Test
    public void deberiaDevolverFuerteCuandoLaContraseniaEsDam13ñ12(){
        ValidadorDeContrasenia validador = new ValidadorDeContrasenia("Dam13ñ12");
        String fortaleza = validador.evaluarFortaleza();

        assertThat(fortaleza, equalToIgnoringCase("fuerte"));

    }
    @Test
    public void deberiaDevolverMedianaCuandoLaContraseniaEsDaam3ñ12(){
        ValidadorDeContrasenia validador = new ValidadorDeContrasenia("Daam3ñ12");
        String fortaleza = validador.evaluarFortaleza();

        assertThat(fortaleza, equalToIgnoringCase("mediana"));

    }
}
