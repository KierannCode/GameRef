import { AgeRating } from "./AgeRating";
import { Category } from "./Category";
import { EconomicModel } from "./EconomicModel";
import { Editor } from "./Editor";
import { Moderator } from "./Moderator";
import { Platform } from "./Platform";


export interface Game {
    id: number;
    name: string;
    description: string;
    releaseDate: Date;
    ageRating: AgeRating;
    moderator: Moderator;
    category: Category;
    economicModel: EconomicModel;
    platforms: Array<Platform>;
    editor: Editor;
}