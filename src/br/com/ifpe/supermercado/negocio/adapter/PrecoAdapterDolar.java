package br.com.ifpe.supermercado.negocio.adapter;

import br.com.ifpe.supermercado.interfaces.IPrecoAdapter;

public class PrecoAdapterDolar implements IPrecoAdapter {
    private static final double TAXA_CAMBIO = 5.49;

    @Override
    public double getPrecoEmDolar(double precoEmReais) {
        return precoEmReais / TAXA_CAMBIO;
    }
}
