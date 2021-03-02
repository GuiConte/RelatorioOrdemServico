/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorioos;

/**
 *
 * @author LAB
 */
public class Relatorio {
    
    private String id;
    private String data_lancamento;
    private String descricao;
    private String valor_servico;
    private String funcionario;
    public static Double total = 0.0;

    public Relatorio(String id, String data_lancamento, String descricao, String valor_servico, String funcionario) {
        this.id = id;
        this.data_lancamento = data_lancamento;
        this.descricao = descricao;
        this.valor_servico = valor_servico;
        this.funcionario = funcionario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor_servico() {
        return valor_servico;
    }

    public void setValor_servico(String valor_servico) {
        this.valor_servico = valor_servico;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }  
    
}
