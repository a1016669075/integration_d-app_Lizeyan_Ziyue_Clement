import React, { Component } from 'react'
import { WingBlank, WhiteSpace, Card } from 'antd-mobile'
import { withRouter } from 'react-router-dom'
import QueueAnim from 'rc-queue-anim'

import PropTypes from 'prop-types'

class UserList extends Component {
    static propTypes = {
        userList: PropTypes.array.isRequired
    }

    render() {
        const { userList } = this.props
        return (
            <QueueAnim delay={300} type={'scale'}>
                {
                    userList.map(item => (
                        <WingBlank key={item.id}>
                            <WhiteSpace />
                            <Card onClick={()=>this.props.history.push('/chat/'+item.id)}>
                                <Card.Header
                                    thumb={item.header ? require(`../../assets/images/headers/${item.header}.png`) : null}
                                    extra={item.username}
                                />
                                <Card.Body>
                                    <div style={{marginBottom: '3px'}}>Position:{item.post}</div>
                                    {
                                        item.company?
                                        <div style={{marginBottom: '3px'}}>entreprise:{item.company}</div>:null
                                    }
                                    {
                                        item.salary?
                                        <div style={{marginBottom: '3px'}}>salaire:{item.salary}</div>:null
                                    }
                                    <div style={{marginBottom: '3px'}}>description:{item.info}</div>
                                </Card.Body>
                            </Card>
                        </WingBlank>
                    ))
                }
            </QueueAnim>
        )
    }
}

export default withRouter(UserList)