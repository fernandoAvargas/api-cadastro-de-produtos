package com.apicrud.cadastro_produto.infrastructure.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name="produto")
@Entity

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "codigo", unique = true )
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tamanho")
    private String tamanho;
}
