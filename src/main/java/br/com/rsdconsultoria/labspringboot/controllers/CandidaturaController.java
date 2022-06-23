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
package br.com.rsdconsultoria.labspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.labspringboot.core.valueObjects.Mensagem;
import br.com.rsdconsultoria.labspringboot.repositories.CandidatoRepository;
import br.com.rsdconsultoria.labspringboot.viewModels.CandidatoVM;

@RestController
public class CandidaturaController {
    @Autowired
    private CandidatoRepository candidatoRepository;

    @PutMapping("/${br.com.rsdconsultoria.api.version}/candidatura")
    public Mensagem<CandidatoVM> incluir(@RequestBody CandidatoVM novoCandidato) {
        var msg = new Mensagem<CandidatoVM>();
        msg.setDescricao("Ocorreu uma falha ao cadastrar o candidato. Tente novamente ou entre em contato com o suporte da aplicação");

        if (candidatoRepository.findOne(Example.of(new CandidatoVM().setCpf(novoCandidato.getCpf()))).isPresent()) {
            msg.setDescricao("Candidato já cadastrado").setSucesso(false);
            return msg;
        }

        if (this.candidatoRepository.save(novoCandidato) != null) {
            msg.setSucesso(true).setDescricao("Candidato cadastrado com sucesso");
        }
        return msg;
    }

    @GetMapping("/${br.com.rsdconsultoria.api.version}/candidatura")
    public Object listar() {
        return candidatoRepository.findAll();
    }
}
