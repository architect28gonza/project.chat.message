import { InfoCircleOutlined, CloseCircleOutlined, WarningOutlined, CheckOutlined } from '@ant-design/icons';

const lstIcons: any = {
    info: <InfoCircleOutlined style={{ color: '#108ee9' }} />,
    error: <CloseCircleOutlined style={{ color: '#108ee9' }} />,
    warning: <WarningOutlined style={{ color: '#108ee9' }} />,
    success: <CheckOutlined style={{ color: '#108ee9' }} />
};

export const ListAlertMessage: any = (type: string, message: string, description: string): IAlertMessage => {
    const icon: JSX.Element = lstIcons[type];
    return {
        type,
        message,
        description,
        duration: 0,
        icon
    };
};
