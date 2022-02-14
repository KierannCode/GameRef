
import java.util.*;

/**
 * 
 */
public class Game {

    /**
     * Default constructor
     */
    public Game() {
    }

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private LocalDate releaseDate;

    /**
     * 
     */
    private Boolean hasImage;

    /**
     * 
     */
    private Set<Review> reviews;

    /**
     * 
     */
    private AgeRating ageRating;

    /**
     * 
     */
    private Category category;

    /**
     * 
     */
    private Editor editor;

    /**
     * 
     */
    private Set<Platform> platforms;

    /**
     * 
     */
    private EconomicModel economicModel;

    /**
     * 
     */
    private Moderator moderator;

}