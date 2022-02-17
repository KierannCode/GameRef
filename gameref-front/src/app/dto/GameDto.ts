export interface GameDto {
    name?: string;
    description?: string;
    releaseDate?: Date;
    ageRatingId?: number;
    categoryId?: number;
    editorId?: number;
    platformIds?: Array<number>;
    economicModelId?: number;
}