package TDD;

public class ValidadorDeContrasenia {

    public String contrasenia;

    public ValidadorDeContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String evaluarFortaleza() {
        if(this.contrasenia.length() >= 8) {
            int cantidadDeNumeros = getCantidadDeNumeros();
            if(cantidadDeNumeros >= 4 && esUnoDeLosCaracteresUnaÑO$() ) {
                return "fuerte";
            }
            if(cantidadDeNumeros >= 4 || esUnoDeLosCaracteresUnaÑO$()) {
                return "mediana";
            }
            return "debil";
        }
        return "invalido";
    }

    private int getCantidadDeNumeros() {
        int cantidadDeNumeros = 0;
        for(int i = 0; i < this.contrasenia.length(); i++){
            if(Character.isDigit(this.contrasenia.charAt(i))){
                cantidadDeNumeros++;
            }
        }
        return cantidadDeNumeros;
    }

    private Boolean esUnoDeLosCaracteresUnaÑO$() {
        for(int i = 0; i < this.contrasenia.length(); i++) {
            if (this.contrasenia.charAt(i) == 'ñ' || this.contrasenia.charAt(i) == 'Ñ' ||
                    this.contrasenia.charAt(i) == '$') {
                return true;
            }
        }
        return false;
    }
}
