import { Moderator } from "./Moderator";
import { Player } from "./Player";

export interface User {
    first: Player | Moderator;
    second: boolean;
}