import {Toast} from 'antd-mobile'
import io from 'socket.io-client'

import {reqRegister,reqLogin, reqUpdate, reqUser, reqMsgList,reqRead} from '../api'
import {AUTH_SUCCESS,RESET_USER,SET_USERLIST,RECEIVE_MSG,RECEIVE_MSG_LIST,SET_READ} from './action-type'

const authSuccess = (user) => ({
    type: AUTH_SUCCESS,
    data: user
})

export const resetUser = (msg) => ({
    type: RESET_USER,
    data: msg
})

const setUserList = (userList) => ({
    type: SET_USERLIST,
    data: userList
})

const receiveMsgList = ({users,msgList}) => ({
    type: RECEIVE_MSG_LIST,
    data: {users,msgList}
})

const receiveMsg = (msg) => ({
    type: RECEIVE_MSG,
    data: msg
})

const setRead = (chat_id) => ({
    type: SET_READ,
    data: chat_id
})

export const register = user => {
    return async dispatch => {
        const result = await reqRegister(user)
        if(result.data.code===0){
            // const {data} = result.data
            dispatch(authSuccess(result.data.data))
            getMsgList(dispatch,result.data.data.id)
        }else{
            const msg = result.msg
            Toast.info(msg)
        }
    }
}

export const login = user => {
    return async dispatch => {
        const result = await reqLogin(user)
        if(result.data.code===0){
            // const {data} = result.data.data
            dispatch(authSuccess(result.data.data))
            getMsgList(dispatch,result.data.data.id)
        }else{
            const msg = result.msg
            Toast.info(msg)
        }
    }
}

export const updateUser = user => {
    return async dispatch => {
        const result = await reqUpdate(user)
        if(result.data.code===0){
            // const {data} = result.data.data
            dispatch(authSuccess(result.data.data))
        }else{
            const msg = result.msg
            dispatch(resetUser(msg))
        }
    }
}

export const getUser = () => {
    return async dispatch => {
        const result = await reqUser()
        if(result.data.code===0){
            // const {data} = result.data.data
            dispatch(authSuccess(result.data.data))
            getMsgList(dispatch,result.data.id)
        }else{
            const msg = result.msg
            Toast.info(msg)
        }
    }
}

export const getUserList = (type,userid) => {
    return async dispatch => {
        const result = await reqUser(type)
        if(result.data.code===0){
            const {data} = result.data.data
            dispatch(setUserList(result.data.data))
            // getMsgList(dispatch,userid)
        }else{
            const msg = result.data.msg
            Toast.info(msg)
        }
    }
}

function initIO(dispatch,userid){
    if(!io.socket){
        io.socket = io('ws://127.0.0.1:9099')
        io.socket.on('receiveMsg',msg=>{
            if(msg.from===userid || msg.to===userid){
                dispatch(receiveMsg(msg))
            }
        })
    }
}

async function getMsgList(dispatch,userid){
    initIO(dispatch,userid)
    const result = await reqMsgList()
    if(result.data.code===0){
        const {users,msgList} = result.data
        console.log(msgList)
        console.log(users)
        dispatch(receiveMsgList({users,msgList}))
    }
}

export const sendMsg = ({ content, from, to }) => {
    return dispatch => {
        io.socket.emit('sendMsg',{ content, from, to })
    }
}

export const getRead = (chat_id) => {
    return async dispatch => {
        const result = await reqRead(chat_id)
        if(result.code===0){
            dispatch(setRead(chat_id))
        } 
    }
}