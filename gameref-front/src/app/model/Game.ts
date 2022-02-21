import { AgeRating } from "./AgeRating";
import { Category } from "./Category";
import { EconomicModel } from "./EconomicModel";
import { Editor } from "./Editor";
import { Platform } from "./Platform";
import { User } from "./User";


export interface Game {
    id: number;
    name: string;
    description: string;
    releaseDate: Date;
    ageRating: AgeRating;
    moderator: User;
    category: Category;
    economicModel: EconomicModel;
    platforms: Array<Platform>;
    editor: Editor;
}