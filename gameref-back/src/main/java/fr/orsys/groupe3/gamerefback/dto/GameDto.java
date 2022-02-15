package fr.orsys.groupe3.gamerefback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GameDto {
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Long ageRatingId;
    private Long categoryId;
    private Long editorId;
    private List<Long> platformIds;
    private Long economicModelId;
    private Long moderatorId;
}
