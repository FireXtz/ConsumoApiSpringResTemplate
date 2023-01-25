package com.Tiny.TinyConsumes.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Produto {
    @JsonProperty("retorno")
    private String retorno;
    @JsonProperty("id")
    private String id;
    @JsonProperty("nome")
    private String  nome;
    @JsonProperty("codigo")
    private String codigo;
    private List<Map<String, Object>> interests;

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    @JsonCreator
    public Produto( @JsonProperty("retorno")String retorno,  @JsonProperty("id")String id, @JsonProperty("nome") String nome,@JsonProperty("codigo") String codigo,@JsonProperty("interests") List<Map<String, Object>> interests) {
        this.retorno = retorno;
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.interests = interests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Map<String, Object>> getInterests() {
        return interests;
    }

    public void setInterests(List<Map<String, Object>> interests) {
        this.interests = interests;
    }
}
