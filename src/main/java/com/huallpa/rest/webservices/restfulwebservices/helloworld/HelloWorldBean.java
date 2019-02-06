package com.huallpa.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    public String mensaje;

    public HelloWorldBean(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
