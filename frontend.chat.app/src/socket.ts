import { URL_INIT_SOCKET } from './utils/urls';
import { io } from 'socket.io-client';

export const socket = io(URL_INIT_SOCKET);