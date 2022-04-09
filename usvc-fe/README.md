# Raberix Dashboard

Use Node.js of ver. >= 14.

### Running the application

1. Set the environment variable ```REACT_APP_RABERIX_BACKEND_API``` to the backend API, e.g.:
```
> export REACT_APP_RABERIX_BACKEND_API=http://localhost:8085
```


2. Start the application
* Development mode:
```
> npm start
```

* Production mode:
```
> npm run build
```
Copy the files from ```build/``` dir to NGINX server.
