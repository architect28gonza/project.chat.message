import { createSlice } from '@reduxjs/toolkit';

const initValueHFriendMessage = {
    id : -1,
    name_friend: ""
}

export const { actions, reducer } = createSlice({
    name: 'valueFriendName',
    initialState: initValueHFriendMessage,
    reducers: {
        setNameFriend: (state: any, action: any) => {
            const { id, name  } = action.payload
            state.name_friend = name
            state.id = id
        },
    },
});

export const { setNameFriend } = actions;

export default reducer;
