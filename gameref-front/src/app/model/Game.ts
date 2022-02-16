import { Platform } from "@angular/cdk/platform";
import { AgeRating } from "./AgeRating";
import { Category } from "./Category";
import { EconomicModel } from "./EconomicModel";
import { Editor } from "./Editor";
import { Moderator } from "./Moderator";

export interface Game {
    id: number;
    name: string;
    description: string;
    releaseDate: Date;
    ageRating: AgeRating;
    moderator: Moderator;
    category: Category;
    economicModel: EconomicModel;
    platform: Platform;
    editor: Editor;
}