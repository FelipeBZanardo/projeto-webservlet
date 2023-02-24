package persistence;

import model.Despesa;

import java.io.IOException;
import java.util.List;

public interface Repository {
    void salvarDespesa(Despesa despesa) throws IOException;
    Despesa buscarDespesa(long id);
    List<Despesa> buscarDespesas();
    void deletarDespesa(long id) throws IOException;

}
