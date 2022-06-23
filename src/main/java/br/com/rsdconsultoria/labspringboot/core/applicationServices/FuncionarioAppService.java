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
package br.com.rsdconsultoria.labspringboot.core.applicationServices;

import br.com.rsdconsultoria.labspringboot.core.builders.FuncionarioBuilder;
import br.com.rsdconsultoria.labspringboot.core.domainServices.FuncionarioDomainService;
import br.com.rsdconsultoria.labspringboot.core.interfaces.IAntecedentesCriminaisService;
import br.com.rsdconsultoria.labspringboot.core.interfaces.ICandidatoRepository;
import br.com.rsdconsultoria.labspringboot.core.interfaces.IFuncionarioRepository;
import br.com.rsdconsultoria.labspringboot.core.model.Candidato;
import br.com.rsdconsultoria.labspringboot.core.model.Funcionario;
import br.com.rsdconsultoria.labspringboot.core.valueObjects.Mensagem;

public class FuncionarioAppService {
    private IFuncionarioRepository funcionarioRepository;
    private ICandidatoRepository candidatoRepository;

    private FuncionarioDomainService funcionarioDomainService;

    public FuncionarioAppService(IFuncionarioRepository funcionarioRepository, ICandidatoRepository candidatoRepository,
            IAntecedentesCriminaisService antecedentesCriminaisService) {
        this.candidatoRepository = candidatoRepository;
        this.funcionarioRepository = funcionarioRepository;
        funcionarioDomainService = new FuncionarioDomainService(antecedentesCriminaisService);
    }

    public Mensagem<Funcionario> admitirFuncionario(Candidato candidato) {
        var mensagem = new Mensagem<Funcionario>();
        var funcionario = FuncionarioBuilder.fromCandidato(candidato);
        var antecedentesCriminais = this.funcionarioDomainService.verificarAntecedentesCriminais(candidato.getCpf(),
                candidato.getDataNascimento());

        if (antecedentesCriminais.isPresent()) {
            mensagem.setTitulo("Admissão de Funcionário").setDescricao("Candidato com antecendentes criminais")
                    .setSucesso(false);

            return mensagem;
        }

        var novoFuncionario = funcionarioRepository.incluirFuncionario(funcionario);

        candidatoRepository.baixarCandidato(candidato.getCandidatoId());
        mensagem.setObjeto(novoFuncionario).setSucesso(true).setTitulo("Admissão de Funcionário")
                .setDescricao("Candidato admitido com sucesso");

        return mensagem;
    }
}