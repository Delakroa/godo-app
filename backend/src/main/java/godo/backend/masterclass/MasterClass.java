package godo.backend.masterclass;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("master_classes")
@NoArgsConstructor
@Getter
@Setter
public class MasterClass {
    @Id
    private Long id;

    @NotBlank(message = "Название мастер-класса обязательно")
    private String title;

    @NotBlank(message = "Описание обязательно")
    private String description;

    @NotBlank(message = "Имя инструктора обязательно")
    private String instructor;

    @Column("duration_minutes")
    @NotNull(message = "Длительность обязательна") @Positive(message = "Длительность должна быть положительным числом") private Integer durationMinutes;

    @NotNull(message = "Цена обязательна") @Positive(message = "Цена должна быть положительным числом") private BigDecimal price;

    @Column("created_at")
    private LocalDateTime createdAt;

    public MasterClass(String title, String description, String instructor, Integer durationMinutes, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.durationMinutes = durationMinutes;
        this.price = price;
    }
}
