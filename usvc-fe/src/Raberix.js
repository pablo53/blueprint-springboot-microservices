import React, { Component } from 'react';
import logo from './Raberix.svg';
import './Raberix.css';
import Echo from './echo/Echo';

class Raberix extends Component {
  render() {
    return (
      <div className="Raberix">
        <div className="Raberix-header">
          <h2>
              <img src={logo} className="Raberix-logo" alt="logo" />
              <span className="Raberix-title">Raberix Dashboard</span>
          </h2>
        </div>
        <p className="Raberix-intro">
            Welcome to Raberix Dashboard. You must be logged in first.
            <Echo />
        </p>
      </div>
    );
  }
}

export default Raberix;
