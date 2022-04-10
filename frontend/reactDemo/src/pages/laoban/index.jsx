import React, { Component } from 'react'
import { connect } from 'react-redux'
import {Redirect} from 'react-router-dom'
import ReactDOM from 'react-dom'
import { getUserList } from '../../redux/action'
import UserList from '../../compoents/user-list'
import FetchDemo from '../../compoents/chatdemo'
class Laoban extends Component {
    componentDidMount(){
        this.props.getUserList('dashen',this.props.user.id)
    }

    method() {
        ReactDOM.findDOMNode(this.refs.refName);
      }
    render() {
        const {header} = this.props.user
        if(!header){
            return <Redirect to='/laoban-info'/>
        }

        const {userList} = this.props
        return (
            <div>
        
                <UserList userList={userList}/>
                <div style={{position: 'absolute',right:"100px",bottom:"100px",border:"5px solid #666"  ,width:"240px", height:"520px",background:"#ffffff",
     borderRadius:"20px"
            }}>
                    <div style={{position: 'absolute',right:"1px",bottom:"1px"}}>
                    <FetchDemo />
                    </div>

                </div>
            
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
)(Laoban)