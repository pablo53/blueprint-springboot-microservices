import React, { Component } from 'react';
import '../common/Common.css';
import './Echo.css';
import RestConnector from "../common/RestConnector";

class Echo extends Component {

    constructor(props) {
        super(props);
        this.state = { value: "" };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleMessageChanged = this.handleMessageChanged.bind(this);
        this.restConnector = new RestConnector();
    }

    handleSubmit(event) {
        this.restConnector.get("/proxy/echo/" + encodeURIComponent(this.state.value)).then(
            (resp) => {
                if (resp)
                    alert("Returned: " + resp.message);
                else
                    alert("No response")
            }
        )
        event.preventDefault()
    }

    handleMessageChanged(event) {
        this.setState({ value: event.target.value })
    }

    render() {
        return (
            <form className="CommonForm" onSubmit={this.handleSubmit}>
                <div>
                    <label>Echo: </label>
                    <input type="text" value={this.state.value} onChange={this.handleMessageChanged} />
                    <input type="submit" value="Send" />
                </div>
                <div>
                    <label>Backend API URL: </label>{ this.restConnector.getBackendUrl() }
                </div>
            </form>
        )
    }

}

export default Echo;
