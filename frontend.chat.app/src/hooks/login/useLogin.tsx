import { useState, ChangeEvent } from 'react';
import { axiosPost } from '../../services/AppServices';
import { URL_INIT_LOGIN } from '../../utils/urls';
import { headerSimple } from '../../utils/header';

import { useDispatch } from 'react-redux';
import { setAuthCorrect } from '../../features/AuthSlice';

interface ILoginAuth {
    username: string;
    password: string;
}

export function useLogin(): [
    ILoginAuth,
    (e: ChangeEvent<HTMLInputElement>) => void,
    (v: ILoginAuth) => boolean,
    (inputs: ILoginAuth) => void,
    messageAuth: boolean,
    (value: boolean) => void
] {

    const dispatch = useDispatch();

    const [inputs, setInputs] = useState<ILoginAuth>({
        username: '',
        password: '',
    });

    const [messageAuth, setMessageAuth] = useState(false)

    /**
     * Maneja los cambios en los campos de entrada de un formulario de inicio de sesión,
     * actualizando el estado de los inputs con los nuevos valores.
     * 
     * @param e Evento de cambio en el input, proporcionando el nombre y el valor actualizado del input modificado.
     */
    const handlerLogin = (e: ChangeEvent<HTMLInputElement>): void => {
        const { name, value } = e.target;
        setInputs(inputs => ({
            ...inputs,
            [name]: value,
        }));
    };

    /**
     * Valida si los campos de entrada de inicio de sesión no están vacíos.
     *
     * @param e Objeto que contiene los campos de usuario y contraseña.
     * @return boolean Verdadero si ambos, el nombre de usuario y la contraseña, no están vacíos.
     */
    const isValidateInputs = (e: ILoginAuth): boolean => {
        return e.username !== "" && e.password !== "";
    }


    /**
     * Conecta y envia a services para poder enviar los valores para iniciar sesion con el 
     * usuario y contraseña
     * 
     * @param e Objeto que contiene los campos de usuario y contraseña.
     * @return retorna un json que contiene el status para ver si el usuario existe
     * **/
    const sendDataLogin = async (e: ILoginAuth): Promise<void> => {
        const { username, password } = e
        const json = { username, password }
        const { status, data } = await axiosPost(URL_INIT_LOGIN, json, headerSimple)
        const isStatusCorrect: boolean = status !== 200
        if (!isStatusCorrect) {
            dispatch(setAuthCorrect(data))
        }
        setMessageAuth(isStatusCorrect)
    }

    return [inputs, handlerLogin, isValidateInputs, sendDataLogin, messageAuth, setMessageAuth];
}


/**
 * Hook personalizado para gestionar el proceso de cierre de sesión.
 * Devuelve una tupla que contiene una función para cerrar sesión.
 * Esta función se encarga de modificar el estado de autenticación a false
 * y realizar cualquier otra acción necesaria al cerrar sesión.
 * @returns Una tupla que contiene una función para cerrar sesión.
 */
export function useLogout(): [
    () => void
] {
    const dispatch = useDispatch();
    const logout = () => {
        const json: any = { auth: false, token_access: "", provider: "", username : "", nickname: "" }
        dispatch(setAuthCorrect(json))
    }
    return [logout];
}
