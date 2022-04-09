import React from 'react';

export default class RestConnector {

    constructor() {
        this.backend_url = process.env.REACT_APP_RABERIX_BACKEND_API;
        this.auth_token = "TODO";
    }

    async get(path) {
        return await this.request("GET", path, undefined)
    }

    async post(path, body) {
        return await this.request("POST", path, body)
    }

    async request(method, path, body) {
        try {
            const resp = await fetch(
                this.backend_url + path,
                {
                    method: method,
                    headers: {
                        "Accept": "application/json",
                        "Authorization": this.auth_token
                    },
                    body: body
                }
            );
            if (resp.ok) {
                return await resp.json();
            } else {
                console.error('Response status: ' + resp.status);
            }

        } catch (ex) {
            console.error(ex);
            return undefined;
        }
    }

}
