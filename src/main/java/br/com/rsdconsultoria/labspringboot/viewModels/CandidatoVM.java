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
package br.com.rsdconsultoria.labspringboot.viewModels;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CandidatoVM extends AuditoriaDadosBase implements Serializable {

    private static final long serialVersionUID = -45534202839071120L;

    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    @Column(length = 16)
    private long candidatoId;

    @Column(length = 120)
    private String nome;

    @Column(length = 11, unique = true)
    private String cpf;

    private Date dataNascimento;

    public UUID getId() {
        return this.id;
    }

    public CandidatoVM setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CandidatoVM setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public CandidatoVM setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public CandidatoVM setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public long getCandidatoId() {
        return candidatoId;
    }

    public CandidatoVM setCandidatoId(long candidatoId) {
        this.candidatoId = candidatoId;
        return this;
    }
}
