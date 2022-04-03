import ReactDOM from 'react-dom'

import React, { Component } from 'react'
import { WingBlank, WhiteSpace, Card } from 'antd-mobile'
import { withRouter } from 'react-router-dom'
import QueueAnim from 'rc-queue-anim'

import PropTypes from 'prop-types'

class FetchDemo extends Component {
    //Initialiser la valeur d'état dans le constructeur, meg : la valeur d'entrée, 
    //response : la valeur de retour du robot, megArray : la valeur envoyée par l'utilisateur
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
    sendMessage() {
      var message = this.state.meg
      if(message === ''){
        alert('Envoyez pas un message vide ! ')
      }else{
            this.setState({
        megArray: [...this.state.megArray, message]
      })
      //verrouiller l'environnement actuel
      var that = this
      //Utiliser l'outil de récupération
      var func = fetch('http://www.tuling123.com/openapi/api?key=f0d11b6cae4647b2bd810a6a3df2136f&info=' + message, {
        method: 'POST',
        type: 'cors'
      }).then(function(response) {
        return response.json()
      }).then(function(detail) {
        return (that.setState({
          respon: [...that.state.respon, detail.text]
        }, () => {
          //ReactDOM.findDOMNode() trouve le nœud réel
          var el = ReactDOM.findDOMNode(that.refs.msgList);
          el.scrollTop = el.scrollHeight;
        }))
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
           <div className="fixedBottom">
             <input className="input" value={meg} onChange={this.handleData.bind(this)} />
             <button className="button" onClick={this.sendMessage.bind(this)}>发送</button>
           </div>
        </div>
      )
    }
  }
  
  ReactDOM.render(<FetchDemo />, document.getElementById('app'))