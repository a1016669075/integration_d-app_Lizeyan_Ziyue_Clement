import React, { Component } from 'react'
import {
    NavBar,
    WingBlank,
    List,
    InputItem,
    Radio,
    Button,
    Toast
} from 'antd-mobile'
import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'

import { register } from '../../redux/action'
import { getRedirectTo } from '../../utils'

import './index.less'

const ListItem = List.Item

class Register extends Component {
    state = {
        username: '',
        password: '',
        password2: '',
        type: 'dashen'
    }

    handleChange = (name, val) => {
        this.setState({
            [name]: val
        })
    }

    register = () => {
        const { username,password,password2 } = this.state
        if(!username){
            return Toast.info('Please fill in the user name')
        }else if(!password){
            return Toast.info('Please fill in your password')
        }else if(password != password2){
            return Toast.info('The entered passwords are inconsistent')
        }
        this.props.register(this.state)
        this.setState({
            username: '',
            password: '',
            password2: '',
            type: 'dashen'
        })
    }

    toLogin = () => {
        this.props.history.replace('/login')
    }

    render() {
        const { _id } = this.props.user
        if (_id) {
            return <Redirect to={getRedirectTo(this.props.user)} />
        }

        const { username, password, password2, type } = this.state
        
        return (
            <div className="register-page">
                <NavBar>Auvergne Pro</NavBar>
                <WingBlank>
                    <List>
                        <InputItem value={username} placeholder='Please enter a user name' onChange={val => this.handleChange('username', val)}>UseName:</InputItem>
                        <InputItem value={password} placeholder='Please enter your password' type="password" onChange={val => this.handleChange('password', val)}>Password:</InputItem>
                        <InputItem value={password2} placeholder='Please confirm your password' type="password" onChange={val => this.handleChange('password2', val)}>Confirm:</InputItem>
                        <ListItem>
                            <span>The user types:</span>
                            &nbsp;&nbsp;&nbsp;
                            <Radio checked={type === 'dashen'} onChange={val => this.handleChange('type', 'dashen')}>A great god</Radio>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <Radio checked={type === 'laoban'} onChange={val => this.handleChange('type', 'laoban')}>The boss</Radio>
                        </ListItem>
                    </List>
                    <Button type='primary' onClick={this.register}>registered</Button>
                    <Button onClick={this.toLogin}>Existing account</Button>
                </WingBlank>
            </div>
        )
    }
}

export default connect(
    state => ({
        user: state.user
    }),
    { register }
)(Register)
