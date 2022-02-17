export interface GameDto {
    name?: string;
    description?: string;
    releaseDate?: string;
    ageRatingId?: number;
    categoryId?: number;
    editorId?: number;
    platformIds?: Array<number>;
    economicModelId?: number;
}