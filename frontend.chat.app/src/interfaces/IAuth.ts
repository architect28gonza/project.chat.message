interface IStateAuth {
    id: number;
    auth: boolean;
    token_access: string;
    provider: string;
    username: string;
    nickname: string;
}