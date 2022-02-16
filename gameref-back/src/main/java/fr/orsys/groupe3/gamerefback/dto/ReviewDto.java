package fr.orsys.groupe3.gamerefback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDto {

    private String description;
    private Float rating;
    private Long gameId;

}
