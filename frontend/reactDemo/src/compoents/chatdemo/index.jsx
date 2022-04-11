import ReactDOM from 'react-dom'

import React, { Component } from 'react'
import { WingBlank, WhiteSpace, Card } from 'antd-mobile'
import { withRouter } from 'react-router-dom'
import QueueAnim from 'rc-queue-anim'

import PropTypes from 'prop-types'

class FetchDemo extends Component {
    //Initialiser la valeur d'état dans le constructeur, meg : la valeur d'entrée, response : la valeur de retour du robot, megArray : la valeur envoyée par l'utilisateur
    constructor() {
      super()
      this.state = {
        meg: '',
        respon: [],
        megArray: []
      }
    }
    //événement de liaison onChange de l'entrée
    handleData(e) {
      this.setState({
        meg: e.target.value
      })
    }
    //Fonction personnalisée pour gérer l'opération de sauvegarde des données envoyées et des données réseau renvoyées
    async  sendMessage() {
      var message = this.state.meg
      if(message === ''){
        alert('You can not send blank messages')
      }else{
            this.setState({
        megArray: [...this.state.megArray, message]
      })
      var that = this


      var res = await fetch(`/api/chatbot?message=${encodeURIComponent(message)}&gender=${encodeURIComponent("male")}&name=${encodeURIComponent("chatbot")}`
      ).catch(e => {
        throw new Error(`Ran into an Error. ${e}`);
    });
    const response = await res.json().catch(e =>{
        throw new Error(`Ran into an Error. ${e}`);
    });
    // console.log( response.message)

    this.setState({
      megArray: [...this.state.megArray, response.message]
    })

    
      this.state.meg = ''
      }
    }
  
    render() {
      var meg = this.state.meg
      var megArray = this.state.megArray
      var respon = this.state.respon
  
      return (
        <div className="content">
          <div className="msg-list" ref="msgList">
            {megArray.map((elem,index) => (
              <div className="container" key={index}>
                <div className="message">{elem}</div>
                <div className="response">{respon[index]}</div>
              </div>)
             )}
          </div>
           <div className="fixedBottom" style={{with:"260px"}}>
             <input className="input" value={meg} onChange={this.handleData.bind(this)} />
             <button className="button" onClick={this.sendMessage.bind(this)}>Send</button>
           </div>
        </div>
      )
    }
  }
  export default withRouter(FetchDemo)