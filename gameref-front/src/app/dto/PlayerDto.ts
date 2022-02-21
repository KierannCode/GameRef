import { UserDto } from "./UserDto";

export interface PlayerDto extends UserDto {
    birthDate?: Date;
}