package br.com.rsdconsultoria.labspringboot;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class UsuarioLogadoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            UsuarioLogado.logIn(httpServletRequest.getHeader("usuario"));
            filterChain.doFilter(request, response);
        } finally {
            UsuarioLogado.logOut();
        }
    }
}
