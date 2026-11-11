package com.example.demo.database.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor 
@Entity 
@Table(name = "PESSOAS_FISICAS")
@ToString 
public class PrestadorServicoEntity extends PessoaEntity {
    @Column(name = "PAGAMENTO", precision = 10, scale = 2, nullable = false)
    private Double pagamento;

    @OneToMany(mappedBy = "prestador")
    private List<OrdemServicoEntity> ordensServico = new ArrayList<>();

}
