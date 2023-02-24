package persistence;
import model.Despesa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DespesaRepository implements Repository, Serializable {

    private final Map<Long, Despesa> despesas;
    public static DespesaRepository despesaRepository = getInstance();

    private DespesaRepository() {
        this.despesas = new HashMap<>();
    }

    private static DespesaRepository getInstance(){
        return new DespesaRepository();
    }

    public long getUtimoId(){
        return despesas
                .keySet()
                .stream()
                .max(Long::compareTo)
                .orElseGet(() -> 0L);
    }

    @Override
    public void salvarDespesa(Despesa despesa) {
        despesas.put(despesa.getId(), despesa);
    }

    @Override
    public Despesa buscarDespesa(long id) {
        return despesas.get(id);
    }

    @Override
    public List<Despesa> buscarDespesas() {
        return despesas.values().stream().toList();
    }

    @Override
    public void deletarDespesa(long id) {
        despesas.remove(id);
    }
}
