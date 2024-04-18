
import { configureStore } from '@reduxjs/toolkit';
import initValueAuthCorrect from './features/AuthSlice';
import homeUserNameFriend from './features/HomeSlice';

import storage from 'redux-persist/lib/storage'
import {persistReducer} from 'redux-persist'
import {combineReducers} from '@reduxjs/toolkit'

const persistConfig = {
    key: 'root',
    version: 1,
    storage
}

const reducer = combineReducers({
    authCorrect: initValueAuthCorrect,
    friendMessage : homeUserNameFriend
})
const persistedReducer = persistReducer(persistConfig, reducer)

export const store = configureStore({
    reducer: persistedReducer,
});
