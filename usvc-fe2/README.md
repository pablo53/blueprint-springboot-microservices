# Blueprint Microservice Front-End no. 2

## Starting up the application

### Prepare
1. Install node.js with npm (depends on Your OS and package manager)
2. Install Angular CLI

`npm install -g @angular/cli`

3. Download modules as per `package.json`

`npm install`

(Note that `package-lock.json` will be generated).

### Run the application

`npm start`

or

`ng serve`

(The latter may fail, e.g. on Ubuntu, if `ng` command is not on the search path after installing Angular CLI.)

Then, open Your brower and choose this link: `http://localhost:4200/`.

## Development

### Generating new component

`ng generate component component-name`

Alternatively, `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

`npm build`

or

`ng build`

(The latter may fail, e.g. on Ubuntu, if `ng` command is not on the search path after installing Angular CLI.)

The output wil be located in `dist/` directory.

### Running unit tests (Karma)

`npm test`

or

`ng test`

(The latter may fail, e.g. on Ubuntu, if `ng` command is not on the search path after installing Angular CLI.)

### Running end-to-end tests

`ng e2e`

(Not working by default!)
