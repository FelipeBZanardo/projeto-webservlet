package persistence;
import model.Categoria;
import model.Despesa;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DespesaRepository implements Repository, Serializable {

    private final Map<Long, Despesa> despesas;
    private final Path path = Path.of("C:\\Users\\felip\\OneDrive\\Área de Trabalho\\Projeto WebServlet\\listarDespesas\\banco_dados.csv");
    public static DespesaRepository despesaRepository = getInstance();

    private DespesaRepository() {
        this.despesas = obterDadosArquivo();
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
    public void salvarDespesa(Despesa despesa) throws IOException {
        despesas.put(despesa.getId(), despesa);
        atualizarArquivo();
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
    public void deletarDespesa(long id) throws IOException {
        despesas.remove(id);
        System.out.println(despesas);
        atualizarArquivo();
    }

    private void atualizarArquivo() throws IOException {
        Files.writeString(path, "");
        despesas.values()
                .stream()
                .map(despesa -> {
                    String id = despesa.getId().toString();
                    String descricao = despesa.getDescricao();
                    String data = despesa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    String valor = despesa.getValor().toString();
                    String categoria = despesa.getCategoria().name();
                    return id + ";" + descricao + ";" +
                            data + ";" + valor + ";" + categoria + "\n";})
                .forEach(linha -> {
                    try {
                        Files.writeString(path, linha, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private Map<Long, Despesa> obterDadosArquivo(){
        Map<Long, Despesa> despesas = new HashMap<>();

        try {
            if(Files.notExists(path))
                Files.createFile(path);
            return Files.lines(path)
                    .map(linha -> {
                        String[] dados = linha.split(";");
                        long id = Long.parseLong(dados[0]);
                        String descricao = dados[1];
                        LocalDate data = LocalDate.parse(dados[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        BigDecimal valor = new BigDecimal(dados[3]);
                        Categoria categoria = Categoria.valueOf(dados[4]);
                        return new Despesa(id, descricao, data, valor, categoria);})
                    .collect(Collectors.toMap(Despesa::getId, Function.identity()));
        } catch (IOException e){
            e.printStackTrace();
            return despesas;
        }

    }
}
