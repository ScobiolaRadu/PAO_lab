package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class AbstractEntity {

    private UUID id;

    /**2
     * Date nu stocheaza decat data, nu si ora. Daca vreti sa adaugati si ora, folositi LocalDateTime.
     * LocalDate.of(), LocalDateTime.of(), LocalDateTime.now() sunt metode care se pot folosi.
     * Daca folositi LocalDateTime sa redenumiti si voi variabilele cu sens, adica sa fie ceva de genul creationDateTime, daca contin si ora.
     */
    private LocalDate creationDate;

    private LocalDate updateDate;

    private LocalDate deleteDate;
}
