package com.example.demo.Model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor 
@Entity 
@Table(name = "PESSOAS_FISICAS")
public class PrestadorServicoEntity extends PessoaEntity {
    @Column(name = "PAGAMENTO", precision = 10, scale = 2, nullable = false)
    private Double salario;
}
