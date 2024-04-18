import { createSlice } from '@reduxjs/toolkit';

const initValueAuthCorrect = {
    auth: false,
    token_access: "",
    provider: "",
    username: "",
    nickname: "",
    id: -1
}

export const { actions, reducer } = createSlice({
    name: 'valueAuthCorrect',
    initialState: initValueAuthCorrect,
    reducers: {
        setAuthCorrect: (state: IStateAuth, action: any) => {
            const { accessToken, status, provider, username, nickname, id } = action.payload
            state.auth = status === 200
            state.provider = provider
            state.token_access = accessToken
            state.username = username
            state.nickname = nickname
            state.id = id
        },
    },
});

export const { setAuthCorrect } = actions;

export default reducer;
