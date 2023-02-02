package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    @Id
    private Long id;
    @Indexed(unique = true)
    private String reference;
    private LocalDate date;
    private Double amount;
    private OperationType operation_type;

}
