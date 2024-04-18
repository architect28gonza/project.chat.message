import { notification } from 'antd';
import { ListAlertMessage } from './alertList';

export function ComponentAlertMessage() {
    const [api, contextHolder] = notification.useNotification();
    const openNotification: any = (alert: IAlert): void => api.open(ListAlertMessage(alert.type, alert.title, alert.message));
    return [contextHolder, openNotification]
}