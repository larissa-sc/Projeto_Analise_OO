package br.com.ifpe.supermercado.negocio.factory;

import br.com.ifpe.supermercado.entidades.classesabstratas.EntidadeBase;
import br.com.ifpe.supermercado.persistencia.GenericDAO;

public class DAOFactory {
    // uso da factory para criar uma família apenenas com os DAO's
    public static <Tipo extends EntidadeBase> GenericDAO<Tipo> criarDAO(){
        return new GenericDAO<>();
    }
}