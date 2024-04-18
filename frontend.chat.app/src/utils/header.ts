export const headerSimple = {
    'Content-Type': 'application/json'
}

export const headerToken = (token_access: string) => {
    return {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token_access}`
    }
}