import axios from 'axios'

export const axiosPost = async (url: string, json: any, header: any): Promise<{ status: number, data: any }> => {
    let jsonResponse: { status: number, data: any } = { status: 0, data: null }
    await axios.post(url, json, header)
        .then(({ data }) => {
            jsonResponse.status = data.status
            jsonResponse.data = data
        })
        .catch(error => jsonResponse.status = error?.response?.status)
    return jsonResponse
}

export const axiosGet = async (url: string, header: any): Promise<any> => {
    let jsonResponse: { status: number, data: any } = { status: 0, data: null }
    try {
        const response = await fetch(url, {
            method: 'GET', // or 'PUT'
            headers: header
        });
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        const data = await response.json();
        jsonResponse.status = data.status?.replace(/OK/g, '')
        jsonResponse.data = data.lstFriends
    } catch (error) {
        console.error('There was a problem with your fetch operation:', error);
    }
    return jsonResponse
}