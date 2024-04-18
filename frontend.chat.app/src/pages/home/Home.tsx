import {
    divCardHome,
    cardHome,
    titleNameUser,
    inputApodo,
    styleRigth,
    styleLeft,
} from "../../styles/home/home";
import InputEmoji from "react-input-emoji";
import { Card, Input, Col, Row, Alert, Space } from "antd";
import imgIconUser from "../../assets/img/iconUserHome.svg";
import ListFriends from "../../components/home/ListFriends";
import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { useLogout } from "../../hooks/login/useLogin";

import { socket } from '../../socket'

interface IJsonMessage {
    mes_message: string,
    use_id_a: number;
    use_id_b: number;
    mes_orden: number;
}


export const HomePage = () => {

    const username: string = useSelector((state: any) => state.authCorrect.username)
    const nickname: string = useSelector((state: any) => state.authCorrect.nickname)
    const userId: string = useSelector((state: any) => state.authCorrect.id)
    const usernameFriend: string = useSelector((state: any) => state.friendMessage.name_friend)
    const usernameFriendId: number = useSelector((state: any) => state.friendMessage.id)

    const navigate = useNavigate();
    const [logout] = useLogout()

    const [text, setText] = useState("");
    const [lstMessage, setlstMessage] = useState<IJsonMessage[]>([]);

    function handleOnEnter(text: string) {
        const jsonSend: any = {
            mes_message: text,
            use_id_a: userId,
            use_id_b: usernameFriendId,
            mes_orden: 1
        }
        setlstMessage([...lstMessage, jsonSend]);
        socket.emit('sse-message-chat', jsonSend)
    }

    useEffect(() => {
        socket.on('sse-message-chat-response', (data: any) => {
            setlstMessage([...lstMessage, data]);
            console.log(lstMessage);
        });
    });


    return (
        <div>
            <button onClick={() => {
                logout()
                navigate("/login")
            }}>Salir</button>
            <div style={divCardHome}>
                <Card style={cardHome}>
                    <Row>
                        <Col span={8} order={1}>
                            <div className="title-name-chat w-100">
                                <img
                                    src={imgIconUser}
                                    style={{ width: 40, float: "left" }}
                                    className="img-fluid"
                                    alt="user"
                                />
                                <div className="name-username">
                                    <span style={titleNameUser}>{username.toLocaleUpperCase()}</span>
                                </div>
                            </div>
                            <div className="divider-break">
                                <br />
                                <hr />
                            </div>
                            <div className="title-lst-friend">
                                <div className="apodo">
                                    <Input
                                        value={"APODO : ".concat(nickname.toUpperCase())}
                                        style={inputApodo} />
                                    <hr />
                                </div>
                            </div>
                            <ListFriends />
                        </Col>
                        <Col span={16} order={2}>
                            <div className="title-friend-chat">
                                <Input style={{ marginLeft: 35, width: "95%" }} value={usernameFriend?.toUpperCase()} />
                            </div>
                            <hr style={{ marginLeft: 35, width: "95%" }} />

                            <div className="container-message">
                                <div className="card" style={{ marginLeft: 35, width: "95%", background: '#f4f7ff', height: '280px' }}>
                                    <div className="card-body" style={{ overflowY: 'auto', maxHeight: '280px', overflowX: 'hidden' }}>
                                        {lstMessage?.length > 0 ?
                                            lstMessage.map((item: IJsonMessage) => {
                                                const userCurrent: boolean = (item.use_id_a !== usernameFriendId)
                                                return <div className="w-50" style={userCurrent ? styleRigth : styleLeft}>
                                                    <Alert
                                                        style={{ fontSize: 12, padding: 4, margin: 3, textAlign: 'justify', borderRadius: (userCurrent) ? '10px 10px 1px' : '10px 10px 10px 1px' }}
                                                        className="w-100"
                                                        description={item.mes_message}
                                                        type={"info"}
                                                    />
                                                </div>
                                            })
                                            : null
                                        }
                                    </div>
                                </div>
                            </div>

                            <hr style={{ marginLeft: 35, width: "95%" }} />
                            <div className="space-text-send">
                                <Space.Compact style={{ marginLeft: 20, width: "100%" }}>
                                    <div className="input-text w-100">
                                        <InputEmoji
                                            value={text}
                                            onChange={setText}
                                            cleanOnEnter
                                            onEnter={handleOnEnter}
                                            placeholder="Escribir..."
                                            borderRadius={10}
                                            language="es"
                                            theme="light"
                                            fontSize={13}
                                            height={100}
                                        />
                                    </div>
                                </Space.Compact>
                            </div>
                        </Col>
                    </Row>
                </Card>
            </div>
        </div>
    );
};