package hr.bonbon.musikalija;

/**
 * Created by die on 3/30/17.
 */

public class QaA {

    private String videocode;
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String solucion;

    public QaA (String videocode, String pregunta, String respuesta1,String respuesta2,String respuesta3,String solucion){
        this.videocode=videocode;
        this.pregunta=pregunta;
        this.respuesta1=respuesta1;
        this.respuesta2=respuesta2;
        this.respuesta3=respuesta3;
        this.solucion=solucion;
    }

    public String getVideocode() {
        return videocode;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public String getSolucion() {
        return solucion;
    }

    ;
}
