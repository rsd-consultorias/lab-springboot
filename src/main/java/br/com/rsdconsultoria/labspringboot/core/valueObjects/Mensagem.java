/*MIT License

Copyright (c) 2022 Rafael Dias

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/
package br.com.rsdconsultoria.labspringboot.core.valueObjects;

public final class Mensagem<T> {
    private Boolean sucesso;
    private String titulo;
    private String descricao;
    private T objeto;

    public T getObjeto() {
        return objeto;
    }

    public Mensagem<T> setObjeto(T objeto) {
        this.objeto = objeto;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Mensagem<T> setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Mensagem<T> setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public Mensagem<T> setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
        return this;
    }
}
