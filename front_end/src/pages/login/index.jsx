import React, { Component } from 'react'
import {
    NavBar,
    WingBlank,
    List,
    InputItem,
    Button,
    Toast
} from 'antd-mobile'
import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'

import { login } from '../../redux/action'
import { getRedirectTo } from '../../utils'

import './index.less'

class Login extends Component {
    state = {
        username: '',
        password: '',
    }

    handleChange = (name, val) => {
        this.setState({
            [name]: val
        })
    }

    login = () => {
        const { username,password } = this.state
        if(!username){
            return Toast.info('Please fill in the user name')
        }else if(!password){
            return Toast.info('Please fill in your password')
        }
        // print(this.state);
         this.props.login(this.state)
        this.setState({
            username: '',
            password: '',
        })
    }

    toRegister = () => {
        this.props.history.replace('/register')
    }

    render() {
        const { _id } = this.props.user
        if (_id) {
            return <Redirect to={getRedirectTo(this.props.user)} />
        }

        const {username,password} = this.state

        return (
            <div className="login-page">
                <NavBar>Auvergne Pro</NavBar>
                <WingBlank>
                    <List>
                        <InputItem value={username} placeholder='Please enter a user name' onChange={val => this.handleChange('username', val)}>usernane:</InputItem>
                        <InputItem value={password} placeholder='Please enter your password' type="password" onChange={val => this.handleChange('password', val)}>Password:</InputItem>
                    </List>
                    <Button type='primary' onClick={this.login}>Login</Button>
                    <Button onClick={this.toRegister}>No account yet</Button>
                </WingBlank>
            </div>
        )
    }
}

export default connect(
    state => ({
        user: state.user
    }),
    { login }
)(Login)
