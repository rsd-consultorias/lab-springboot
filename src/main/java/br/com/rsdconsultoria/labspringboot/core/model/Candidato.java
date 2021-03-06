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
package br.com.rsdconsultoria.labspringboot.core.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Candidato {
    private UUID id;
    private long candidatoId;
    private String nome;
    private String cpf;
    private OffsetDateTime dataNascimento;

    public UUID getId() {
        return id;
    }

    public Candidato setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Candidato setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public OffsetDateTime getDataNascimento() {
        return dataNascimento;
    }

    public Candidato setDataNascimento(OffsetDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Candidato setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public long getCandidatoId() {
        return candidatoId;
    }

    public Candidato setCandidatoId(long candidatoId) {
        this.candidatoId = candidatoId;
        return this;
    }
}
