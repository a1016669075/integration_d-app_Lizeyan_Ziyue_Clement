import React, { Component } from 'react'
import { connect } from 'react-redux'
import {Redirect} from 'react-router-dom'
import ReactDOM from 'react-dom'
import { getUserList } from '../../redux/action'
import UserList from '../../compoents/user-list'
// import FetchDemo from '../../'

class Dashen extends Component {
    componentDidMount(){
        this.props.getUserList('laoban',this.props.user._id)
    }



    method() {
        ReactDOM.findDOMNode(this.refs.refName);
      }
    render() {
        const {header} = this.props.user
        if(!header){
            return <Redirect to='/dashen-info'/>
        }

        const {userList} = this.props
        return (
            <div>
                 <div ref="refName"/>
                <UserList userList={userList}/>
                {/* <div style={'position=relative,top:20'}>123131</div> */}
               
            </div>
            
        )
    }
}

export default connect(
    state => ({
        user: state.user,
        userList: state.userList
    }),
    { getUserList }
)(Dashen)