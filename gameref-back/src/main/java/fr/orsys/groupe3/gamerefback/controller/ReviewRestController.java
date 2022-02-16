package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ReviewRestController {

    private ReviewService reviewService;

    // Ajout d'un avis
    @PostMapping("/review")
    public Review addReview(@RequestBody ReviewDto dto) throws NotFoundException {
        return reviewService.createGame(dto);
    }

    // Suppression d'un avis
    @DeleteMapping("review/{id}")
    public Review deleteReview(@PathVariable("id") long id) throws NotFoundException {
        return reviewService.deleteReview(id);
    }

    @GetMapping("/reviews")
    public Page<Review> getReviews(Pageable pageable) throws NotFoundException {
        return reviewService.getReviews(pageable);
    }

    @PatchMapping("/game/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody ReviewDto dto) throws NotFoundException {
        return reviewService.updateReview(id, dto);

    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public String handleNotFoundException(NotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> handleValidationErrors(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
