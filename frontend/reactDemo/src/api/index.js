import axios from 'axios'

export const reqRegister = ({username,password,type}) => axios.post('http://192.168.68.39:9090/register',{username,password,type})

export const reqLogin = user => axios.post('http://192.168.68.39:9090/login',user)

export const reqUpdate = user => axios.post('http://192.168.68.39:9090/update',user)

export const reqUser = type => axios.get('http://192.168.68.39:9090/user',{params:{type}})

export const reqMsgList = () => axios.get('http://192.168.68.39:9090/msglist')

export const reqRead = chat_id => axios.post('http://192.168.68.39:9090/read',{chat_id})

