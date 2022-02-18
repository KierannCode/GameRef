import { Game } from "./Game";
import { Moderator } from "./Moderator";
import { Player } from "./Player";

export interface Review {
    id: number;
    description: string;
    submitDate: Date;
    moderator: Moderator;
    rating: number;
    game: Game;
    player: Player;
}