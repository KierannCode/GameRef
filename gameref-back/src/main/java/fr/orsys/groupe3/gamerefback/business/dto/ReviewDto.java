package fr.orsys.groupe3.gamerefback.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDto {
    private String description;
    private Float rating;
    private Long gameId;

    public ReviewDto() {

    }
}
