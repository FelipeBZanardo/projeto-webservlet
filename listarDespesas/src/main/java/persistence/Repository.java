package persistence;

import model.Despesa;

import java.util.List;

public interface Repository {
    void salvarDespesa(Despesa despesa);
    Despesa buscarDespesa(long id);
    List<Despesa> buscarDespesas();
    void deletarDespesa(long id);

}
