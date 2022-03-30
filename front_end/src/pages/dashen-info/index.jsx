import React, { Component } from 'react'
import { connect } from 'react-redux'
import { NavBar, InputItem, TextareaItem, Button, Toast } from 'antd-mobile'
import { Redirect } from 'react-router-dom'

import { updateUser } from '../../redux/action'
import HeaderSelector from '../../compoents/header-selector'

class DashenInfo extends Component {
    state = {
        header: '',
        post: '',
        info: '',
    }

    getHeader = (header) => {
        this.setState({
            header
        })
    }

    handleChange = (attr, val) => {
        this.setState({
            [attr]: val
        })
    }

    save = () => {
        const {header,post,info} = this.state
        if(!header){
            return Toast.info('Please select your avatar')
        }else if(!post){
            return Toast.info('Please fill in the job position')
        }else if(!info){
            return Toast.info('Please fill in your personal introduction')
        }
        this.props.updateUser(this.state)
    }

    render() {
        const { header, type } = this.props.user
        if (header && type === 'laoban') {
            return <Redirect to='/laoban'/>
        }else if(header && type === 'dashen'){
            return <Redirect to='/dashen'/>
        }

        return (
            <div>
                <NavBar>Information is complete</NavBar>
                <HeaderSelector getHeader={this.getHeader} />
                <InputItem onChange={val => this.handleChange('post', val)}>Job Position:</InputItem>
                <TextareaItem
                    title='Personal Introduction:'
                    rows={3}
                    onChange={val => this.handleChange('info', val)}
                ></TextareaItem>
                <Button type="primary" onClick={this.save}>Save</Button>
            </div>
        )
    }
}

export default connect(
    state => ({
        user: state.user
    }),
    { updateUser }
)(DashenInfo)

