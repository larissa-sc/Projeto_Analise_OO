package br.com.ifpe.supermercado.interfaces;

import br.com.ifpe.supermercado.entidades.classesabstratas.EntidadeBase;
import java.util.List;

public interface IGenericControlador<Tipo extends EntidadeBase> {

    void criar(Tipo objeto);

    Tipo ler(Tipo objeto);

    void atualizar(Tipo objeto);

    void deletar(Tipo objeto);

    List<Tipo> listar();
}
