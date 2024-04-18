import { useEffect, useState } from "react";
import InfiniteScroll from "react-infinite-scroll-component";
import { List, Skeleton, Divider } from "antd";
import { cardListFriend } from "../../styles/home/home";
import { useSelector } from "react-redux";
import { useFriends } from "../../hooks/home/useHome";
import userFriend from '../../assets/img/iconUserHome2.svg'

interface IFriendLst {
    id: number;
    name: string;
    nickname:string;
}

const ListFriends = () => {
    const idUsername: number = useSelector((state: any) => state.authCorrect.id)
    const usernameFriendId : string = useSelector((state:any) => state.friendMessage.id)

    const [loadFriends, setNameFriendCard] = useFriends()
    const [lstFriends, setLstFriends] = useState<IFriendLst[]>([]);

    const loadFriendsServices = () => {
        loadFriends(idUsername)
            .then((response: { status: number; data: any }) => {
                setLstFriends(response.data)
            })
    }

    useEffect(() => {
        loadFriendsServices()
    }, []);

    return (
        <>
            <div className="container-list-friend">
                <div id="scrollableDiv" style={cardListFriend}>
                    <InfiniteScroll
                        dataLength={lstFriends.length}
                        next={loadFriendsServices}
                        hasMore={lstFriends.length < 50}
                        loader={<Skeleton avatar paragraph={{ rows: 1 }} active />}
                        endMessage={<Divider plain>It is all, nothing more 🤐</Divider>}
                        scrollableTarget="scrollableDiv"
                    >
                        <List
                            dataSource={lstFriends}
                            renderItem={(item:any) => (
                                <List.Item key={item.id} onClick={() => setNameFriendCard(item)}>
                                    <List.Item.Meta
                                        style={(usernameFriendId == item.id) ? {backgroundColor: '#f1f1f1', borderRadius: 14} : {}}
                                        avatar={<img src={userFriend} className="img-fluid" style={{width: 35}} />}
                                        title={<>NOMBRE : <b>{item.name?.toUpperCase()}</b></>}
                                        description={<>APODO : <b><i>{item.nickname?.toUpperCase()}</i></b></>}
                                    />
                                </List.Item>
                            )}
                        />
                    </InfiniteScroll>
                </div>
            </div>
        </>
    );
};

export default ListFriends;
