import { useDispatch, useSelector } from "react-redux";
import { axiosGet } from "../../services/AppServices";
import { URL_FRIENDS } from "../../utils/urls";
import { headerToken } from "../../utils/header";
import { setNameFriend } from "../../features/HomeSlice";

interface IResponseFriends {
    status: number;
    data: any;
}

export function useFriends(): [
    (id: number) => Promise<IResponseFriends>,
    (name: any) => void
] {
    const dispatch = useDispatch();
    const token_access: string = useSelector((state: any) => state.authCorrect.token_access)

    const loadFriends = async (id: number): Promise<IResponseFriends> => {
        const response = await axiosGet(`${URL_FRIENDS}/${id}`, headerToken(token_access))
        return response
    }

    const setNameFriendCard = (itemFriend: any) => {
        const json: any = { id: itemFriend?.id, name: itemFriend?.name }
        dispatch(setNameFriend(json))
    }

    return [loadFriends, setNameFriendCard];
}
