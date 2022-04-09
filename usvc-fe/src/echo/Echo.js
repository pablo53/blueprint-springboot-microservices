import React, { Component } from 'react';
import '../common/Common.css';
import './Echo.css';
import RestConnector from "../common/RestConnector";

class Echo extends Component {

    constructor(props) {
        super(props);
        this.state = { value: process.env.REACT_APP_RABERIX_BACKEND_API };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleMessageChanged = this.handleMessageChanged.bind(this);
    }

    handleSubmit(event) {
        (new RestConnector()).get("/proxy/echo/" + encodeURIComponent(this.state.value)).then(
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
                <label>Echo: </label>
                <input type="text" value={this.state.value} onChange={this.handleMessageChanged} />
                <input type="submit" value="Send" />
            </form>
        )
    }

}

export default Echo;
