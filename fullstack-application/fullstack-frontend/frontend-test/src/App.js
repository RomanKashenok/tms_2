import React, { Component } from 'react';
import './App.css';
import SubscriberApp from './component/SubscriberApp';

class App extends Component{
  render(){
    return (
      <div className="container">
        <SubscriberApp />
      </div>
    );
  }
}

export default App;
