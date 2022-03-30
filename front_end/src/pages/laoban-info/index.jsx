import React, { Component } from 'react'
import { connect } from 'react-redux'
import { NavBar, InputItem, TextareaItem, Button, Toast } from 'antd-mobile'
import { Redirect } from 'react-router-dom'

import { updateUser } from '../../redux/action'
import HeaderSelector from '../../compoents/header-selector'

class LaobanInfo extends Component {
    state = {
        header: '',
        post: '',
        info: '',
        company: '',
        salary: ''
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
        const {header,post,info,company,salary} = this.state
        if(!header){
            return Toast.info('Please select your avatar')
        }else if(!post){
            return Toast.info('Please fill in the vacancy')
        }else if(!info){
            return Toast.info('Please fill in the job requirements')
        }else if(!company){
            return Toast.info('Please fill in the company name')
        }else if(!salary){
            return Toast.info('Please fill in the salary for the position')
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
                <InputItem onChange={val => this.handleChange('post', val)}>job</InputItem>
                <InputItem onChange={val => this.handleChange('company', val)}>Company Name:</InputItem>
                <InputItem onChange={val => this.handleChange('salary', val)}>Position Salary:</InputItem>
                <TextareaItem
                    title='Job Requirements:'
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
)(LaobanInfo)
