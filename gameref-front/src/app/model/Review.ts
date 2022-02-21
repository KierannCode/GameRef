import { Game } from "./Game";
import { User } from "./User";

export interface Review {
    id: number;
    description: string;
    submitDate: Date;
    moderator: User;
    rating: number;
    game: Game;
    player: User;
}