import React, { Component } from 'react'
import { Result, List, Button, WhiteSpace, Modal, WingBlank } from 'antd-mobile'
import { connect } from 'react-redux'
import Cookies from 'js-cookie'

import { resetUser } from '../../redux/action'
import io from 'socket.io-client'

const Item = List.Item
const Brief = Item.Brief

class Personal extends Component {
    logout = () => {
        Modal.alert('Log out', 'Are you sure to log out', [
            { text: 'cancel' },
            {
                text: 'confirm', onPress: () => {
                    Cookies.remove('user_id')
                    this.props.resetUser()
                    io.socket.close()
                }
            }
        ])
    }

    render() {
        const { header, post, company, info, salary, username } = this.props.user
        return (
            <div>
                <Result
                    img={<img src={header ? require(`../../assets/images/headers/${header}.png`) : null} />}
                    title={username}
                    message={company ? company : null}
                />
                <List renderHeader={'The relevant information'} className="my-list">
                    <Item multipleLine>
                        <Brief>position: {post}</Brief>
                        <Brief>Introduction to the: {info}</Brief>
                        {
                            salary ?
                                <Brief>salary: {salary}</Brief> : null
                        }
                    </Item>
                </List>
                <WhiteSpace />
                <Button type='warning' onClick={this.logout}>Log out</Button>
            </div>
        )
    }
}

export default connect(
    state => ({
        user: state.user
    }),
    { resetUser }
)(Personal)