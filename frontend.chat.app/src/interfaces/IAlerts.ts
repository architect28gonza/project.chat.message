interface IAlert {
    type: string,
    title: string,
    message: string
}

interface IAlertMessage {
    type: string,
    message: string,
    description: string,
    duration: number,
    icon: JSX.Element
}