package br.com.rsdconsultoria.labspringboot;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

public class UsuarioLogadoGenerator implements ValueGenerator<String> {
    @Override
    public String generateValue(Session session, Object owner) {
        return UsuarioLogado.get();
    }
}