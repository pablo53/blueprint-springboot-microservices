import React, { Component } from 'react';
import logo from './Raberix.svg';
import './Raberix.css';
import Echo from './echo/Echo';
import KeycloakLoginPanel from "./login/KeycloakLoginPanel";

class Raberix extends Component {

    constructor(props) {
        super(props);
        this.state = {
            loggedIn: false
        };
        this.setLoggedIn = this.setLoggedIn.bind(this);
    }

    setLoggedIn(loggedIn) {
        this.setState({
            loggedIn: loggedIn
        });
    }

    render() {
        return (
            <div className="Raberix">
                <div className="Raberix-header">
                    <h2>
                        <img src={logo} className="Raberix-logo" alt="logo"/>
                        <span className="Raberix-title">Raberix Dashboard</span>
                        <span className="Raberix-loginPanel">
                            <KeycloakLoginPanel loggedInSetter={this.setLoggedIn} />
                        </span>
                    </h2>
                </div>
                <p className="Raberix-intro">
                    { (this.state.loggedIn)
                        ? <Echo/>
                        : <span>Welcome to Raberix Dashboard. You must be logged in first.</span>
                    }
                </p>
            </div>
        );
  }
}

export default Raberix;
