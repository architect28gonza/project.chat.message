import { Card, Input, Button, Col, Row } from 'antd';
import { buttonLoginCard, cardCol, cardLogin, divCardLogin, inputLoginCard, titleLoginCard } from '../../styles/login/login';
import { FacebookLoginButton, GoogleLoginButton, TikTokLoginButton, InstagramLoginButton } from 'react-social-login-buttons'
import { useLogin } from '../../hooks/login/useLogin';
import { ComponentAlertMessage } from '../../components/common/alertMessage';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { ALERT_MESSAGE_INGRESAR, ALERT_MESSAGE_USUARIO_INCORRECT } from '../../utils/messageAlert';
import imgLogin from '../../assets/img/undraw_business_chat_re_gg4h.svg'

const loginButtons = [
    { id: 1, component: <FacebookLoginButton text='Facebook' type="button" /> },
    { id: 2, component: <GoogleLoginButton text='Google' type="button" /> },
    { id: 3, component: <TikTokLoginButton text='TikTok' type="button" /> },
    { id: 4, component: <InstagramLoginButton text='Instagram' type="button" /> }
];

import { useSelector } from 'react-redux';

export const LoginPage = () => {
    const navigate = useNavigate();
    const [inputs, handlerLogin, isValidateInputs, sendDataLogin, messageAuth, setMessageAuth] = useLogin()
    const [contextHolder, openNotification] = ComponentAlertMessage()
    const isAuthUser : boolean = useSelector((state:any) => state.authCorrect.auth)
    
    useEffect(() => {
        if (messageAuth) {
            openNotification(ALERT_MESSAGE_USUARIO_INCORRECT)
        }
        if (isAuthUser) {
            navigate('/home');
        }
        setMessageAuth(false)
    }, [messageAuth, isAuthUser]);

    return (
        <div className='card-body-complete-login'>
            <div style={divCardLogin}>
                <Card style={cardLogin}>
                    <Row>
                        <Col
                            style={{ paddingRight: 30 }}
                            span={9} xs={{ order: 1 }} sm={{ order: 2 }} md={{ order: 3 }} lg={{ order: 4 }}>
                            <div className='title-span-login'>
                                <span style={titleLoginCard}>INICIO DE SESIÓN</span>
                            </div>
                            <div className="card-body-input">
                                <div className="input-user mt-5">
                                    <Input placeholder="usuario"
                                        name='username' id='username'
                                        value={inputs.username}
                                        onChange={handlerLogin}
                                        style={inputLoginCard}
                                        autoComplete='off' size='large' />
                                </div>
                                <div className="input-password mt-5">
                                    <Input.Password placeholder="contraseña"
                                        name='password' id='password'
                                        value={inputs.password}
                                        onChange={handlerLogin}
                                        style={inputLoginCard}
                                        size='large' />
                                </div>
                            </div>
                            <div className="card-footer-button">
                                <div className="button-inicio-session mt-4 d-flex justify-content-between align-items-center">
                                    <>
                                        {contextHolder}
                                        <Button className='mt-5'
                                            onClick={() => isValidateInputs(inputs)
                                                ? sendDataLogin(inputs)
                                                : openNotification(ALERT_MESSAGE_INGRESAR)}
                                            style={buttonLoginCard}
                                            size="middle">
                                            INICIAR SESIÓN
                                        </Button>
                                    </>
                                </div>
                                <div className="button-create-user mt-5">
                                    <Button type='link' style={{ fontWeight: 'bold' }} block>
                                        CREAR CUENTA GRATIS
                                    </Button>
                                </div>
                            </div>
                            <div className="title-footer-copyrigh">
                                <span style={{ color: '#82a6c4' }}>@copyright cod!gon</span>
                            </div>
                        </Col>
                        <Col
                            style={cardCol}
                            span={15} xs={{ order: 1 }} sm={{ order: 2 }} md={{ order: 3 }} lg={{ order: 4 }}>
                            <div className="img-login">
                                <img src={imgLogin} width={250} height={180} style={{ padding: 0, margin: 0, zIndex: 4 }} alt="logoLogin" />
                            </div>
                            <div className="description">
                                <span style={{ padding: 20, color: '#455e74', fontWeight: 'bold' }}>
                                    ¡Bienvenido a BluChat, tu puente hacia conexiones más profundas y conversaciones significativas!
                                    Aquí en BluChat, creemos en el poder de la comunicación para acercar a las personas, sin importar dónde se encuentren.
                                    Con una interfaz intuitiva y funciones diseñadas pensando en ti. <br /><br />
                                    ¡Empieza a explorar hoy y ve hasta<br /> dónde pueden llevarte tus conversaciones!
                                </span>
                            </div>
                            <div className='card-body-button-login-social mt-3'>
                                <Row>
                                    {loginButtons.map(button => (
                                        <Col key={button.id}>
                                            {button.component}
                                        </Col>
                                    ))}
                                </Row>
                            </div>
                        </Col>
                    </Row>
                </Card>
            </div>
        </div>
    );
}