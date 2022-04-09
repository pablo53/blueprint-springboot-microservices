import React, { Component } from 'react';
import '../common/Common.css';
import './KeycloakLoginPanel.css';
import Keycloak from "keycloak-js";

export default class KeycloakLoginPanel extends Component {

    constructor(props) {
        super(props);
        this.state = {
            keycloak: null,
            onLogout: props.onLogout,
            onLogin: props.onLogin,
            loggedIn: false,
            loggedInSetter: props.loggedInSetter
        };
        this.handleOnLogin = this.handleOnLogin.bind(this);
        this.handleOnLogout = this.handleOnLogout.bind(this);
        this.setLoggedIn = this.setLoggedIn.bind(this);
        this.setKeyCloak = this.setKeyCloak.bind(this);
        console.debug('KeycloakLoginPanel constructed');
    }

    componentDidMount() {
        const keycloak = Keycloak({
            "realm": "usvc-realm", // this realm must be created in KeyCloak
            "url": "http://localhost:18080/auth/",
            "clientId": "usvcui" // this public client_id must exist in the above KeyCloak realm
        });
        this.setKeyCloak(keycloak);
        keycloak.init({
            onLoad: 'check-sso'
        }).then((result) => {
            console.debug('keycloack initialization result: ' + result);
            this.setLoggedIn(result);
        })
    }

    setKeyCloak(keycloak) {
        this.setState({
            keycloak: keycloak,
            onLogout: this.state.onLogout,
            onLogin: this.state.onLogin,
            loggedIn: this.state.loggedIn,
            loggedInSetter: this.state.loggedInSetter
        });
        console.debug('keycloack set to: ' + keycloak);
    }

    setLoggedIn(loggedIn) {
        this.setState({
            keycloak: this.state.keycloak,
            onLogout: this.state.onLogout,
            onLogin: this.state.onLogin,
            loggedIn: loggedIn,
            loggedInSetter: this.state.loggedInSetter
        });
        console.debug('logged in: ' + loggedIn);
        if (this.state.loggedInSetter)
            this.state.loggedInSetter(loggedIn);
    }

    handleOnLogin() {
        console.debug('Login button clicked');
        this.state.keycloak.login().then( () => {
            console.debug('Keycloak logged in');
            this.setLoggedIn(true);
            if (this.state.onLogin)
                this.state.onLogin();
        })
    }

    handleOnLogout() {
        console.debug('Logout button clicked');
        this.state.keycloak.logout().then( () => {
            console.debug('Keycloak logged out');
            this.setLoggedIn(false);
            if (this.state.onLogout)
                this.state.onLogout();
        });
    }

    render() {
        return (
                (this.state.loggedIn)
                    ? (<button className="LoginPanelButton" onClick={this.handleOnLogout}>Logout</button>)
                    : (<button className="LoginPanelButton" onClick={this.handleOnLogin}>Login</button>)
        );
    }

}