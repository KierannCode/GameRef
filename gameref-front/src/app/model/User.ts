export interface User {
    id: number;
    pseudo: string;
    email: string;
    birthDate?: Date;
    phoneNumber?: string;
    role: string;
}