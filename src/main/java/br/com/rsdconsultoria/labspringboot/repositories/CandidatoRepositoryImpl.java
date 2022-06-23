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
package br.com.rsdconsultoria.labspringboot.repositories;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import br.com.rsdconsultoria.labspringboot.core.interfaces.ICandidatoRepository;
import br.com.rsdconsultoria.labspringboot.viewModels.CandidatoVM;

public class CandidatoRepositoryImpl implements ICandidatoRepository {
    @Autowired
    @Lazy
    private CandidatoRepository candidatoRepository;

    @Override
    public void baixarCandidato(long id) {
        var candidato = candidatoRepository.findAll(Example.of(new CandidatoVM().setCandidatoId(id)));
        if (candidato.size() > 0) {
            candidato.get(0).setNome("CONTRATADO");
            candidatoRepository.save(candidato.get(0));
            candidatoRepository.flush();
        }
    }
}